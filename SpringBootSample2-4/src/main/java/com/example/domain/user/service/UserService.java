package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;

public interface UserService {

	/** ユーザー登録 */
	public void signup(MUser user);

	/** ユーザー取得 */ 
	/** getUsersクラスを定義する */
	public List<MUser> getUsers(MUser user);

	/** ユーザー取得（１件） */
	/** getUserOneクラスを定義する */
	public MUser getUserOne(String userId);
	
	/** ユーザー更新(1件) */ 
	/** updateUserOneクラスを定義する */
	public void updateUserOne(String userId, String password, String userName); 
	
	/** ユーザー削除(1件) */ 
	/** deleteUserOneクラスを定義する */
	public void deleteUserOne(String userId);
	
	/** ログインユーザー情報取得 */ 
	/** getLoginUserクラスを定義する */
	public MUser getLoginUser(String userId);

}
