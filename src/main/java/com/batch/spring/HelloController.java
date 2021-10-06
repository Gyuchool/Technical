package com.batch.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    //충돌 테스트 실험 2
    //이러면 충돌이 발생하겠지..?
}
