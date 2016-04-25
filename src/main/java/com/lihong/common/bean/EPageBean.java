package com.lihong.common.bean;

import java.util.List;

public class EPageBean<T> extends PageBean<T> {
    private int pageSize;
    //展示数据
    private List<T> rows;
    //总数据量
    private long total;
    //当前页
    private int currentPage;
    //计算出来的
    //总页数
    private int pageCount;
    //页码列表的开始索引
    private int beginPageIndex;
    //页面列表的结束索引
    private int endPageIndex;
    
    public EPageBean() {
        
    }
    
    
    
    public EPageBean(int pageSize, List<T> rows, long total, int currentPage) {
        super();
        this.rows = rows;
        this.total = total;
        this.currentPage = currentPage;
        //计算总页数
        pageCount = (int) ((total + pageSize -1)/pageSize);
        
        if(pageCount <= 10){
            beginPageIndex = 1;
            endPageIndex = pageCount;
        }else{
            beginPageIndex = currentPage - 4;
            endPageIndex = currentPage + 5;
            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 10;
            }
            if (endPageIndex > pageCount) {
                endPageIndex = pageCount;
                beginPageIndex = pageCount - 10 + 1;                
            }
        }
    }



    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }




    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }



    public int getPageCount() {
        return pageCount;
    }





    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }



    public int getBeginPageIndex() {
        return beginPageIndex;
    }



    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }



    public int getEndPageIndex() {
        return endPageIndex;
    }



    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }



    public List<T> getRows() {
        return rows;
    }



    public void setRows(List<T> rows) {
        this.rows = rows;
    }



    public long getTotal() {
        return total;
    }



    public void setTotal(long total) {
        this.total = total;
    }


}
