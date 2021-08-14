
package com.appclima.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsDTO {

    @JsonProperty("temp")
    public Integer temp;
    @JsonProperty("date")
    public String date;
    @JsonProperty("description")
    public String description;
    @JsonProperty("currently")
    public String currently;
    @JsonProperty("city")
    public String city;
    @JsonProperty("humidity")
    public Integer humidity;
    @JsonProperty("wind_speedy")
    public String windSpeedy;
    @JsonProperty("condition_slug")
    public String conditionSlug;

}
