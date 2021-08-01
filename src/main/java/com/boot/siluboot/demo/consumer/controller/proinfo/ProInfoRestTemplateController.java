package com.boot.siluboot.demo.consumer.controller.proinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponentsBuilder;
import ths.boot.core.base.controller.BaseController;
import ths.boot.core.base.model.Paging;
import ths.boot.core.base.model.ResponseData;
import com.boot.siluboot.demo.model.ProInfo;
/**
* 增删改示例代码
* @author anjh
* @since 2020年7月10日
*/
@Slf4j
@RestController
public class ProInfoRestTemplateController extends BaseController {
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/consumer/proinfo/pagelist")
	public ResponseData<Paging<ProInfo>> pageList(Paging<ProInfo> pageInfo,
												  @RequestParam(required=false) MultiValueMap<String, String> queryMap) {
		//构造URL参数,provideDemo是服务提供者的服务名
		String url = "http://provideDemo/provide/proinfo/pagelist";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParams(queryMap);
		//构造HttpEntity，可携带header和requestBody类型的参数
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(pageInfo,headers);
		//返回结果
		HttpEntity<ResponseData> response = restTemplate.exchange(
				builder.build().encode().toUri(),
				HttpMethod.POST,
				entity,
				ResponseData.class);
		ResponseData<Paging<ProInfo>> returnData = response.getBody();
		//获取data中的数据返回
		return returnData;
	}
}
