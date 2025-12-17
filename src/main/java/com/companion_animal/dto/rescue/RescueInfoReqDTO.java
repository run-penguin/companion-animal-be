package com.companion_animal.dto.rescue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RescueInfoReqDTO {

    private String serviceKey;
    private String bgnde; // 구조날짜(검색 시작일)(YYYYMMDD)
    private String endde; // 구조날짜(검색 종료일)(YYYYMMDD)
    private String upkind; // 축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)
    private String kind; // 품종코드 (품종 조회 OPEN API 참조)
    private String upr_cd; // 시도코드 (시도 조회 OPEN API 참조)
    private String org_cd; // 시군구코드 (시군구 조회 OPEN API 참조)
    private String care_reg_no; // 보호소번호 (보호소 조회 OPEN API 참조)
    private String state; // 상태(전체 : null(빈값), 공고중 : notice, 보호중 : protect)
    private String neuter_yn; // 상태 (전체 : null(빈값), 예 : Y, 아니오 : N, 미상 : U)
    private String pageNo; // 페이지 번호 (기본값 : 1)
    private String numOfRows; // 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10
    private String _type; // xml(기본값) 또는 json
    private String bgupd; // 수정날짜(검색 시작일)(YYYYMMDD)
    private String enupd; // 수정날짜(검색 종료일)(YYYYMMDD)
    private String sex_cd; // 성별 - 전체 : null(빈값) - 수컷 : M - 암컷 : F - 미상 : Q
    private String rfid_cd; // 동물등록번호
    private String desertion_no; // 유기번호
    private String notice_no; // 공고번호
}
