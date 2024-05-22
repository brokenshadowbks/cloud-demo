package cloud.service.impl;

import cloud.entities.Pro;
import cloud.mapper.ProMapper;
import cloud.service.ProService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProServiceImpl implements ProService {
    @Resource
    private ProMapper proMapper;
    @Override
    public int add(Pro pro) {
        return proMapper.insertSelective(pro);//数据库新增
    }

    @Override
    public int delete(Integer id) {//删
        return proMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pro pro) {//修改
        return proMapper.updateByPrimaryKeySelective(pro);
    }

    @Override
    public Pro getById(Integer id) {
        return proMapper.selectByPrimaryKey(id);//主键查询
    }

    @Override
    public List<Pro> getAll() {//全查询
        return proMapper.selectAll();
    }
}
