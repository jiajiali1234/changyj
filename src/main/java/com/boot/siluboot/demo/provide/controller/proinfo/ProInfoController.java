/*
 * Copyright(C) 2000-2020 THS Technology Limited Company, http://www.ths.com.cn
 * http://localhost:8083/provide/proinfo/pagelist
 * http://localhost:8083/provide/proinfo/deleteone?proId=123
 */

package com.boot.siluboot.demo.provide.controller.proinfo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ths.boot.core.base.controller.BaseController;
import ths.boot.core.base.model.Paging;
import ths.boot.core.base.model.ResponseData;
import com.boot.siluboot.demo.model.ProInfo;
import com.boot.siluboot.demo.provide.service.proinfo.ProInfoService;

import java.util.List;
import java.util.Map;


/**
*
* 增删改示例代码
* @author anjh
* @since 2020年7月10日
 *
*/
@Slf4j
@RestController
public class ProInfoController extends BaseController {
	 
	@Autowired
	private ProInfoService proInfoService;

	@Value("${server.port}")
	public String serverPort;

	@RequestMapping("/provide/proinfo/pagelist")
	public ResponseData<Paging<ProInfo>> pageList(Paging<ProInfo> pageInfo,
												  @RequestParam(required=false) Map<String, Object> queryMap) {
		// 设置默认排序
		if (StringUtils.isEmpty(pageInfo.getOrderBy())) {
			//SQL Server数据库必须提供默认排序条件，否则数据库在分页时会报错
			//注意：要增加一个唯一键（ PRO_ID）的默认排序，不然分页可能会乱
			pageInfo.setOrderBy("CREATE_DATE DESC , PRO_ID DESC");
		}
		Paging<ProInfo> result = proInfoService.pageList(pageInfo, queryMap);
		log.info("我是："+serverPort);
		return ResponseData.okResp(result).setMessage("我是："+serverPort);
	}
	
	@RequestMapping("/provide/proinfo/list")
	public ResponseData<List<ProInfo>> list(@RequestParam(required=false) Map<String, Object> queryMap) {
		List<ProInfo> result = proInfoService.list(queryMap);
		return ResponseData.okResp(result);
	}
	
	@RequestMapping("/provide/proinfo/get")
	public ResponseData<ProInfo> get(@RequestParam(required=true) String proId) {
		ProInfo result = proInfoService.get(proId);
		return ResponseData.okResp(result);
	}
	
	@RequestMapping("/provide/proinfo/insert")
	public ResponseData<String> insert(@RequestParam(required=true) ProInfo proInfo) {
		int affectCount = proInfoService.insert(proInfo);
		return ResponseData.okResp("插入"+affectCount+"条数据");
	}
	
	@RequestMapping("/provide/proinfo/update")
	public ResponseData<String> update(@RequestParam(required=true) ProInfo proInfo) {
		int affectCount = proInfoService.update(proInfo);
		return ResponseData.okResp("更新"+affectCount+"条数据");
	}
	
	@RequestMapping("/provide/proinfo/deleteone")
	public ResponseData<String> deleteOne(@RequestParam(required=true) String proId) {
		int affectCount = proInfoService.deleteOne(proId);
		return ResponseData.okResp("删除"+affectCount+"条数据");
	}
	
	@RequestMapping("/provide/proinfo/delete")
	public ResponseData<String> delete(@RequestParam(required=true) String proIds) {
		int affectCount = proInfoService.delete(proIds);
		return ResponseData.okResp("删除"+affectCount+"条数据");
	}
	
}
