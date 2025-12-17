package com.companion_animal.controller;

import com.companion_animal.dto.rescue.RescueInfoDTO;
import com.companion_animal.dto.rescue.RescueInfoParamDTO;
import com.companion_animal.service.rescue.RescueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class RescueController {

    @Autowired
    private RescueService rescueService;


    @GetMapping("/rescue")
    public ResponseEntity<RescueInfoDTO.Body> rescueList(RescueInfoParamDTO rescueInfoParamDTO) {
        return ResponseEntity.ok(rescueService.getRescueInfo(rescueInfoParamDTO));
    }
}
