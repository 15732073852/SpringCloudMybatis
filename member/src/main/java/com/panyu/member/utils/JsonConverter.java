//package com.panyu.member.utils;
//
//import com.alibaba.fastjson.JSONObject;
//import org.dozer.CustomConverter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class JsonConverter implements CustomConverter {
//	static final Logger LOGGER = LoggerFactory.getLogger(JsonConverter.class);
//	@Override
//	public Object convert(Object existingDestinationFieldValue,Object sourceFieldValue, Class<?> destinationClass,Class<?> sourceClass) {
//		if (null != sourceFieldValue) {
//            if (sourceFieldValue instanceof String) {
//               return JSONObject.parseObject(sourceFieldValue.toString(), destinationClass);
//            } else if (!(sourceFieldValue instanceof String)) {
//				String jsonString = JSONObject.toJSONString(sourceFieldValue);
//            	return jsonString;
//            }
//        }
//		return null;
//	}
//}
