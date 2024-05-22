package cloud.controller;

import cloud.entities.ProDTO;
import cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProController {
    public static final String Pro_URL = "http://localhost:7573";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pro/add")
    public ResultData addOrder(ProDTO proDTO) {
        return restTemplate.postForObject(Pro_URL + "/pro/add", proDTO, ResultData.class);
    }

    @GetMapping("/pro/get/{id}")
    public ResultData getProInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(Pro_URL + "/pro/get/" + id, ResultData.class, id);
    }
    @GetMapping("/consumer/pro/del/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id) {
        restTemplate.delete(Pro_URL + "/pro/del/" + id);
        return null;
    }

    @GetMapping(value = "/pro/gateway/get")
    public ResultData getAll() {
        return restTemplate.getForObject(Pro_URL+"/pro/gateway/get",ResultData.class);
    }
}

