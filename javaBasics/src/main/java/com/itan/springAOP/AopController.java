package com.itan.springAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/16 11:43
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private AopService aopService;

    @GetMapping("/save")
    public String save(String i) {
        String s = aopService.save();
        return s+i;
    }

    @PostMapping("/update")
    public String update() {
        return "更新成功";
    }

    @PostMapping("/permission")
    @PermissionAnnotation()
    public String permission() {

        return "自定义注解";

    }
    //application/x-www-form-urlencoded 原生form默认的提交方式
    @PostMapping("/form")
    public void form(@RequestParam("id") int id,@RequestParam("name") String name){
        System.out.println(id+name);

    }

    @GetMapping("/form")
    public void form01(@RequestParam("id") int id,
                       @RequestParam("name") String name,
                       @RequestParam("pic") MultipartFile[] files

    ){
        System.out.println(id+name);

    }
    @GetMapping("/form02/{id}/{name}")
    public void form02(@PathVariable("id") int id,@PathVariable("name") String name){
        System.out.println(id+name);

    }

    /**
     *
     consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestPart(value = "file") MultipartFile file) {
            //@RequestParam(value = "file") MultipartFile file) {
        return name+id+file.getOriginalFilename();
    }




}
