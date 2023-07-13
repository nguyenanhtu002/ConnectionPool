package com.example.demo.data.dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data

public class BaseResponse {
    private int status;
    private String message;
    private int code;
    public BaseResponse(String tag_Information, TagFinanceResponseDTO tagFinanceResponseDTO){

    }
    public BaseResponse(String message) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

    public void BaseResponse(String message) {
        this.status = 1;
        this.code = 200;
        this.message = message;
    }

}