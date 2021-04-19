package com.ce.ribbonservice.controller;

import com.ce.ribbonservice.domain.CommonResult;
import com.ce.ribbonservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author c__e
 * @date 2021/4/15 10:00
 */
@RestController
@SuppressWarnings("all")
public class UserRibbonController {

    @Autowired
    @Qualifier("restTemplate1")
    private RestTemplate restTemplate1;

    @Resource(name = "restTemplate2")
    private RestTemplate restTemplate2;

    @Value("${service-url.user-service}")
    private String userServiceUrl;
    @Value("${service-url.user-service-ip}")
    private String userServiceUrlIP;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return restTemplate1.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    @GetMapping("/user/{id}")
    public CommonResult getUser1(@PathVariable Long id) {
        return restTemplate2.getForObject(userServiceUrlIP + "/user/{1}", CommonResult.class, id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username) {
        return restTemplate1.getForObject(userServiceUrl + "/user/getByUsername?username={1}", CommonResult.class, username);
    }

    @GetMapping("/getEntityByUsername")
    public CommonResult getEntityByUsername(@RequestParam String username) {
        ResponseEntity<CommonResult> entity = restTemplate1.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", CommonResult.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult("操作失败", 500);
        }
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return restTemplate1.postForObject(userServiceUrl + "/user/create", user, CommonResult.class);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return restTemplate1.postForObject(userServiceUrl + "/user/update", user, CommonResult.class);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return restTemplate1.postForObject(userServiceUrl + "/user/delete/{1}", null, CommonResult.class, id);
    }

}
