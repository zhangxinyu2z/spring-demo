package com.z2xinyu.mvc.mybatis.controller;

import com.z2xinyu.mvc.mybatis.api.ErrorCode;
import com.z2xinyu.mvc.mybatis.api.R;
import com.z2xinyu.mvc.mybatis.exception.BusinessException;
import com.z2xinyu.mvc.mybatis.exception.EntityNotFoundException;
import com.z2xinyu.mvc.mybatis.po.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

/**
 * @author zhangxinyu
 * @version v1.0
 * @date created in 2022-03-02 20:15
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/index")
    public R<User> index(@RequestBody User user) {
        return R.data(user);
    }

    /**
     * 测试返回异常信息
     */
    @RequestMapping("/exception")
    public String returnExceptionInfo() {
        if (1 != 2) {
            throw new BusinessException(ErrorCode.USERNAME_ERROR);
        }
        return "success";
    }

    /**
     * ResponseEntity用来替代@ResponseBody，可以设置信息到响应头中
     *
     * @param user
     * @param ucb
     * @return
     */
    @RequestMapping(value = "saveUser", method = RequestMethod.POST, consumes = "application/json", produces =
            "application/json")
    public ResponseEntity<?> saveUser(@RequestBody User user, UriComponentsBuilder ucb) {
        // 保存user
        user.setId(1);
        // 设置新建资源的地址到响应的locations中
        HttpHeaders httpHeaders = new HttpHeaders();
        URI uri = ucb.path("/hello/").path(String.valueOf(user.getId())).build().toUri();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
    }

    /**
     * 优化一种处理方式
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User spittleById(@PathVariable long id) {
        // 通过id找
        User user = new User();
        user.setId((int)id);
        user.setUsername("arnoer");
        if (id != 0) {
            throw new EntityNotFoundException(id);
        }
        return user;
    }

    public User fetchUser(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", String.valueOf(id));
        //        return restTemplate.getForObject("http://localhost/hello/{user}", User.class, id);
        return restTemplate.getForObject("http://localhost/hello/{user}", User.class, urlVariables);
    }


}


