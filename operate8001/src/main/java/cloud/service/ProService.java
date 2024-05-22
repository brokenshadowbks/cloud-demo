package cloud.service;

import cloud.entities.Pro;

import java.util.List;

public interface ProService {//增删改查接口
    int add(Pro pro);
    int delete(Integer id);
    int update(Pro pro);
    Pro getById(Integer id);
    List<Pro> getAll();

}
