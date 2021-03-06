package com.lihong.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lihong.bean.Case;
import com.lihong.common.util.LuceneIKUtil;
import com.lihong.common.util.SegmentUtil;

public class NettyServerHandler extends ChannelHandlerAdapter {
    private static Logger logger = Logger.getLogger(NettyServerHandler.class);
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    
    ByteBuf buf = (ByteBuf) msg;
    
    String recieved = getMessage(buf);
    logger.info("服务器接收到消息：" + recieved);
    
    Map<String,Integer> map = SegmentUtil.Segment(recieved); 
   
    if(map !=null && map.size() != 0){
        Case c = LuceneIKUtil.search(map);
        if(c != null){
            try {
                logger.info("发送给客户端消息：" + c.getContent());
                ctx.writeAndFlush(getSendByteBuf(c.getContent()));
              } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
              }
        }
    }
    
  }

  /*
   * 从ByteBuf中获取信息 使用UTF-8编码返回
   */
  private String getMessage(ByteBuf buf) {

    byte[] con = new byte[buf.readableBytes()];
    buf.readBytes(con);
    try {
      return new String(con,"UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  private ByteBuf getSendByteBuf(String message)
      throws UnsupportedEncodingException {

    byte[] req = message.getBytes("UTF-8");
    ByteBuf pingMessage = Unpooled.buffer();
    pingMessage.writeBytes(req);

    return pingMessage;
  }
}