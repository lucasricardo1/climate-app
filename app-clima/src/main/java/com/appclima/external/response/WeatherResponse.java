
package com.appclima.external.response;

import com.appclima.dto.ResultsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

    public ResultsDTO results;

}
