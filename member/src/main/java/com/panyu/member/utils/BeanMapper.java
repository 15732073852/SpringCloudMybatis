//package com.panyu.member.utils;
//
//import com.google.common.collect.Lists;
//import org.apache.commons.lang3.ObjectUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
///**
// * 简单封装Dozer, 实现深度转换Bean<->Bean的Mapper.实现:
// *
// * 1. 持有Mapper的单例.
// * 2. 返回值类型转换.
// * 3. 批量转换Collection中的所有对象.
// * 4. 区分创建新的B对象与将对象A值复制到已存在的B对象两种函数.
// *
// * @author calvin
// */
//public class BeanMapper {
//
//	final static Logger LOGGER = LoggerFactory.getLogger(BeanMapper.class);
//
//	/**
//	 * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
//	 */
//	private static DozerBeanMapper dozer = new DozerBeanMapper();
//
//	/**
//	 * 订制持有Dozer单例, 避免重复创建DozerMapper消耗资源.
//	 */
//	private static DozerBeanMapper customDozer = new DozerBeanMapper();
//
//	/**
//	 * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
//	 */
//	//private static DozerBeanMapper ignoreNullDozer;
//
//	static{
//		List<String> mapperFiles = new ArrayList<String>();
//		URL path = BeanMapper.class.getResource("dozer-global-configuration.xml");
//		mapperFiles.add(path.toString());
//		customDozer.setMappingFiles(mapperFiles);
//	}
//
//	/**
//	 * 基于Dozer转换对象的类型.
//	 */
//	public static <T> T map(Object source, Class<T> destinationClass) {
//		return dozer.map(source, destinationClass);
//	}
//
//	/**
//	 * 基于Dozer转换Collection中对象的类型.
//	 */
//	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
//		List<T> destinationList = Lists.newArrayList();
//		for (Object sourceObject : sourceList) {
//			T destinationObject = dozer.map(sourceObject, destinationClass);
//			destinationList.add(destinationObject);
//		}
//		return destinationList;
//	}
//
//	/**
//	 * 基于Dozer转换Collection中对象的类型.
//	 */
//	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass,boolean ignoreNull) {
//		if (ignoreNull) {
//			List<T> destinationList = Lists.newArrayList();
//			for (Object sourceObject : sourceList) {
//				T destinationObject = customDozer.map(sourceObject, destinationClass);
//				destinationList.add(destinationObject);
//			}
//			return destinationList;
//		}else {
//			return mapList(sourceList,destinationClass);
//		}
//	}
//
//	/**
//	 * 基于Dozer转换Collection中对象的类型.
//	 */
//	public static <T> List<T> mapList(Iterable sourceList, Class<T> destinationClass) {
//
//		List<T> destinationList = Lists.newArrayList();
//
//		for (Object sourceObject : sourceList) {
//			T destinationObject = dozer.map(sourceObject, destinationClass);
//			destinationList.add(destinationObject);
//		}
//
//		return destinationList;
//	}
//
//	/**
//	 * 基于Dozer转换Collection中对象的类型.
//	 */
//	public static <T> List<T> mapList(Iterable sourceList, Class<T> destinationClass,boolean ignoreNull) {
//
//		List<T> destinationList = Lists.newArrayList();
//
//		if(ignoreNull){
//			for (Object sourceObject : sourceList) {
//				T destinationObject = customDozer.map(sourceObject, destinationClass);
//				destinationList.add(destinationObject);
//			}
//		}else{
//			destinationList = mapList(sourceList, destinationClass);
//		}
//
//		return destinationList;
//	}
//
//	/**
//	 * 基于Dozer将对象A的值拷贝到对象B中.
//	 * @param source
//	 * @param destinationObject
//	 * @param ignoreNull
//	 */
//	public static void copy(Object source, Object destinationObject,boolean ignoreNull) {
//		if(ignoreNull){
//			customDozer.map(source, destinationObject);
//		}
//		else{
//			dozer.map(source, destinationObject);
//		}
//	}
//
//	public static <T> T copy(Object source, Class<T> destinationClass,boolean ignoreNull) {
//        if(ignoreNull){
//            return customDozer.map(source, destinationClass);
//        }
//        else{
//            return dozer.map(source, destinationClass);
//        }
//    }
//
//	public static Map<String,String> toMap(Object source,boolean ignoreNull) {
//		Map temp = new HashMap();
//		if(ignoreNull){
//			temp= customDozer.map(source, HashMap.class);
//        }
//        else{
//        	temp= dozer.map(source, HashMap.class);
//        }
//		Map<String,String> result = new HashMap<String,String>();
//		for(Iterator it=temp.entrySet().iterator();it.hasNext();){
//			Entry e=(Entry)it.next();
//			Object key = e.getKey();
//			Object value = e.getValue();
//			if(key!=null){
//				result.put(key.toString(), ObjectUtils.toString(value));
//			}
//		}
//
//		return result;
//	}
//
//	/**
//	 * 基于Dozer将对象A的值拷贝到对象B中.
//	 * @param source
//	 * @param destinationObject
//	 */
//	public static void copy(Object source, Object destinationObject) {
//		copy( source, destinationObject,false);
//	}
//}