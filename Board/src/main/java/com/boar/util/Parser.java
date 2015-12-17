package com.boar.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
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
	
	public String parseObject() {
		if (t != null) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.writeValueAsString(t);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
	public String parseList() {
		if (list != null) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				String json = "{\"records\":[";
				
				for (T obj : list) {
					json += mapper.writeValueAsString(obj);
					json += ",";
				}
				
				json = json.substring(0, json.length()-1) + "]}";
				return json;
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
}
