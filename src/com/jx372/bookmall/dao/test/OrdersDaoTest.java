package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.OrdersDao;
import com.jx372.bookmall.vo.OrderListVo;
import com.jx372.bookmall.vo.OrdersVo;

public class OrdersDaoTest {
	static List<OrdersVo> list = null;
	static List<OrderListVo> olist = null;
	public static void main(String[] args) {
		getOTest();
		getOLTest();
	}

	public static void insertOTest() {
		OrdersVo vo = new OrdersVo();
		vo.setMemNo(1L);vo.setPrice(53000l);vo.setAdd("창원시 성상구 대정로 142");
		new OrdersDao().insertO(vo);
	}
	public static void getOTest(){
		list = new OrdersDao().getOList();
		System.out.println("주문 리스트");
		System.out.println();
		for(OrdersVo vo : list){
			System.out.println(vo.toString());
		}
		System.out.println("============================================================");
	}
	public static String printOCount(){
		return "주문 리스트 ( " + new OrdersDao().getOCount() + "개 )";
	}
	
	
	
	
	public static void insertOLTest() {
		OrderListVo[] vo = new OrderListVo[3];
		for(int i=0; i<3; i++){
			vo[i] = new OrderListVo();
		}
		vo[0].setOrNo(1l);vo[0].setBookNo(1l);vo[0].setCnt(1l);
		vo[1].setOrNo(1l);vo[1].setBookNo(2l);vo[1].setCnt(1l);
		vo[2].setOrNo(1l);vo[2].setBookNo(4l);vo[2].setCnt(2l);
		
		
		for(int i=0;i<3;i++){
			new OrdersDao().insertOL(vo[i]);
		}
	}
	public static void getOLTest(){
		olist = new OrdersDao().getOLList();
		System.out.println("주문 도서 리스트");
		System.out.println();
		for(OrderListVo vo : olist){
			System.out.println(vo.toString());
		}
		System.out.println("============================================================");
	}
	public static String printOLCount(){
		return "주문 도서 리스트 ( " + new OrdersDao().getOLCount() + "개 )";
	}
	
	
	
	

}
