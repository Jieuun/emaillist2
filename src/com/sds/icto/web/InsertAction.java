package com.sds.icto.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException,
			ServletException {
		

		//이메일을 등록합니다
		String firstName = request.getParameter("fn");
		String lastName = request.getParameter("ln");
		String email = request.getParameter("email");

		EmailListVo vo = new EmailListVo();
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);

		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
		
		response.sendRedirect("/EmailList2/el");

	}

}
