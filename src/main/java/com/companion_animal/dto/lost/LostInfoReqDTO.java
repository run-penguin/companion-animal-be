package com.companion_animal.dto.lost;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LostInfoReqDTO {

    private String serviceKey;
    private String bgnde; // 구조날짜(검색 시작일)(YYYYMMDD)
    private String endde; // 구조날짜(검색 종료일)(YYYYMMDD)

    private String upkind; // 축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)
    private String kind; // 품종코드 (품종 조회 OPEN API 참조)
    private String upr_cd; // 시도코드 (시도 조회 OPEN API 참조)
    private String org_cd; // 시군구코드 (시군구 조회 OPEN API 참조)
    private String sex_cd; // 성별 - 수컷 : M - 암컷 : F

    private String pageNo; // 페이지 번호 (기본값 : 1)
    private String numOfRows; // 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10
    private String _type; // xml(기본값) 또는 json
}
