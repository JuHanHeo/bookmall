package com.jx372.bookmall.main;

import com.jx372.bookmall.dao.test.BooksDaoTest;
import com.jx372.bookmall.dao.test.CartDaoTest;
import com.jx372.bookmall.dao.test.CategoryDaoTest;
import com.jx372.bookmall.dao.test.MembersDaoTest;
import com.jx372.bookmall.dao.test.OrdersDaoTest;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("1. " + MembersDaoTest.printCount());
		System.out.println("2. " + CategoryDaoTest.printCount());
		System.out.println("3. " + BooksDaoTest.printCount());
		System.out.println("4. " + CartDaoTest.printCount());
		System.out.println("5. " + OrdersDaoTest.printOCount());
		System.out.println("6. " + OrdersDaoTest.printOLCount());
		System.out.println();
		
		MembersDaoTest.main(null);
		CategoryDaoTest.main(null);
		BooksDaoTest.main(null);
		CartDaoTest.main(null);
		OrdersDaoTest.main(null);
		
		
	}

}
