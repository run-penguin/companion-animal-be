package com.companion_animal.dto.lost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LostInfoParamDTO {

    private String pageNo;
    private String numOfRows;
    private String fromDate;
    private String toDate;
    private String sidoCode;
    private String sigunguCode;
    private Integer selectedKind;
}
