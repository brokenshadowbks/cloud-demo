package cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProDTO implements Serializable {//可以给vue看的数据库参数，安全性
    private Integer id;
    private String name;
    private String details;
}
