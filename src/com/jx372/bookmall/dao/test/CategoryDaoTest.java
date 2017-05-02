package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CategoryDao;
import com.jx372.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		getTest();
		
	}
	public static void insertTest(){
		CategoryVo[] vo = new CategoryVo[4];
		for(int i=0; i<4; i++){
			vo[i] = new CategoryVo();
		}
		vo[0].setName("소설");
		vo[1].setName("수필");
		vo[2].setName("컴퓨터/IT");
		vo[3].setName("예술");
		for(int i=0; i<4; i++){
			new CategoryDao().insert(vo[i]);
		}
	}
	public static void getTest(){
		List<CategoryVo> list = new CategoryDao().getList();
		
		System.out.println("카테고리 리스트");
		System.out.println();
		
		for(CategoryVo l : list){
			System.out.println(l.toString());
		}
		System.out.println("============================================================");
	}
	public static String printCount(){
		return "카테고리 리스트 ( " + new CategoryDao().getCount() + "개 )";
	}

}
