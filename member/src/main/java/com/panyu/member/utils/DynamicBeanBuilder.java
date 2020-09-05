//package com.panyu.member.utils;
//
//import net.sf.cglib.beans.BeanGenerator;
//import net.sf.cglib.beans.BeanMap;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//@SuppressWarnings("all")
//public class DynamicBeanBuilder {
//
//	private Object object = null;// 动态生成的类
//	private BeanMap beanMap = null;// 存放属性名称以及属性的类型
//
//	private Class superclass = null; //超类
//
//	@SuppressWarnings("rawtypes")
//	public DynamicBeanBuilder(Map propertyMap) {
//		init(propertyMap);
//	}
//
//	public DynamicBeanBuilder(Class superclass,Map propertyMap) {
//		this.superclass = superclass;
//		init(propertyMap);
//	}
//
//	private void init(Map propertyMap){
//		this.object = generateBean(propertyMap);
//		this.beanMap = BeanMap.create(this.object);
//	}
//
//	/**
//	 * 给bean属性赋值
//	 * @param property 属性名
//	 * @param value 值
//	 */
//	public void setValue(Object property, Object value) {
//		beanMap.put(property, value);
//	}
//
//	/**
//	 * 通过属性名得到属性值
//	 * @param property 属性名
//	 * @return 值
//	 */
//	public Object getValue(String property) {
//		return beanMap.get(property);
//	}
//
//	/**
//	 * 得到该实体bean对象
//	 * @return
//	 */
//	public Object getObject() {
//		return this.object;
//	}
//
//	/**
//	 * @param propertyMap
//	 * @return
//	 */
//	@SuppressWarnings("rawtypes")
//	private Object generateBean(Map propertyMap) {
//		BeanGenerator generator = new BeanGenerator();
//		if(superclass!=null){
//			generator.setSuperclass(superclass);
//		}
//		Set keySet = propertyMap.keySet();
//		for (Iterator i = keySet.iterator(); i.hasNext();) {
//			String key = (String) i.next();
//			generator.addProperty(key, (Class) propertyMap.get(key));
//		}
//		return generator.create();
//	}
//
//	@SuppressWarnings("all")
//	public static Object toObject(Map map,Class superclass) {
//		Map propertyMap = new HashMap();
//		Set<Map.Entry> entrys = map.entrySet();
//		for(Map.Entry entry :entrys){
//			propertyMap.put(entry.getKey(), entry.getValue().getClass());
//		}
//
//		DynamicBeanBuilder builder = null;
//		if(superclass!=null){
//			builder = new DynamicBeanBuilder(superclass,propertyMap);
//		}
//		else{
//			builder = new DynamicBeanBuilder(propertyMap);
//		}
//
//		for(Map.Entry entry :entrys){
//			builder.setValue(entry.getKey(), entry.getValue());
//		}
//		return builder.getObject();
//	}
//}
