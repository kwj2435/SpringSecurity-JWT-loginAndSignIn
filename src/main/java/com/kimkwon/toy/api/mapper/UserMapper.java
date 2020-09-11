package com.kimkwon.toy.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kimkwon.toy.domain.UserVO;

@Mapper
public interface UserMapper {
	public void setUser(UserVO userVO) throws Exception;
	public UserVO getUserIdPassword(String user_id);
}
