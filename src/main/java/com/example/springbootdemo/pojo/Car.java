package com.example.springbootdemo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Max(value=100,message="id不能大于100")
    private int id;
    @NotBlank(message="用户名不能为空")
    @Length(min = 2, max = 10, message = "用户名 长度必须在 {min} - {max} 之间")
    private String name;

    @DecimalMin(value="1.0",message="价格最低1元")
    @DecimalMax(value="10.0",message="价格最高10元")
    private float price;

    //格式化日期时间类型
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;

    //忽略字段，不转换为json
    @JsonIgnore
    private String memo;

    //当属性值为空时候，不转换为json
    @JsonInclude
    @NotNull(message="属性字段不能为空")
    @NotBlank(message="属性字段不能为空白")
    private String isnull;

    public Car(int id, String name, Date date) {
        this.id=id;
        this.name=name;
        this.createDate=date;
    }
}
