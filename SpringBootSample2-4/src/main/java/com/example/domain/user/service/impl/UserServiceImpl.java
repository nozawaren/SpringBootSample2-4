package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;

	/** PasswordEncoderクラスを定義する */
	@Autowired 
	private PasswordEncoder encoder;
	
	/** ユーザー登録 */
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);//部署
		user.setRole("ROLE_GENERAL");//ロール
		// パスワード暗号化 
		/** パスワードを取得する */
		String rawPassword = user.getPassword(); 
		/** パスワードを暗号化しuserにセットする */
		user.setPassword(encoder.encode(rawPassword));
		
		mapper.insertOne(user);
	}

	/** ユーザー取得 */
	//* UserService.javaのgetUsersをオーバーライドして内部処理にUserMapper.javaのfindManyを実行する */
	@Override 
	public List<MUser> getUsers(MUser user) { 
		return mapper.findMany(user); 
	}

	/** ユーザー取得（1件） */
	/** UserService.javaのgetUserOneをオーバーライドして内部処理にUserMapper.javaのfindOneを実行する */
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}
	
	/** ユーザー更新(1件) */ 
	/** トランザクションを実装できる */
	@Transactional
	/** UserService.javaのupdateUserOneをオーバーライドして内部処理にUserMapper.javaのupdateOneを実行する */
	@Override 
	public void updateUserOne(String userId, String password, String userName) { 
		mapper.updateOne(userId, password, userName); 
		
		// パスワード暗号化 
		String encryptPassword = encoder.encode(password); 
		mapper.updateOne(userId, encryptPassword, userName);
		
		// 例外を発生させる 
		//int i = 1 / 0;
	} 
	
	/** ユーザー削除(1件) */ 
	/** UserService.javaのdeleteUserOneをオーバーライドして内部処理にUserMapper.javaのdeleteOneを実行する */
	@Override 
	public void deleteUserOne(String userId) { 
		int count = mapper.deleteOne(userId); 
	}
	
	/** ログインユーザー情報取得 */ 
	/** UserService.javaのgetLoginUserをオーバーライドして内部処理にUserMapper.javaのfindLoginUserを実行する */
	@Override 
	public MUser getLoginUser(String userId) { 
		return mapper.findLoginUser(userId); 
	}

}
