package com.companion_animal.dto.lost;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LostKindReqDTO {

    private String serviceKey;
    private String up_kind_cd; // 축종코드(입력 시 데이터 O, 미입력 시 데이터 X)축종코드 - 개 : 417000 - 고양이 : 422400 - 기타 : 429900

    private String pageNo; // 페이지 번호 (기본값 : 1)
    private String numOfRows; // 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10
    private String _type; // xml(기본값) 또는 json

}
