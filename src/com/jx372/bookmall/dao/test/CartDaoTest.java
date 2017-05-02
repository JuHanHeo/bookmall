package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CartDao;
import com.jx372.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
//		insertTest();
		getTest();
	}
	public static void insertTest(){
		CartVo[] vo = new CartVo[4];
		for(int i=0; i<2; i++){
			vo[i] = new CartVo();
		}
		vo[0].setMemNo(1l);vo[0].setBookNo(2l);vo[0].setCnt(1l);vo[0].setPrice(13000l);
		vo[1].setMemNo(1l);vo[1].setBookNo(1l);vo[1].setCnt(2l);vo[1].setPrice(40000l);

		for(int i=0;i<2;i++){
			new CartDao().insert(vo[i]);
		}
		
	}
	public static void getTest(){
		List<CartVo> list = new CartDao().getList();
		
		System.out.println("카트 리스트");
		System.out.println();
		
		for(CartVo l : list){
			System.out.println(l.toString());
		}
		System.out.println("============================================================");
	}
	public static String printCount(){
		return "카트 리스트 ( " + new CartDao().getCount() + "개 )";
	}
}
