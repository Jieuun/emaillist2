package com.sds.icto.emaillist.test;

import java.sql.SQLException;
import java.util.List;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;

public class TestEmailListDao {
	public static void main(String[] args) {
		try {

			// 0. deleteTest
			testDelete();
			// 인서트테스트
			testInsert();
			// fetchls
			testFetchList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void testFetchList() throws Exception {

		EmailListDao dao = new EmailListDao();
		List<EmailListVo> list = dao.fetchlist();
		for (EmailListVo vo : list) {
			System.out.print(vo.getNo() + " : ");
			System.out.print(vo.getFirstName() + " : ");
			System.out.print(vo.getLastName() + " : ");
			System.out.print(vo.getEmail() + " : ");
			System.out.println("\n");
		}

	}

	public static void testInsert() throws ClassNotFoundException, SQLException {

		EmailListVo vo = new EmailListVo();
		vo.setFirstName("Lee");
		vo.setLastName("Jieun");
		vo.setEmail("lee920328@nate.com");

		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
		
		vo.setFirstName("Lee2");
		vo.setLastName("Jieun2");
		vo.setEmail("lee920328@nate.com2");

	
		dao.insert(vo);

	}

	public static void testDelete() throws Exception{
		EmailListDao dao = new EmailListDao();
		dao.delete();
		
		
	}

}
