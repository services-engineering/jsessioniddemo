package com.d2iq.jsessiondemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/getsession")
    public String jsessionEndpoint(HttpSession session, @RequestParam Boolean simulateTimeout) throws InterruptedException {

        logger.info("Request from: " + session.getId() + " Simulating Timeout: " + simulateTimeout);

        if (simulateTimeout) {
            Thread.sleep(30000);
        }

        return session.getId();
    }

}
