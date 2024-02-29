package edu.sejong.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.command.BCommand;
import edu.sejong.ex.command.BContentCommand;
import edu.sejong.ex.command.BDeleteCommand;
import edu.sejong.ex.command.BListCommand;
import edu.sejong.ex.command.BModifyCommand;
import edu.sejong.ex.command.BReplyCommand;
import edu.sejong.ex.command.BReplyViewCommand;
import edu.sejong.ex.command.BWriteCommand;

/**
 * Servlet implementation class BController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ..");
		
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ..");
		
		actionDo(request,response);
	}
	
	// *.do로 끝나는 접속경로로 요청이 올 경우 처리하는 메서드
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo() ..");
		
		request.setCharacterEncoding("UTF-8");
		
		// 이동 경로
		String viewPage = null;
		// 처리 객체
		BCommand command = null;
		
		String uri = request.getRequestURI();		
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		System.out.println("uri : " + uri);
		System.out.println("contextPath : " + contextPath);
		System.out.println("com : " + com);
		
		if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);			
			viewPage = "/list.do";
		}else if(com.equals("/content_view.do")) {
			// http://localhost:8282/jsp_board/content_view.do?bid=3
			command = new BContentCommand();
			command.execute(request, response);			
			viewPage = "content_view.jsp";
		}else if(com.equals("/modify_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);			
			viewPage = "modify_view.jsp";
		}else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);			
			viewPage = "/list.do";
		}else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);			
			viewPage = "/list.do";
		}else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "/list.do";
		}else if(com.equals("/tables.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "board_tables.jsp";
		}
				
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
			
	}
}
