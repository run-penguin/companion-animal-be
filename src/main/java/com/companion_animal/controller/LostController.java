package com.companion_animal.controller;

import com.companion_animal.dto.lost.LostInfoDTO;
import com.companion_animal.dto.lost.LostKindDTO;
import com.companion_animal.dto.lost.LostSidoDTO;
import com.companion_animal.dto.lost.LostSigunguDTO;
import com.companion_animal.service.lost.LostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class LostController {

    @Autowired
    private LostService lostService;


    @GetMapping("/lost")
    public ResponseEntity<LostInfoDTO.Body> lostList(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int numOfRows, String fromDate, String toDate, String sidoCode, String sigunguCode, Integer selectedKind) {

        Map<String, Object> params = new HashMap<>();

        params.put("bgnde", fromDate);
        params.put("ended", toDate);

        if (selectedKind != null && selectedKind != 0) {
            params.put("upkind", selectedKind);
        }

        params.put("upr_cd", sidoCode);
        params.put("org_cd", sigunguCode);
        params.put("pageNo", pageNo);
        params.put("numOfRows", numOfRows);
        params.put("type", "json");

        LostInfoDTO response = lostService.callApi("lossInfo", params, LostInfoDTO.class);

        return ResponseEntity.ok(response.getResponse().getBody());
    }

    @GetMapping("/lost/kind")
    public ResponseEntity<List<LostKindDTO.Item>> kindList(@RequestParam String upperCode) {

        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("numOfRows", 1000);
        params.put("up_kind_cd", upperCode);

        LostKindDTO response = lostService.callApi("lossInfoKind", params, LostKindDTO.class);

        return ResponseEntity.ok(response.getResponse().getBody().getItems().getItem());
    }


    @GetMapping("/lost/sigungu")
    public ResponseEntity<List<LostSigunguDTO.Item>> sigunguList(@RequestParam String upperCode) {

        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("numOfRows", 1000);
        params.put("upr_cd", upperCode);

        LostSigunguDTO response = lostService.callApi("lossInfoSigungu", params, LostSigunguDTO.class);

        return ResponseEntity.ok(response.getResponse().getBody().getItems().getItem());
    }

    @GetMapping("/lost/sido")
    public ResponseEntity<List<LostSidoDTO.Item>> sidoList() {

        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("numOfRows", 1000);

        LostSidoDTO response = lostService.callApi("lossInfoSido", params, LostSidoDTO.class);

        return ResponseEntity.ok(response.getResponse().getBody().getItems().getItem());
    }
}
