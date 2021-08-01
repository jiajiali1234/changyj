/*
 * Copyright(C) 2000-2020 THS Technology Limited Company, http://www.ths.com.cn
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

package ths.boot;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ths.boot.core.context.SpringBootContextHelper;

/**
 * @author anjh
 * @desc 项目启动入口
 * {@link EnableScheduling} 开启定时任务支持
 * {@link EnableTransactionManagement} 开启事务支持
 * {@link EnableAsync} 开启异步方法执行支持
 * @since 2020年03月02日 星期一 21:27:15
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
// 开启定时任务
/*@EnableScheduling*/
// 开启事务支持
@EnableTransactionManagement
// 开启异步方法执行支持
@EnableAsync
// 开启缓存机制
@EnableCaching
//开启注册发现
@EnableDiscoveryClient
//开启FeignClient
@EnableFeignClients
@Slf4j
@RestController
@RefreshScope
public class CloudAlibabaDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaDemoApp.class, args);
        ApplicationContext applicationContext = SpringBootContextHelper.getApplicationContext();
        WebServerApplicationContext webServerApplicationContext = (WebServerApplicationContext)applicationContext;
        String applicationName = applicationContext.getApplicationName();
        int port = webServerApplicationContext.getWebServer().getPort();
        log.info("THS-BOOT项目启动成功..."+"http://localhost:"+port+"/"+applicationName);
    }

    @GetMapping(value = {"/"})
    public String index() {
        return "欢迎使用JDP5.0微服务开发平台.";
    }

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
