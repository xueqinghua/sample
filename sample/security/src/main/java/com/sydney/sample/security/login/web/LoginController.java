package com.sydney.sample.security.login.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.sydney.sample.security.user.entity.User;
import com.sydney.sample.security.user.service.UserService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/dingding")
	@ResponseBody
	public Object login(@RequestParam String code,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Model model) {
		
		Map<String,String> accessTokenMap = restTemplate.getForObject("https://oapi.dingtalk.com/sns/gettoken?appid=dingoaf23uasdukgeqvuz0&appsecret=GommeUwloGdJGBGhmfCLWqunUk5xX4BNJRIOji1tHFwM8A2xvx_qe_iM1_WJEgVV",HashMap.class);
		String accessToken = accessTokenMap.get("access_token");
		
		Map<String,Object> getPersistentCodeRequest = new HashMap<>();
		
		getPersistentCodeRequest.put("access_token", accessToken);
		getPersistentCodeRequest.put("tmp_auth_code", code);
		
		Map<String,String> getPersistentCodeMap = restTemplate.postForObject("https://oapi.dingtalk.com/sns/get_persistent_code?access_token="+accessToken,getPersistentCodeRequest, HashMap.class);
		
		String openId = getPersistentCodeMap.get("openid");
		String persistentCode = getPersistentCodeMap.get("persistent_code");
		
		Map<String,Object> getSnsTokenRequest = new HashMap<>();
		getSnsTokenRequest.put("access_token", accessToken);
		getSnsTokenRequest.put("openid", openId);
		getSnsTokenRequest.put("persistent_code", persistentCode);

		
		Map<String,String> getSnsTokenMap = restTemplate.postForObject("https://oapi.dingtalk.com/sns/get_sns_token?access_token="+accessToken, getSnsTokenRequest, HashMap.class);
		
		String snsToken = getSnsTokenMap.get("sns_token");
		
		Map<String,Object> getUserInfoMap = restTemplate.getForObject("https://oapi.dingtalk.com/sns/getuserinfo?sns_token="+snsToken, HashMap.class);
		
			
		Map<String,String> userInfo = (Map)getUserInfoMap.get("user_info");
		
		String unionId = userInfo.get("unionid");
		
		User entity = new User();
		entity.setUnionId(unionId);
		List<User> users = userService.findList(entity);
		
		User user = users.get(0);
		model.addAttribute("test","test value");
		model.addAttribute("user", user);
		
		
		Map<String,String> secondAccessTokenMap = restTemplate.getForObject("https://oapi.dingtalk.com/gettoken?corpid=ding02f8eaddc71f404b35c2f4657eb6378f&corpsecret=6TVUZYmxjmHOWxWXnLD4ms4FkcnyKPx0nuSCkNnB0ePZWbGga-9jLBeZwgb9_MF3", HashMap.class);
		
		String secondAccessToken = secondAccessTokenMap.get("access_token");
		
		
		Map<String,String> userIdMap = restTemplate.getForObject("https://oapi.dingtalk.com/user/getUseridByUnionid?access_token="+secondAccessToken+"&unionid="+unionId, HashMap.class);

		String userid = userIdMap.get("userid");
		
		//https://oapi.dingtalk.com/sso/getuserinfo?access_token=ACCESS_TOKEN&code=CODE
		Map<String,Object> getUserInfoMapWithCode = restTemplate.getForObject("https://oapi.dingtalk.com/user/get?access_token="+secondAccessToken+"&userid="+userid, HashMap.class);


		///return "dingingLoginSuccess";
		
		List<User> userList = userService.findList(new User());
		
		model.addAttribute("userList", userList);
		
		//return "userList";
		
		///httpServletResponse.setContentType("application/javascript; charset=utf-8");
		
		return user;
	}
	
	
	
	@RequestMapping("/test")
	public String logintest(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Model model) {
		
		User user = new User();
		user.setName("admin");
		user.setPassword("123456");
		
		model.addAttribute("user", user);
		
		
		return "dingingLoginSuccess";
		//return "userList";
	}

}
