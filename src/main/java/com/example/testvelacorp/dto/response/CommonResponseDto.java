package com.example.testvelacorp.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponseDto {
    private String response;
    private String status;
}
