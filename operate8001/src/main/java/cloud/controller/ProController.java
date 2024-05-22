package cloud.controller;
import cloud.entities.Pro;
import cloud.entities.ProDTO;
import cloud.resp.ResultData;
import cloud.service.ProService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class ProController {
    @Resource
    private ProService proService;

    @PostMapping(value = "/pro/add")
    @Operation
    public ResultData<String> addPro(@RequestBody Pro pro) {//新增商品
        System.out.println(pro.toString());
        int i = proService.add(pro);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping(value = "/pro/del/{id}")
    public ResultData<Integer> deletePro(@PathVariable("id") Integer id) {
        int i = proService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pro/update")
    public ResultData<String> updatePro(@RequestBody ProDTO proDTO) {
        Pro pro = new Pro();
        BeanUtils.copyProperties(proDTO, pro);
        int i = proService.update(pro);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pro/get/{id}")
    public ResultData<Pro> getById(@PathVariable("id") Integer id) {
        Pro pro = proService.getById(id);
        return ResultData.success(pro);
    }

    @GetMapping(value = "/pro/get")
    public ResultData<List<Pro>> getAll()
    {
        List<Pro> list = proService.getAll();
        return ResultData.success(list);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pro/get/info")
    private String getInfoByConsul(@Value("${cloud.info}") String cloudInfo)
    {
        return "cloudInfo: "+cloudInfo+"\t"+"port: "+port;
    }

}
