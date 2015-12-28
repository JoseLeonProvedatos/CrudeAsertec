package com.boar.util;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser<T> {
	private T t;
	private List<T> list;
	
	public Parser() {
	}
	
	public Parser(T t) {
		this.t = t;
	}
	
	public Parser(List<T> list) {
		this.list = list;
	}
	
	public T getT() {
		return t;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public String parse() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			if (t != null) {
				return mapper.writeValueAsString(t);
			} else if (list != null) {
				String json = "{\"records\":[";
				
				for (T obj : list) {
					json += mapper.writeValueAsString(obj);
					json += ",";
				}
				
				json = json.substring(0, json.length()-1) + "]}";
				return json;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
