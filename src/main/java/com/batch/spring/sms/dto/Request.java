package com.batch.spring.sms.dto;

import lombok.*;

public class Request {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CheckPhoneNumber {
        private String recipientPhoneNumber;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CheckAuthNumber{
        private String authNumber;
    }

}
