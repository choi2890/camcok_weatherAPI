package com.weatherapi.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {

    String ucd;
String message;


}
