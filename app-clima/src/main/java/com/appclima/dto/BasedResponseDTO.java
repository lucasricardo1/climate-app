package com.appclima.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BasedResponseDTO {

    private String message;
    private Boolean success;

}
