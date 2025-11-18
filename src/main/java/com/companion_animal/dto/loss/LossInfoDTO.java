package com.companion_animal.dto.loss;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LossInfoDTO {

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
        private String desertionNo;      // 유기번호
        private String filename;          // 썸네일 이미지
        private String happenDt;          // 접수일
        private String happenPlace;       // 발견장소
        private String kindCd;            // 품종
        private String colorCd;           // 색상
        private String age;               // 나이
        private String weight;            // 체중
        private String noticeNo;          // 공고번호
        private String noticeSdt;         // 공고시작일
        private String noticeEdt;         // 공고종료일
        private String popfile;           // 이미지
        private String processState;      // 상태
        private String sexCd;             // 성별
        private String neuterYn;          // 중성화여부
        private String specialMark;       // 특징
        private String careNm;            // 보호소이름
        private String careTel;           // 보호소전화번호
        private String careAddr;          // 보호장소
        private String orgNm;             // 관할기관
        private String chargeNm;          // 담당자
        private String officeTel;        // 담당자연락처
    }
}
