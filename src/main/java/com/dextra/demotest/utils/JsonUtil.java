package com.dextra.demotest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

@Slf4j
public class JsonUtil {

    private static final String MSG_FORMATTER = "Error parsing msg %s";

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static String convertObjectToJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            String format = String.format(MSG_FORMATTER, ObjectUtils.nullSafeToString(obj));
            log.error(format, e);
            return format;
        }
    }

    public static <T> T convertJsonToObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error(String.format(MSG_FORMATTER, json), e);
            return null;
        }
    }

    public static <T> T convertJsonToObject(String json, TypeReference<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error(String.format(MSG_FORMATTER, json), e);
            return null;
        }
    }


}
