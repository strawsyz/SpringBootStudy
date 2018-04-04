package com.wisely.ch7_6.domain;
//服务端用来发消息的类
public class WiselyResponse {
	private String responseMessage;
	
	public WiselyResponse(String responseMessage){
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
	
}
