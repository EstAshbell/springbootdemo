package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.Car;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@RestController
@RequestMapping("/car")
@Validated
public class carController {

    @RequestMapping("/getOne")
    public Car getOne(int id,String name){
        return new Car(id, name, new Date());
    }


    @RequestMapping("/getcar3")
    public Car getCarById(@RequestBody Car car) {
        return car;
    }
    @RequestMapping("/getcar4")
    public Car getCarById4(Car car) {
        return car;
    }
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/valid/{group:[a-zA-Z0-9_]+}/{userid}")
    public String valid1 (@PathVariable("group")String group,@PathVariable("userid")String userid){
        return group+":"+userid;
    }

    @RequestMapping("/valid2")
    public String param(@NotBlank(message = "group不能为空")
                        @RequestParam("group") String group,

                        @NotBlank(message = "email不能为空")
                        @Email(message="不符合邮箱规格")
                        @RequestParam("email") String email) {
        return group + ":" + email;
    }
    @RestController
    public class CarValidation {
        @RequestMapping("/getcarvalidation1")
        public Car getcarvalidation1(@RequestBody @Validated Car car) {
            return car;
        }
    }




}
