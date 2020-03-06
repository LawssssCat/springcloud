package com.spring.sp01.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.sp01.pojo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

	private static ObjectMapper mapper;

	static {
		try {
			initMapper();
		} catch (Exception e) {
			log.error("jackson config error", e);
		}
	}

	private static void initMapper() {
		mapper = new ObjectMapper();
	}

	public static <V> String to(V v) {
		try {
			return mapper.writeValueAsString(v);
		} catch (JsonProcessingException e) {
			log.error("jackson to error, obj: {}", v, e);
			return null;
		}
	}

	public static <V> V from(String json, TypeReference<V> type) {
		try {
			return mapper.readValue(json, type);
		}catch (Exception e) {
			log.error("jackson from error, json: {}", json, type, e);
			return null ; 
		}
	}

}
