package com.sds.icto.EmailList2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.EmailList2.action.IndexAction;
import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.FormAction;
import com.sds.icto.web.InsertAction;
import com.sds.icto.web.WebUtil;

/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmailListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String a = request.getParameter("a");

			Action action = null;

			if ("form".equals(a)) {

				action = new FormAction();
				action.execute(request, response);

			} else if ("insert".equals(a)) {

				action = new InsertAction();
				action.execute(request, response);
			}
			if (action == null) {

				action = new IndexAction();
				action.execute(request, response);
			}

		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}
}
