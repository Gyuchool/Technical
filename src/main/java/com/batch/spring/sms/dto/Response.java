package com.batch.spring.sms.dto;

import lombok.*;

public class Response {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PassAuth {
        private boolean isOk;

        Response.PassAuth build(boolean isOk){
            return PassAuth.builder().isOk(isOk).build();
        }
    }

}
