package com.moka.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moka.Enum.CodeEnum;
import com.moka.result.Result;
import com.moka.result.ResultFul;

/**
* @author    created by lbq
* @date	     2018年9月11日 上午11:18:05
**/
@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);
	
	/**
	 * 处理所有接口数据验证异常
	 * @param e
	 * @return
	 */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Object handlerMethodArgumentException(MethodArgumentNotValidException e){
	logger.error(e.getMessage(),e);
	BindingResult bindingResult = e.getBindingResult();
	return ResultFul.create("ERROR", bindingResult.getFieldError().getDefaultMessage());
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Object handle(Exception e) {
		if(e instanceof HandlerException) {
			HandlerException he = (HandlerException) e;
			logger.error("业务异常{}",e);
			return Result.create(he.getCode(), he.getMsg());
		}else if (e instanceof MethodArgumentNotValidException ){
			MethodArgumentNotValidException valid=(MethodArgumentNotValidException) e;
			BindingResult bindingResult =valid.getBindingResult();
			return ResultFul.create("ERROR", bindingResult.getFieldError().getDefaultMessage());
		}else {
			System.err.println(e);
			logger.error("系统异常{}",e);
			return Result.create(CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
		}
	}


}
