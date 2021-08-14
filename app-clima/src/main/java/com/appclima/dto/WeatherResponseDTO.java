
package com.appclima.dto;

import com.appclima.external.response.WeatherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseDTO extends BasedResponseDTO{

    private List<WeatherResponse> response;

    public WeatherResponseDTO(String message, Boolean success, List<WeatherResponse> response) {
        super(message, success);
        this.response = response;
    }

}
