package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//DB操作を行う処理の時に記載する
@Repository
public class HelloRepository {

	//SQL文に「？」に受け取った引数を設定して実行できるようにするため
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findById(String id){

		//SELECT文
		String query = "SELECT * "
			+ "FROM employee "
			+ "WHERE id = ? ";

		//検索実行
		Map<String, Object> employee = jdbcTemplate.queryForMap(query,id);

		return employee;
	}

}
