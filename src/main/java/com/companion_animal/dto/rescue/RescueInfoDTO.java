package com.companion_animal.dto.rescue;

import com.companion_animal.dto.lost.LostInfoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RescueInfoDTO {

    private Response response;

    // response
    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        private Header header;
        private Body body;
    }

    // response.header
    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Header {
        private int reqNo;
        private String resultCode;
        private String resultMsg;
        private String errorMsg;
    }

    // response.body
    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Body {
        private Items items;
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    // response.body.items
    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Items {
        private List<Item> item;
    }

    // response.body.items.item
    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {

        private String desertionNo; // 구조번호
        private String happenDt; // 접수일
        private String happenPlace; // 발견장소
        private String kindCd; // 품종코드
        private String colorCd; // 색상
        private String age; // 나이
        private String weight; // 체중
        private String sexCd; // M : 수컷, F : 암컷, Q : 미상
        private String specialMark; // 특징
        private String sfeSoci; // 특징(사회성)
        private String sfeHealth; // 특징(건강)
        private String etcBigo; // 특이사항
        private String kindFullNm; // 품종
        private String upKindCd; // 축종코드 > 개: 417000 고양이: 422400 기타: 429900
        private String upKindNm; // 축종명
        private String kindNm; // 품종명
        private String vaccinationChk; // 체크박스(광견병,종합백신,코로나,호흡기 등)
        private String healthChk; // 체크박스(사상충,파보,코로나,홍역,원충)

        private String processState; // 상태
        private String neuterYn; // Y : 예, N : 아니오, U : 미상

        private String noticeNo; // 공고번호
        private String rfidCd; // 동물등록번호

        private String sprtEDate; // 입양지원 종료일
        private String srvcTxt; // 봉사안내 지원내용 및 신청방법

        private String popfile1; // image
        private String popfile2; // image
        private String popfile3; // image
        private String popfile4; // image
        private String popfile5; // image
        private String popfile6; // image
        private String popfile7; // image
        private String popfile8; // image

        private String evntImg; // 행사안내 이미지
        private String updTm; // 수정일
        private String endReason; // 처분사유

        private String careRegNo; // 보호소 번호
        private String noticeSdt; // 공고 시작일
        private String noticeEdt; // 공고 종료일
        private String careNm; // 보호소 이름
        private String careOwnerNm; // 보호소 대표자
        private String careTel; // 보호소 전화번호
        private String careAddr; // 보호 장소
        private String orgNm; // 관할기관

        private String adptnTitle; // 입양절차 제목
        private String adptnSDate; // 입양절차 시작일
        private String adptnEDate; // 입양절차 종료일
        private String adptnConditionLimitTxt; // 입양절차 조건 및 제한
        private String adptnTxt; // 입양절차 지원내용 및 신청방법
        private String adptnImg; // 입양절차 이미지

        private String sprtTitle; // 입양지원 제목
        private String sprtSDate; // 입양지원 시작일
        private String sprtConditionLimitTxt; // 입양지원 조건 및 제한
        private String sprtTxt; // 입양지원 지원내용 및 신청방법
        private String sprtImg; // 입양지원 이미지

        private String srvcTitle; // 봉사안내 제목
        private String srvcSDate; // 봉사안내 시작일
        private String srvcEDate; // 봉사안내 종료일
        private String srvcConditionLimitTxt; // 봉사안내 조건 및 제한
        private String srvcImg; // 봉사안내 이미지

        private String evntTitle; // 행사안내 제목
        private String evntSDate; // 행사안내 시작일
        private String evntEDate; // 행사안내 종료일
        private String evntConditionLimitTxt; // 행사안내 조건 및 제한
        private String evntTxt; // 행사안내 조건 및 제한행사안내 지원내용 및 신청방법

    }
}
