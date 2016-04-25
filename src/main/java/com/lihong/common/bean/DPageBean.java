package com.lihong.common.bean;

import java.util.List;
/**
 * 公共的分页列表
 * @author lihong2-ext
 *
 * @param <T>
 */
public class DPageBean<T> extends PageBean<T>{
    //展示数据
    private List<T> data;
    //总数据量
    private long recordsTotal;
    private long recordsFiltered;
    //当前页
    private int draw;
    
    public DPageBean() {
    	
	}
    
    
    
	public DPageBean(int pageSize, List<T> rows, long total, int currentPage) {
		super();
		this.data = rows;
		this.recordsTotal = total;
		this.recordsFiltered = total;
		this.draw = currentPage;
	}


	public int getDraw() {
        return draw;
    }



    public void setDraw(int draw) {
        this.draw = draw;
    }


    public long getRecordsTotal() {
        return recordsTotal;
    }



    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }



    public long getRecordsFiltered() {
        return recordsFiltered;
    }



    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
    
    public List<T> getData() {
        return data;
    }


    public void setData(List<T> data) {
        this.data = data;
    }

}
