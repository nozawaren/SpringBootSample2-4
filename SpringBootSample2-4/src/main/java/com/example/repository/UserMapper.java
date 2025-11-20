package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.MUser;

/** MyBatisでリポジトリーを作成する */
@Mapper
public interface UserMapper {

	/** ユーザー登録 */
	public int insertOne(MUser user);
	
	/** ユーザー取得 */
	/** UserMapper.xmlのfindManyを引数userで実行し結果をList型で受け取る呼び出しを定義する */
	public List<MUser> findMany(MUser user);

	/** ユーザー取得（1件） */
	/** UserMapper.xmlのfindManyを引数なしで実行し結果をList型で受け取る呼び出しを定義する */
	public List<MUser> findMany();

	/** ユーザー取得（1件） */
	/** UserMapper.xmlのfindManyを引数userIdで実行し結果をMUser型で受け取る呼び出しを定義する */
	public MUser findOne(String userId);
	
	/** ユーザー更新(1件) */ 
	/** UserMapper.xmlのupdateOneを引数userId・password・userNameで実行し返却値なしの呼び出しを定義する */
	/** Paramアノテーションは複数の引数が必要な際につける */
	public void updateOne(@Param("userId") String userId, @Param("password") String password, @Param("userName") String userName); 
	
	/** ユーザー削除(1件) */ 
	/** UserMapper.xmlのdeleteOneを引数userIdで実行し結果をint型で受け取る呼び出しを定義する */
	public int deleteOne(@Param("userId") String userId);
	
	/** ログインユーザー取得 */ 
	public MUser findLoginUser(String userId);
}
