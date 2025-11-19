package com.companion_animal.controller;

import com.companion_animal.dto.loss.LossInfoDTO;
import com.companion_animal.dto.loss.LossKindDTO;
import com.companion_animal.dto.loss.LossSidoDTO;
import com.companion_animal.dto.loss.LossSigunguDTO;
import com.companion_animal.service.loss.LossService;
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
public class LossController {

    @Autowired
    private LossService lossService;


    @GetMapping("/loss")
    public LossInfoDTO.Items lossList(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int numOfRows) {

        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", pageNo);
        params.put("numOfRows", numOfRows);

        LossInfoDTO response = lossService.callApi("lossInfo", params, LossInfoDTO.class);

        if (lossService.isSuccess(response.getResponse().getHeader().getResultCode())) {
            return response.getResponse().getBody().getItems();
        }

        return null;
    }

    @GetMapping("/loss/kind")
    public LossKindDTO.Items kindList(@RequestParam String upperCode) {

        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("numOfRows", 1000);
        params.put("up_kind_cd", upperCode);

        LossKindDTO response = lossService.callApi("lossInfoKind", params, LossKindDTO.class);

        if (lossService.isSuccess(response.getResponse().getHeader().getResultCode())) {
            return response.getResponse().getBody().getItems();
        }

        return null;
    }


    @GetMapping("/loss/sigungu")
    public LossSigunguDTO.Items sigunguList(@RequestParam String upperCode) {

        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("numOfRows", 1000);
        params.put("upr_cd", upperCode);

        LossSigunguDTO response = lossService.callApi("lossInfoSigungu", params, LossSigunguDTO.class);

        if (lossService.isSuccess(response.getResponse().getHeader().getResultCode())) {
            return response.getResponse().getBody().getItems();
        }

        return null;
    }

    @GetMapping("/loss/sido")
    public ResponseEntity<List<LossSidoDTO.Item>> sidoList() {

        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("numOfRows", 1000);

        LossSidoDTO response = lossService.callApi("lossInfoSido", params, LossSidoDTO.class);

        return ResponseEntity.ok(response.getResponse().getBody().getItems().getItem());
    }
}
