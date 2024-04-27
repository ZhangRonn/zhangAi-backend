package com.yupi.springbootinit.controller;

import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/chart")
@Slf4j
public class ChartController {
    @Resource
    private YuCongMingClient client;

    @PostMapping("/sendPost")
    public String  send(@RequestBody  String s) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1783088392054497281L);
        devChatRequest.setMessage(s);
        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        System.out.println(response.getData().getContent());
        return response.getData().getContent();
    }
//    @GetMapping ("/sendGet")
//    public String   send() {
//        DevChatRequest devChatRequest = new DevChatRequest();
//        devChatRequest.setModelId(1783088392054497281L);
//        devChatRequest.setMessage("你叫什么");
//        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
//        System.out.println(response.getData().getContent());
//        return response.getData().getContent();
//    }
}
