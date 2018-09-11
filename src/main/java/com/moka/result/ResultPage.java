package com.moka.result;
/**
* @author    created by lbq
* @date	     2018年9月11日 上午11:24:01
**/
public class ResultPage<T> extends Result<T>{


	private Integer pageIndex;
	private Integer pageSize;
	private Long pageCount;
	public ResultPage() {
		super();
    }
	public ResultPage(String code, String msg) {
        super(code, msg);
    }

    public ResultPage(T data) {
    	super(data);
    }
    public ResultPage(T data, Long pageCount) {
    	super(data);
    	this.pageCount = pageCount;
    }
    public ResultPage(T data, Integer pageIndex, Integer pageSize, Long pageCount) {
    	super(data);
    	this.pageIndex = pageIndex;
    	this.pageSize = pageSize;
    	this.pageCount = pageCount;
    }
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
	

}
