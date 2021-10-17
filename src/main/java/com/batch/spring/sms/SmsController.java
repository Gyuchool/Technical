package com.batch.spring.sms;

import com.batch.spring.domain.Member;
import com.batch.spring.interceptor.Login;
import com.batch.spring.sms.dto.Request;
import com.batch.spring.sms.dto.Response;
import com.batch.spring.sms.dto.SmsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/user/sms")
    public ResponseEntity<SmsResponse> test(@RequestBody Request.CheckPhoneNumber request) throws NoSuchAlgorithmException, URISyntaxException, UnsupportedEncodingException, InvalidKeyException, JsonProcessingException {
        SmsResponse data = smsService.sendSms(request.getRecipientPhoneNumber());
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/user/sms/check")
    public ResponseEntity<Response.PassAuth> ok(@RequestBody Request.CheckAuthNumber request){
        //api이용해서 인증번호 확인하고 인증 메시지 번호 확인해서 비교하기
    }

}
