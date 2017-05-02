package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.MembersDao;
import com.jx372.bookmall.vo.MembersVo;

public class MembersDaoTest {
	static List<MembersVo> list = null;
	public static void main(String[] args) {
		getTest();
	}

	public static void insertTest() {
		MembersVo vo = new MembersVo();
		vo.setName("허규준");
		vo.setTel("010-2692-4814");
		vo.setEmail("herojoon1378@gmail.com");
		vo.setPasswd("0000");
		new MembersDao().insert(vo);
	}
	public static void getTest(){
		list = new MembersDao().getList();
		System.out.println("회원정보");
		System.out.println();
		for(MembersVo vo : list){
			System.out.println(vo.toString());
		}
		System.out.println("============================================================");
	}
	public static String printCount(){
		return "회원 리스트 ( " + new MembersDao().getCount() + "명 )";
	}
	
}
