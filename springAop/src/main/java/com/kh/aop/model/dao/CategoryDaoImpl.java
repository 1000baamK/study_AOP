package com.kh.aop.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.aop.model.vo.Category;


@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insertCategory(Category category) {
		
		int result = sqlSession.insert("testMapper.insertCategory", category);
		
		return result;
	}

	@Override
	public ArrayList<Category> selectCategory() {
		
//		long start = System.currentTimeMillis(); //시작시간
		ArrayList<Category> list = (ArrayList)sqlSession.selectList("testMapper.selectCategory");
//		long finish = System.currentTimeMillis(); //종료시간
		
//		log.debug("time = {}", finish-start); //걸린시간
		
		return list;
	}

	
}
