package com.spring.controller;

public class ViewResolver {
	public String prefix;
	public String suffix;
	// 멤버변수 의존주입(DI)를 setter주입으로 진행
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
