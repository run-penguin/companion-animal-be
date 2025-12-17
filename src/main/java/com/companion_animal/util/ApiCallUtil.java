package com.companion_animal.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiCallUtil {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public <T, R> R callApi(String baseUri, String serviceKey, String endpoint, T paramDTO, Class<R> responseType) {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(baseUri + "/" + endpoint)
                .queryParam("_type", "json")
                .queryParam("serviceKey", serviceKey);

        // DTO -> Map
        Map<String, Object> params = objectMapper.convertValue(paramDTO,
                new TypeReference<Map<String, Object>>() {});

        // + Params
        params.forEach((key, value) -> {
            if (value != null) {
                builder.queryParam(key, value);
            }
        });

        String url = builder.build(false).toUriString();
        log.info("API 요청 URL: {}", url);

        try {
            String response = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(response, responseType);
        } catch (Exception ex) {
            log.error("API 호출 에러 - URL: {}", url, ex);
            throw new RuntimeException("API 호출 실패: " + ex.getMessage(), ex);
        }
    }
}
