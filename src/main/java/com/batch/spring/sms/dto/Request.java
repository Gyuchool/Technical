package com.batch.spring.sms.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Request {
    private String recipientPhoneNumber;
    private String title;
    private String content;

}
