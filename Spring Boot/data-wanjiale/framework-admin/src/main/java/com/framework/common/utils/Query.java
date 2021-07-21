package com.framework.common.utils;

import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class Query<T> extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	/**
	 * mybatis-plus分页参数
	 */
	private Page<T> page;
	/**
	 * 当前页码
	 */
	private int currPage = 1;
	/**
	 * 每页条数
	 */
	private int limit = 10;

	//为了兼容以前生成好的代码不报错，只能重载方法
	public Query(Map<String, Object> params) {
		this(params, null);
	}

	public Query(Map<String, Object> params, Class entityClass) {
		this.putAll(params);

		// 分页参数
		if (!ObjectUtils.isEmpty(params.get("page"))) {
			currPage = Integer.parseInt((String) params.get("page"));
		}
		if (!ObjectUtils.isEmpty(params.get("limit"))) {
			limit = Integer.parseInt((String) params.get("limit"));
		}

		this.put("offset", (currPage - 1) * limit);
		this.put("page", currPage);
		this.put("limit", limit);

		// 防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
		String sidx = SQLFilter.sqlInject((String) params.get("sidx"));
		String order = SQLFilter.sqlInject((String) params.get("order"));
		this.put("sidx", sidx);
		this.put("order", order);

		// mybatis-plus分页
		this.page = new Page<>(currPage, limit);

		//set query params
		Map<String, Object> sqlParams = Maps.newHashMap();

		if(entityClass != null){
			for(Map.Entry<String, Object> entry : params.entrySet()){
				if(entry.getValue() instanceof String && StringUtils.isBlank((String)entry.getValue())){
					//字符串空值判断
					continue;
				}
				if(BeanUtils.getPropertyDescriptor(entityClass, entry.getKey()) == null){
					//过滤掉不是entity里面属性的参数
					continue;
				}
				sqlParams.put(CommonUtils.underscoreName(entry.getKey()), entry.getValue());
			}
			this.page.setCondition(sqlParams);
		}

		// 排序
		if (StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)) {
			this.page.setOrderByField(sidx);
			this.page.setAsc("ASC".equalsIgnoreCase(order));
		}

	}

	public Page<T> getPage() {
		return page;
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getLimit() {
		return limit;
	}
}
