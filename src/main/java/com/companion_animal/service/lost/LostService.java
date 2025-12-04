package com.companion_animal.service.lost;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Service
public class LostService {

    private final String lostApiKey;

    private final String lostApiUri;

    public LostService(@Value("${external.api.lost.key}") String lostApiKey, @Value("${external.api.lost.url}") String lostApiUri) {
        this.lostApiKey = lostApiKey;
        this.lostApiUri = lostApiUri;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    public <T> T callApi(String endpoint, Map<String, Object> params, Class<T> responseType) {
        try {
            // URL 빌더 생성
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(lostApiUri + "/" + endpoint)
                    .queryParam("serviceKey", lostApiKey)
                    .queryParam("_type", "json");

            // 추가 파라미터 설정
            if (params != null) {
                params.forEach((key, value) -> {
                    if (value != null) {
                        builder.queryParam(key, value);
                    }
                });
            }

            String url = builder.build(false).toUriString();
            log.info("API 요청 URL: {}", url);

            // API 호출
            String response = restTemplate.getForObject(url, String.class);

            // JSON을 DTO로 변환
            return objectMapper.readValue(response, responseType);

        } catch (Exception ex) {
            log.error("API 호출 에러 - endpoint: {}, params: {}", endpoint, params, ex);
            throw new RuntimeException("API 호출 실패: " + ex.getMessage(), ex);
        }
    }

    public boolean isSuccess(String resultCode) {
        return "00".equals(resultCode) || "200".equals(resultCode);
    }
}
