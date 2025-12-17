package com.companion_animal.service.lost;

import com.companion_animal.dto.lost.*;
import com.companion_animal.util.ApiCallUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LostService {

    private final String apiKey;
    private final String apiUri;
    private final ApiCallUtil apiCallUtil;

    public LostService(@Value("${external.api.lost.key}") String key,
                       @Value("${external.api.lost.url}") String uri,
                       ApiCallUtil apiCallUtil) {
        this.apiKey = key;
        this.apiUri = uri;
        this.apiCallUtil = apiCallUtil;
    }

    public LostInfoDTO.Body getLostInfoList(LostInfoParamDTO lostInfoParamDTO) {

        String selectedKind = lostInfoParamDTO.getSelectedKind() == null || lostInfoParamDTO.getSelectedKind() == 0 ? "": lostInfoParamDTO.getSelectedKind().toString();

        LostInfoReqDTO lostInfoReqDTO = LostInfoReqDTO.builder()
                .pageNo(lostInfoParamDTO.getPageNo())
                .numOfRows(lostInfoParamDTO.getNumOfRows())
                .bgnde(lostInfoParamDTO.getFromDate())
                .endde(lostInfoParamDTO.getToDate())
                .upr_cd(lostInfoParamDTO.getSidoCode())
                .org_cd(lostInfoParamDTO.getSigunguCode())
                .upkind(selectedKind)
                .build();

        LostInfoDTO response = apiCallUtil.callApi(apiUri, apiKey, "/lossInfo", lostInfoReqDTO, LostInfoDTO.class);
        return response.getResponse().getBody();
    }

    public List<LostKindDTO.Item> getKindList(String upperCode) {

        LostKindReqDTO lostKindReqDTO = LostKindReqDTO.builder()
                .pageNo("1")
                .numOfRows("1000")
                .up_kind_cd(upperCode)
                .build();

        LostKindDTO response = apiCallUtil.callApi(apiUri, apiKey,"/lossInfoKind", lostKindReqDTO, LostKindDTO.class);
        return response.getResponse().getBody().getItems().getItem();
    }

    public List<LostSigunguDTO.Item> getSigunguList(String upperCode) {

        LostSigunguReqDTO lostSigunguReqDTO = LostSigunguReqDTO.builder()
                .pageNo("1")
                .numOfRows("1000")
                .upr_cd(upperCode)
                .build();

        LostSigunguDTO response = apiCallUtil.callApi(apiUri, apiKey,"/lossInfoSigungu", lostSigunguReqDTO, LostSigunguDTO.class);
        return response.getResponse().getBody().getItems().getItem();
    }

    public List<LostSidoDTO.Item> getSidoList() {

        LostSidoReqDTO lostSidoReqDTO = LostSidoReqDTO.builder()
                .pageNo("1")
                .numOfRows("1000")
                .build();

        LostSidoDTO response = apiCallUtil.callApi(apiUri, apiKey,"/lossInfoSido", lostSidoReqDTO, LostSidoDTO.class);
        return response.getResponse().getBody().getItems().getItem();
    }
}
