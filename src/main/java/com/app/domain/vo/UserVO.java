package com.app.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UserVO {
    private String userName;
    private int userAge;
    private String userEmail;
    private String userPhone;
}
