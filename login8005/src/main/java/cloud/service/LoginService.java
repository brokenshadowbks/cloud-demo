package cloud.service;

import cloud.entities.User;
import cloud.exception.CustomException;
import cloud.mapper.LoginMapper;
import cloud.resp.JwtTokenUtils;
import cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService{
    @Resource
    private LoginMapper loginMapper;
    public User login(User user) {

        // 1. 进行一些非空判断
        if (user.getName() == null || "".equals(user.getName())) {
            throw new CustomException("用户名不能为空");
        }
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            throw new CustomException("密码不能为空");
        }
        // 2. 从数据库里面根据这个用户名和密码去查询对应的管理员信息，
        User loginuser = loginMapper.findByNameAndPassword(user.getName(), user.getPassword());
        if (loginuser == null) {
            // 如果查出来没有，那说明输入的用户名或者密码有误，提示用户，不允许登录
            throw new CustomException("用户名或密码输入错误");
        }
        // 如果查出来了有，输入的用户名和密码都对；

        String token = JwtTokenUtils.genToken(user.getName(),user.getPassword(),user.getPermission());
        loginuser.setToken(token);
        return loginuser;
    }

    public User findById(Integer id) {
        return loginMapper.selectByPrimaryKey(id);
    }
}
