package com.companion_animal.dto.lost;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LostSigunguReqDTO {

    private String serviceKey;
    private String upr_cd; // 시군구 상위코드(시도코드)(입력 시 데이터 O, 미입력 시 데이터 X)

    private String pageNo; // 페이지 번호 (기본값 : 1)
    private String numOfRows; // 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10
    private String _type; // xml(기본값) 또는 json

}
