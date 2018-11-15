package com.moka.annotation;
/**
* @author    created by lbq
* @date	     2018年11月13日 下午3:35:51
**/

/**
 * 
 * 是否需要从解析excel赋值
 * @author daochuwenziyao
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public @interface IsNeeded {
	 
    /**
     * 是否需要从解析excel赋值
     * @return
     *         true:需要  false:不需要
     * @see [类、类#方法、类#成员]
     */
    boolean isNeeded() default true;
}
