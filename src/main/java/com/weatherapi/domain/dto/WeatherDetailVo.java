package com.weatherapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDetailVo {
    String unitName;
    String sdate;
    String snowValue;
    String xValue;
    String yValue;
    String addr;
    String dewValue;
    String tempValue;
    String weatherContents;
    /*
    * "unitName": "현풍휴게소(현풍)",
      "unitCode": "090 ",
      "sdate": "20240520",
      "stdHour": "10",
      "routeNo": "4510",
      "routeName": "중부내륙지선",
      "updownTypeCode": "S",
      "xValue": "128.436431",
      "yValue": "35.701990",
      "tmxValue": "330003.845651",
      "tmyValue": "345929.673317",
      "measurement": "남문동",
      "addr": "대구광역시 달성군 현풍면 성하리 664",
      "addrCode": "143",
      "addrName": "대구",
      "weatherContents": "구름조금",
      "statusNo": "-99.000000",
      "correctNo": "45.890000",
      "cloudValue": "4.000000",
      "addcloudValue": "0.000000",
      "cloudformValue": "-99.000000",
      "tempValue": "25.000000",
      "dewValue": "4.600000",
      "discomforeValue": "-99.00",
      "sensoryTemp": "-99.000000",
      "highestTemp": "-99.00",
      "highestyearTemp": "-99.00",
      "highestcompTemp": "-99.000000",
      "lowestTemp": "-99.000000",
      "lowestyearTemp": "-99.000000",
      "lowestcompTemp": "-99.000000",
      "rainfallValue": "-99.000000",
      "rainfallstrengthValue": "-99.000000",
      "newsnowValue": "-99.000000",
      "snowValue": "-99.000000",
      "humidityValue": "27.000000",
      "windContents": "27",
      "windValue": "2.400000"*/
}
