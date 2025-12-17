package com.companion_animal.service.rescue;

import com.companion_animal.dto.rescue.RescueInfoDTO;
import com.companion_animal.dto.rescue.RescueInfoParamDTO;
import com.companion_animal.dto.rescue.RescueInfoReqDTO;
import com.fasterxml.jackson.core.type.TypeReference;
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
public class RescueService {

    private final String lostApiKey;

    private final String rescueApiUri;

    public RescueService(@Value("${external.api.lost.key}") String lostApiKey, @Value("${external.api.rescue.url}") String rescueApiUri) {
        this.lostApiKey = lostApiKey;
        this.rescueApiUri = rescueApiUri;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    public RescueInfoDTO.Body getRescueInfo(RescueInfoParamDTO rescueInfoParamDTO) {

        RescueInfoReqDTO rescueInfoReqDTO = RescueInfoReqDTO.builder()
                ._type("json")
                .pageNo(rescueInfoParamDTO.getPageNo())
                .numOfRows(rescueInfoParamDTO.getNumOfRows())
                .build();

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(rescueApiUri + "/abandonmentPublic_v2")
                .queryParam("serviceKey", lostApiKey);

        // DTO -> Map
        Map<String, Object> params = objectMapper.convertValue(rescueInfoReqDTO,
                new TypeReference<Map<String, Object>>() {});

        // 쿼리 파라미터 추가 (null 값 제외)
        params.forEach((key, value) -> {
            if (value != null) {
                builder.queryParam(key, value);
            }
        });

        String url = builder.build(false).toUriString();
        log.info("API 요청 URL: {}", url);

        try {

            String response = restTemplate.getForObject(url, String.class);

            RescueInfoDTO rescueInfoDTO = objectMapper.readValue(response, RescueInfoDTO.class);
            return rescueInfoDTO.getResponse().getBody();

        } catch (Exception ex) {
            log.error("API 호출 에러 - URL: {}", url, ex);
            throw new RuntimeException("API 호출 실패: " + ex.getMessage(), ex);
        }

    }

}
