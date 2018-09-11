package com.moka.result;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.moka.Enum.CodeEnum;

public class Result<T> {
	//错误码
	private String code;
	//错误信息
	private String msg;
	private boolean isApproval = false;
	//具体的内容
	private T data;
	public Result() {
    }
	public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = CodeEnum.SUCCESS.getMsg();
        this.data = data;
    }
    public Result(T data, boolean isApproval) {
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = CodeEnum.SUCCESS.getMsg();
        this.data = data;
        this.isApproval = isApproval;
    }
    
	public boolean isApproval() {
		return isApproval;
	}
	public void setApproval(boolean isApproval) {
		this.isApproval = isApproval;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public static <T> Result<T> create(String code, String msg) {
        return new Result<>(code, msg);
    }
	public static <T> Result<T> create(T data) {
        return new Result<T>(data);
    }
	public static <T> ResultPage<T> createPage(String code, String msg) {
		return new ResultPage<>(code, msg);
    }
	public static <T> ResultPage<T> createPage(T data) {
        return new ResultPage<>(data);
    }
	public static <T> ResultPage<T> createPage(T data, Integer pageIndex, Integer pageSize, Long pageCount) {
        return new ResultPage<>(data, pageIndex, pageSize, pageCount);
    }
	public static <T> ResultPage<T> createPage(T data, Long pageCount) {
        return new ResultPage<>(data, pageCount);
    }
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
