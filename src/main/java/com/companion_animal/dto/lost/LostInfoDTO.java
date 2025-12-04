package com.companion_animal.dto.lost;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LostInfoDTO {

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
        private String rfidCd;
        private String callName;
        private String callTel;
        private String happenDt;
        private String happenAddr;
        private String happenAddrDtl;
        private String happenPlace;
        private String orgNm;
        private String popfile;
        private String kindCd;
        private String colorCd;
        private String sexCd;
        private String age;
        private String specialMark;
    }
}
