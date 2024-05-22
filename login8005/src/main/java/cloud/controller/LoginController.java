package cloud.controller;

import cloud.entities.User;
import cloud.resp.Result;
import cloud.resp.ResultData;
import cloud.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController


public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping(value = "/login/gateway")
    public Result login(@RequestBody User user){

        User loginUser = loginService.login(user);
        return Result.success(loginUser);
    }

}
