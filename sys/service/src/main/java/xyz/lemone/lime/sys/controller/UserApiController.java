package xyz.lemone.lime.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lemone.lime.api.sys.dto.UserDto;
import xyz.lemone.lime.api.sys.service.UserRpcService;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements UserRpcService {


    @Override
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        UserDto dto = new UserDto();
        dto.setName("ceshi");
        return dto;
    }

    @Override
    @GetMapping("/username_{username}")
    public UserDto loadUserByUsername(@PathVariable("username") String username) {
        UserDto user = new UserDto();
        user.setName("admin");
        user.setId(001L);
        return user;
    }
}
