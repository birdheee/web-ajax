package com.web.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.vo.UserInfoVO;

public interface UserInfoMapper {
	List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO user);
	UserInfoVO selectUserInfo(SqlSession session, int uiNum);
	int insertUserInfo(SqlSession session, UserInfoVO user);
	int updateUserInfo(SqlSession session, UserInfoVO user);
	int deleteUserInfo(SqlSession session, int uiNum);
}
