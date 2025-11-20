package com.example.IWasHere.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        String clientIp = getClientIp(request);
        log.info("Accesed! From IP: " + clientIp);
        return "index.html";
    }

    private String getClientIp(HttpServletRequest request) {
        String clientIp = request.getHeader("x-forwarded-for");
        if (clientIp == null || clientIp.isEmpty() || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }
}