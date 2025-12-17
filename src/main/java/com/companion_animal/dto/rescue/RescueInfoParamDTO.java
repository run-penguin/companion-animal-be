package com.companion_animal.dto.rescue;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RescueInfoParamDTO {

    private String pageNo;
    private String numOfRows;
    private String fromDate;
    private String toDate;
    private String sidoCode;
    private String sigunguCode;
    private Integer selectedKind;
}
