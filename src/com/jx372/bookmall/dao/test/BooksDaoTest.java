package com.jx372.bookmall.dao.test;


import java.util.List;

import com.jx372.bookmall.dao.BooksDao;
import com.jx372.bookmall.vo.BooksVo;

public class BooksDaoTest {
	public static void main(String[] args) {
//		insertTest();
		getTest();
	}
	public static void insertTest(){
		BooksVo[] book = new BooksVo[4];
		for(int i=0; i<4; i++){
			book[i] = new BooksVo();
		}
		book[0].setIsbn(11111l);book[0].setName("이것이 자바다");book[0].setPrice(20000l);book[0].setCateNo(3l);
		book[1].setIsbn(22222l);book[1].setName("서양 미술사");book[1].setPrice(13000l);book[1].setCateNo(4l);
		book[2].setIsbn(33333l);book[2].setName("안드로이드");book[2].setPrice(40000l);book[2].setCateNo(3l);
		book[3].setIsbn(44444l);book[3].setName("아큐정전");book[3].setPrice(10000l);book[3].setCateNo(1l);
		
		for(int i=0;i<4;i++){
			new BooksDao().insert(book[i]);
		}
		
	}
	public static void getTest(){
		List<BooksVo> list = new BooksDao().getList();
		
		System.out.println("상품 리스트");
		System.out.println();
		
		for(BooksVo l : list){
			System.out.println(l.toString());
		}
		System.out.println("============================================================");
	}
	public static String printCount(){
		return "상품 리스트 ( " + new BooksDao().getCount() + "개 )";
	}
}
