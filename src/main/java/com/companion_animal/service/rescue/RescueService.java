package com.companion_animal.service.rescue;

import com.companion_animal.dto.rescue.RescueInfoDTO;
import com.companion_animal.dto.rescue.RescueInfoParamDTO;
import com.companion_animal.dto.rescue.RescueInfoReqDTO;
import com.companion_animal.util.ApiCallUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RescueService {

    private final String apiKey;
    private final String apiUri;
    private final ApiCallUtil apiCallUtil;

    public RescueService(@Value("${external.api.lost.key}") String key,
                         @Value("${external.api.rescue.url}") String uri,
                         ApiCallUtil apiCallUtil) {
        this.apiKey = key;
        this.apiUri = uri;
        this.apiCallUtil = apiCallUtil;
    }

    public RescueInfoDTO.Body getRescueInfo(RescueInfoParamDTO rescueInfoParamDTO) {

        RescueInfoReqDTO rescueInfoReqDTO = RescueInfoReqDTO.builder()
                .pageNo(rescueInfoParamDTO.getPageNo())
                .numOfRows(rescueInfoParamDTO.getNumOfRows())
                .build();

        RescueInfoDTO response = apiCallUtil.callApi(apiUri, apiKey, "/abandonmentPublic_v2", rescueInfoReqDTO, RescueInfoDTO.class);
        return response.getResponse().getBody();
    }
}
