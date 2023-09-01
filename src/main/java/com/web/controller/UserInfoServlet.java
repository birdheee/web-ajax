package com.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.common.CommandParser;
import com.web.service.UserInfoService;
import com.web.service.impl.UserInfoServiceImpl;
import com.web.vo.UserInfoVO;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService = new UserInfoServiceImpl();
	private Gson gson = new Gson();
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = CommandParser.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(userInfoService.selectUserInfoList(null));
		}else if("one".equals(cmd) || "update".equals(cmd)){
			json = gson.toJson(userInfoService.selectUserInfo(request.getParameter("uiNum")));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = "";
		while((str=br.readLine())!=null) {
			sb.append(str);
		}
		UserInfoVO user = gson.fromJson(sb.toString(), UserInfoVO.class);
		String cmd = CommandParser.getCmd(request);
		int result = 0;
		if("insert".equals(cmd)) {
			user.setUiBirth(user.getUiBirth().replace("-", ""));
			result = userInfoService.insertUserInfo(user);
		}else if("delete".equals(cmd)) {
			result = userInfoService.deleteUserInfo(user.getUiNum());
		}
		
		PrintWriter out = response.getWriter();
		out.print(result); // 1이면 정상 동작
	}

}
