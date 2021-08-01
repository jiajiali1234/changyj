package com.boot.siluboot.demo.consumer.controller.proinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ths.boot.core.base.controller.BaseController;
import ths.boot.core.base.model.Paging;
import ths.boot.core.base.model.ResponseData;
import com.boot.siluboot.demo.consumer.feign.proinfo.ProInfoFeign;
import com.boot.siluboot.demo.model.ProInfo;

/**
*
* 增删改示例代码
* @author anjh
* @since 2020年7月10日
*/
@Slf4j
@RestController
public class ProInfoFeignController extends BaseController {
	@Autowired
	private ProInfoFeign proInfoFeign;
	@RequestMapping("/consumer/feign/proinfo/pagelist")
	public ResponseData<Paging<ProInfo>> pageList(Paging<ProInfo> pageInfo,
												  @RequestParam(required=false) MultiValueMap<String, String> queryMap) {
		ResponseData<Paging<ProInfo>> responseData = proInfoFeign.pageList(pageInfo,queryMap);
		//获取data中的数据返回
		return responseData;
	}
}
