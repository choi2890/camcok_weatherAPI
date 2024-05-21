package com.weatherapi.domain.controller;

import com.weatherapi.domain.dto.ResponseVo;
import com.weatherapi.domain.dto.WeatherRequestVo;
import com.weatherapi.domain.dto.WeatherResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequiredArgsConstructor

public class InitController {


    private final WebClient webClient;

    /*휴게소 날씨 */
    @GetMapping("/test")
    public ResponseEntity<ResponseVo> testOpenAPI(@RequestParam("date") String date) {


        //https://data.ex.co.kr/openapi/restinfo/restWeatherList?key=test&type=json&sdate=202405020&stdHour=10
        //위 api를 get http 호출을 해서 전국 휴게소 날씨정보를 출력해보자

        String apiKey = "test";
        String type = "json";
        String sdate = date;
        String stdHour = "10";

        //requestVO 정의
        WeatherRequestVo weatherRequestVo = new WeatherRequestVo();
        weatherRequestVo.setKey("test");
        weatherRequestVo.setType("json");
        weatherRequestVo.setSdate(date);

        //현재 시간 기준으로 가져오기

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");

        weatherRequestVo.setStdHour(currentTime.format(formatter));

        WebClient webClient = WebClient.builder()
                .baseUrl("https://data.ex.co.kr/openapi/restinfo")
                .build();

        String apiUrl = "/restWeatherList?key={apiKey}&type={json}&sdate={sdate}&stdHour={stdHour}";
        WeatherResponseVo weatherResponse = webClient.get()
                .uri(apiUrl, weatherRequestVo.getKey(),
                        weatherRequestVo.getType(),
                        weatherRequestVo.getSdate(),
                        weatherRequestVo.getStdHour())
                .retrieve()
                .bodyToMono(WeatherResponseVo.class)
                .block();

        log.info("response : " + weatherResponse);



        ResponseVo responseVo = new ResponseVo();
        if (weatherResponse.getList().isEmpty()) {
            responseVo.setUcd("99");
            responseVo.setMessage("날씨 조회 실패");
        } else {
            responseVo.setUcd("00");
            responseVo.setMessage(weatherResponse.getList().toString());
        }

        responseVo.setMessage(weatherResponse.getList().toString());
        return ResponseEntity.ok(responseVo);
    }
}
