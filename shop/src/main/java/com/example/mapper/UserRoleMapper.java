package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.UserRole;

@Mapper
public interface UserRoleMapper {

	// 유저의 Role을 등록하는 기능
	void insertUserRole(UserRole userRole);
	// 유저의 Role를 삭제하는 기능
	void deleteUserRole(UserRole userRole);
	// 유저의 Role를 가져오는기능
	List<UserRole> getUserRolesByUserNo(int userNo);
}
