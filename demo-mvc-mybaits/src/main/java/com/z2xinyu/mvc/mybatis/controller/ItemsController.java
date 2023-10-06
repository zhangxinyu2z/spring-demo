package com.z2xinyu.mvc.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.z2xinyu.mvc.mybatis.annotation.LogAnnotation;
import com.z2xinyu.mvc.mybatis.po.Items;
import com.z2xinyu.mvc.mybatis.po.QueryVo;
import com.z2xinyu.mvc.mybatis.service.ItemsService;
import com.z2xinyu.mvc.mybatis.util.exception.MessageException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Arnoer
 * @since 2022/10/8 10:49
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/index")
    public String index() {
        return "redirect:/items/queryItems";
    }

    @RequestMapping("/queryItems")
    @LogAnnotation(desc = "query")
    public String queryItems(Model model) {
        List<Items> itemsList = itemsService.findAll();
        model.addAttribute("itemList", itemsList);
        return "itemList";
    }

    @RequestMapping("/queryItems2")
    public String queryItems2(Model model) {
        List<Items> itemsList = itemsService.findAll();
        model.addAttribute("itemList", itemsList);
        return "itemList2";
    }

    @RequestMapping("/itemsDetail")
    public String itemsEdit(@RequestParam Integer id,Model model) {
        Items items = itemsService.queryItemsById(id);
        model.addAttribute("item", items);
        return "editItem";
    }

    @RequestMapping("/itemsEdit")
    public String itemsEdit(Items items, @RequestParam("file")MultipartFile file) throws MessageException {
        // 得到上传文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件扩展名
        String extensionName = FilenameUtils.getExtension(originalFilename);
        // 新的文件名
        String mainFileName = UUID.randomUUID().toString().replace("-", "");
        File newFile = new File("c:\\tmp", mainFileName + "." + extensionName);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            throw new MessageException("文件上传失败：" + e.getMessage());
        }
        items.setPic(newFile.getName());
        itemsService.updateItems(items);
        return "redirect:queryItems";
    }

    @RequestMapping("/itemsDelete")
    public String itemsDelete(Integer id) {
        return "redirect:queryItems";
    }

    // -------------------数据为json格式------------------------------
    /**
     * 跳转发送json数据页面
     *
     * @return
     */
    @RequestMapping("/json")
    public String json() {
        return "testJson";
    }

    /**
     * 使用@RequestBody接收Json字符串
     *
     * @return
     */
    @RequestMapping("/testJson")
    public String testJson(@RequestBody QueryVo queryVo) {
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testJson2")
    public String test2() {
        return "testJson2";
    }

    /**
     * 使用@ReqeustParam接收Json对象
     *
     * @param map
     * @return
     */
    @RequestMapping("/testJson3")
    public String test3(@RequestParam Map<String, String> map) {
        // 依赖alibaba.fastjson.jar
        Map<String, String> data = JSON.parseObject(map.get("jsonData"), Map.class);
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        return "testJson2";
    }

    /**
     * 使用@ReqeustBody接收json字符串
     *
     * @param map
     * @return
     */
    @RequestMapping("/testJson4")
    public String test4(@RequestBody Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        return "testJson2";
    }

    @RequestMapping("/testJson5")
    public void get3(HttpServletRequest request) {
        Map parameterMap = request.getParameterMap();
        //获取所有前缀为s_的name存入map中,前缀s_会自动去掉
        Map<String, Object> map = WebUtils.getParametersStartingWith(request, "s_");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("遍历map得到键为：" + entry.getKey());
            System.out.println("遍历map得到值为：" + entry.getValue());
        }
    }
}
