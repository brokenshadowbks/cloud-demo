package cloud.controller;

import cloud.entities.Pro;
import cloud.entities.ProDTO;
import cloud.resp.ResultData;
import cloud.service.ProService;
import cn.hutool.core.util.IdUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GateWayController {
    @Resource
    ProService proService;

    @GetMapping(value = "/pro/gateway/get/{id}")
    public ResultData<Pro> getById(@PathVariable("id") Integer id) {
        Pro pro = proService.getById(id);
        return ResultData.success(pro);
    }

    @GetMapping(value = "/pro/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway info test：" + IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pro/gateway/get")
    public ResultData<List<Pro>> getAll() {
        List<Pro> list = proService.getAll();
        return ResultData.success(list);
    }

    @PutMapping(value = "/pro/gateway/update")
    public ResultData<String> updatePro(@RequestBody ProDTO proDTO) {
        Pro pro = new Pro();
        BeanUtils.copyProperties(proDTO, pro);
        int i = proService.update(pro);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @PostMapping(value = "/pro/gateway/add")
    @Operation
    public ResultData<String> addPro(@RequestBody Pro pro) {//新增商品
        System.out.println(pro.toString());
        int i = proService.add(pro);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping(value = "/pro/gateway/del/{id}")
    public ResultData<Integer> deletePro(@PathVariable("id") Integer id) {
        int i = proService.delete(id);
        return ResultData.success(i);
    }

}
