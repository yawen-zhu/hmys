package com.hmys.frame.core.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;



/**
 *
 * @ClassName: BeanUtils
 * @Description: 对Bean进行操作的相关工具方法
 * @author zhuyawen
 * @date 2017年11月28日 下午10:44:26
 *
 */
public class BeanUtils {

	/**
	 * 将Bean对象转换成Map对象，将忽略掉值为null或size=0的属性
	 * 
	 * @param obj
	 *            对象
	 * @return 若给定对象为null则返回size=0的map对象
	 */
	public static Map<String, Object> toMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return map;
		}
		BeanMap beanMap = new BeanMap(obj);
		Iterator<String> it = beanMap.keyIterator();
		while (it.hasNext()) {
			String name = it.next();
			Object value = beanMap.get(name);
			// 转换时会将类名也转换成属性，此处去掉
			if (value != null && !name.equals("class")) {
				map.put(name, value);
			}
		}
		return map;
	}
}