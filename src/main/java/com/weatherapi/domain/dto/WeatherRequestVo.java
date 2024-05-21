package com.weatherapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WeatherRequestVo {
    //api 호출 할때 객체

    String key;
    String type;
    String sdate;
    String stdHour;

}
