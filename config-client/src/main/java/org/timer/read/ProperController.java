package org.timer.read;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2019/10/18 14 18
 */
@RestController
@RefreshScope
public class ProperController {

    @Value("${info.from}")
    String from;
    @GetMapping("/proper")
    public String dc(){
        return "dd"+from;
    }
}
