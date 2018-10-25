package com.moka.qiniuyun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年10月24日 下午2:15:39
**/
@Data
@Component
public class ConstantQiniu {
	  @Value("${qiniu.accessKey}")
	    private String accessKey;

	    @Value("${qiniu.secretKey}")
	    private String secretKey;

	    @Value("${qiniu.bucket}")
	    private String bucket;

	    @Value("${qiniu.path}")
	    private String path;
}
