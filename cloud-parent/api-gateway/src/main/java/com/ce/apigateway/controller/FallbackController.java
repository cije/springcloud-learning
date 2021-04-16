package com.ce.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author c__e
 * @date 2021/4/16 16:35
 */
@RestController
public class FallbackController {
    @RequestMapping("/fallback")
    public Object fallback() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", null);
        result.put("message", "Get request fallback!");
        result.put("code", 500);
        return result;
    }
}
