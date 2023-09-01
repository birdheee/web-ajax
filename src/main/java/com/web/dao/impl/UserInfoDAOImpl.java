package com.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.dao.UserInfoDAO;
import com.web.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO user) {
		return session.selectList("com.web.mapper.UserInfoMapper.selectUserInfoList", user);
	}

	@Override
	public UserInfoVO selectUserInfo(SqlSession session, String uiNum) {
		return session.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo", uiNum);
	}

	@Override
	public int insertUserInfo(SqlSession session, UserInfoVO user) {
		return session.insert("com.web.mapper.UserInfoMapper.insertUserInfo", user);
	}

	@Override
	public int updateUserInfo(SqlSession session, UserInfoVO user) {
		return session.update("com.web.mapper.UserInfoMapper.updateUserInfo", user);
	}

	@Override
	public int deleteUserInfo(SqlSession session, int uiNum) {
		return session.delete("com.web.mapper.UserInfoMapper.deleteUserInfo", uiNum);
	}

}
