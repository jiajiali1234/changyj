/*
 * Copyright(C) 2000-2011 THS Technology Limited Company, http://www.ths.com.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.boot.siluboot.demo.provide.service.proinfo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ths.boot.core.base.model.Paging;
import ths.boot.core.base.service.BaseService;
import com.boot.siluboot.demo.model.ProInfo;

/**
 *
 * 增删改示例代码
 * @author anjh
 * @since 2020年7月10日
 */
@Service
public class ProInfoService extends BaseService<ProInfo> {
	/**
     * 对应mapper.xml的namespace
     */
    private final String sqlPackage = "com.boot.model.ProInfoMapper";
    
    /** 
     * @param pageInfo 分页对象
     * @param queryMap 查询条件queryMap<String, Object>
     * @return Paging<ProInfo>
     */
    @Cacheable("JDP.PROJECT")
    public Paging<ProInfo> pageList(Paging<ProInfo> pageInfo, Map<String, Object> queryMap) {
		Paging<ProInfo> result = super.modelDao.list(pageInfo, queryMap, sqlPackage + ".list");
		return result;
	}
    
    /**
     * @param queryMap 查询条件queryMap<String, Object>
     * @return List<ProInfo>
     */
	@Cacheable("JDP.PROJECT")
    public List<ProInfo> list(Map<String, Object> queryMap) {
		List<ProInfo> result = super.modelDao.list(queryMap, sqlPackage + ".list");
		return result;
	}
    
    //@Cacheable(key="#id")
  	public ProInfo get(String proId) {
  		return super.modelDao.get(proId, sqlPackage + ".get");
  	} 
    
    public int insert(ProInfo proInfo) {
    	if (StringUtils.isBlank(proInfo.getProId())) {
    		proInfo.setProId(UUID.randomUUID().toString().replace("-", ""));
		}
    	return super.modelDao.insert(proInfo, sqlPackage + ".insert");
	}
	
    public int update(ProInfo proInfo) {
    	return super.modelDao.update(proInfo, sqlPackage + ".update");
	}
    
    /**
	 * 删除一条示例
	 * 参数类型为基础数据类型示例
	 * @param proId
	 */
    @CacheEvict(value = "JDP.PROJECT", allEntries = true)
	public int deleteOne(String proId) {
		return super.modelDao.delete(proId, sqlPackage + ".deleteOne");
	}
    
    /**
	 * 删除多条数据示例
	 * 传入mapper的是一个Array
	 * 注意查看mapper.xml中的对应参数怎么写
	 *
	 * @param ids
	 */
	public int delete(String proIds) {
		if (StringUtils.isEmpty(proIds)) {
			return 0;
		}
		return super.modelDao.delete(proIds.split(","), sqlPackage + ".delete");
	}

}
