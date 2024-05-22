package cloud.mapper;

import cloud.entities.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LoginMapper extends Mapper<User> {
      @Select("select * from log where name= #{name} and password = #{password} limit 1")
      User findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
