package com.example.redissample.controller;

import com.example.redissample.dto.dataDTO;
import com.example.redissample.service.RedisService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/redisctrl")
public class RedisController {

    @Autowired
    RedisService redisService;

    Gson gson = new Gson();

    @PostMapping("/createdata")
    public void createData(@RequestBody String strdata) {
//        strdata = "{\"id\": \"userid1\",\"bodyDTO\": {\"element1\": \"정보3\",\"element2\": \"정보4\"}}";
        dataDTO datadto = gson.fromJson(strdata, dataDTO.class);
        log.info("id : {}, body : {}",datadto.getId(),datadto.getBodyData());
        redisService.saveData(datadto.getId(), datadto.getBodyData());

    }

    @PostMapping("/readdata")
    public void readData(@RequestBody String strdata) {
        dataDTO datadto = gson.fromJson(strdata, dataDTO.class);
        redisService.getData(datadto.getId());
    }

    @PostMapping("/updatedata")
    public void updateData(@RequestBody String strdata) {
        dataDTO datadto = gson.fromJson(strdata, dataDTO.class);
        redisService.updateData(datadto.getId(),datadto.getBodyData());
    }

    @PostMapping("/deletedata")
    public void deleteData(@RequestBody String strdata) {
        dataDTO datadto = gson.fromJson(strdata, dataDTO.class);
        redisService.deleteData(datadto.getId());
    }

}
