/**
 * Filename:	Message.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午1:26:40
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.com.bean;

import czx.com.util.ExceptionDealUtil;

/**  
 * @ClassName	Message.java
 * @Package  	czx.com.bean
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午1:26:40
 * @version V1.0  
 */
public class Message {

	private int id;
	private boolean success;
	private String message;
	private String redirectUrl;
	
	public Message(){
		
	}
	
	public Message(boolean success,String message){
		this.success = success;
		this.message = message;
	}
	
	public Message(int id,boolean success,String message){
		this.id = id;
		this.success = success;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	public void setSuccessMsg(String message){
		this.success = true;
		this.message = message;
	}
	
}


