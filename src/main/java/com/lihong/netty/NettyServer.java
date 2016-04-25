package com.lihong.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.List;

import org.apache.log4j.Logger;


public class NettyServer{

    private static Logger logger = Logger.getLogger(NettyServer.class);
    private List<Integer> ports;
    private ChannelHandler channelHandler;
  
    public ChannelHandler getChannelHandler() {
        return channelHandler;
    }
    public void setChannelHandler(ChannelHandler channelHandler) {
		this.channelHandler = channelHandler;
	}
	
 	
	public List<Integer> getPorts() {
        return ports;
    }
    public void setPorts(List<Integer> ports) {
        this.ports = ports;
    }
    
    public NettyServer() {
	   
    }
	
    public void start(){
        for(Integer port : ports){
            new NettyThread(port).start();
        }
    }

	

  class NettyThread extends Thread{
      private int port;
      NettyThread(Integer port){
          this.port = port;
      }
      @Override
      public void run() {
          bind(port);
      }

      private void bind(int port) {
      EventLoopGroup boss = new NioEventLoopGroup();
      EventLoopGroup worker = new NioEventLoopGroup();

      try {

        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(boss, worker);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024); //连接数
        bootstrap.option(ChannelOption.TCP_NODELAY, true);  //不延迟，消息立即发送
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, false); //长连接
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel socketChannel)
              throws Exception {
            ChannelPipeline p = socketChannel.pipeline();
            p.addLast(new NettyServerHandler());
          }
        });
        ChannelFuture f = bootstrap.bind(port).sync();
        if (f.isSuccess()) {
          logger.debug("启动Netty服务成功，端口号：" + port);
        }
        // 关闭连接
        f.channel().closeFuture().sync();

      } catch (Exception e) {
        logger.error("启动Netty服务异常，异常信息：" + e.getMessage());
        e.printStackTrace();
      } finally {
        boss.shutdownGracefully();
        worker.shutdownGracefully();
      }
    }
  }
}