package xyz.lemone.lime.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lemone.lime.api.sys.dto.UserDto;
import xyz.lemone.lime.api.sys.service.UserRpcService;
import xyz.lemone.lime.core.result.BaseResult;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRpcService userRpcService;

    @GetMapping("/{id}")
    public BaseResult<UserDto> getUser(@PathVariable("id") Long id){
        return new BaseResult<UserDto>(userRpcService.getUserById(id));
    }



}
