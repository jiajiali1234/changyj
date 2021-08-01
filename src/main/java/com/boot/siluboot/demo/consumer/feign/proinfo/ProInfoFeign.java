package com.boot.siluboot.demo.consumer.feign.proinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ths.boot.core.base.model.Paging;
import ths.boot.core.base.model.ResponseData;
import com.boot.siluboot.demo.model.ProInfo;
/**
 * name = "provideDemo" 为服务提供者的服务标识
 * fallback = ProInfoFeign.ProInfoFeignFallback.class 为服务调用失败时，调用的方法
 */
@FeignClient(name = "provideDemo",
        path = "/",
        fallback = ProInfoFeign.ProInfoFeignFallback.class)
public interface ProInfoFeign {
    @RequestMapping("/provide/proinfo/pagelist")
    ResponseData<Paging<ProInfo>> pageList(Paging<ProInfo> pageInfo,
                                           @RequestParam(required=false) MultiValueMap<String, String> queryMap);
    /**
     * 服务调用失败时调用的方法
     */
    @Component
    @Slf4j
    class ProInfoFeignFallback implements ProInfoFeign {
        @Override
        public ResponseData<Paging<ProInfo>> pageList(Paging<ProInfo> pageInfo, MultiValueMap<String, String> queryMap) {
            return ResponseData.badResp(null).setMessage("异常处理");
        }
    }
}