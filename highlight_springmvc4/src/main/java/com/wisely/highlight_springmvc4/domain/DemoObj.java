package com.wisely.highlight_springmvc4.domain;

public class DemoObj {
	private Long id ; 
	private String name;
	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public DemoObj() {//jackson对对象和json做转换时一定需要这个空构造函数
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
