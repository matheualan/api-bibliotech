package com.bibliotech.api.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateUtil {

    public String dataFormatada(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(localDateTime);
    }

}
