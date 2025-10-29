package com.bkap.qlks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.qlks.entity.Account;
import com.bkap.qlks.repository.UserRepository;

@Service
public class UserServiceIplm implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public Account findByAccountId(String accountId) {
		// TODO Auto-generated method stub
		return userRepository.findByAccountId(accountId);
	}

}
