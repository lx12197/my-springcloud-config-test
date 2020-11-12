package com.mw.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${foo}")
    String foo;

    /**
     * 当配置文件修改且推送的远程仓库后需要调用以下接口对bus进行刷新，使bus服务重新拉去配置文件；
     * http://localhost:8110/actuator/bus-refresh
     * @return
     */
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }

}
