package com.web.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.dao.UserInfoDAO;
import com.web.dao.impl.UserInfoDAOImpl;
import com.web.service.UserInfoService;
import com.web.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO userInfoDao = new UserInfoDAOImpl();

	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO user) {
		try(SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)){
			return userInfoDao.selectUserInfoList(session, user);
		}
	}

	@Override
	public UserInfoVO selectUserInfo(String uiNum) {
		try(SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)){
			return userInfoDao.selectUserInfo(session, uiNum);
		}
	}

	@Override
	public int insertUserInfo(UserInfoVO user) {
		try(SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)){
			return userInfoDao.insertUserInfo(session, user);
		}
	}

	@Override
	public int updateUserInfo(UserInfoVO user) {
		try(SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)){
			return userInfoDao.updateUserInfo(session, user);
		}
	}

	@Override
	public int deleteUserInfo(int uiNum) {
		try(SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)){
			return userInfoDao.deleteUserInfo(session, uiNum);
		}
	}

}
