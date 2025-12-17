package com.companion_animal.controller;

import com.companion_animal.dto.lost.*;
import com.companion_animal.service.lost.LostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class LostController {

    @Autowired
    private LostService lostService;


    @GetMapping("/lost")
    public ResponseEntity<LostInfoDTO.Body> lostList(@ModelAttribute LostInfoParamDTO lostInfoParamDTO) {
        return ResponseEntity.ok(lostService.getLostInfoList(lostInfoParamDTO));
    }

    @GetMapping("/lost/kind")
    public ResponseEntity<List<LostKindDTO.Item>> kindList(@RequestParam String upperCode) {
        return ResponseEntity.ok(lostService.getKindList(upperCode));
    }

    @GetMapping("/lost/sigungu")
    public ResponseEntity<List<LostSigunguDTO.Item>> sigunguList(@RequestParam String upperCode) {
        return ResponseEntity.ok(lostService.getSigunguList(upperCode));
    }

    @GetMapping("/lost/sido")
    public ResponseEntity<List<LostSidoDTO.Item>> sidoList() {
        return ResponseEntity.ok(lostService.getSidoList());
    }
}
