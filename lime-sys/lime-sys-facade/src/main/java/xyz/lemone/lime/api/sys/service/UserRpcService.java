package xyz.lemone.lime.api.sys.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.lemone.lime.api.sys.dto.UserDto;
import xyz.lemone.lime.api.sys.Constants;

/**
 * 用户远程调用接口
 */
@FeignClient(Constants.SYS_SERVICE)
public interface UserRpcService extends UserDetailsService {

	/**
	 * id 查询用户
	 * @param id
	 * @return
	 */
    @GetMapping("/api/user/{id}")
    UserDto getUserById(@PathVariable("id") Long id);

	/**
	 * 登录名查询用户
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@GetMapping("/api/user/username_{username}")
	UserDetails loadUserByUsername(@PathVariable("username")String username) throws UsernameNotFoundException;
}
