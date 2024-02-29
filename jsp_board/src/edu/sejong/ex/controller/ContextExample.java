package edu.sejong.ex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextExample
 */
@WebServlet("/context")
public class ContextExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ..");
		
		String kor = getServletContext().getInitParameter("kor");
		String eng = getServletContext().getInitParameter("eng");
		String math = getServletContext().getInitParameter("math");
		
		System.out.println("국어 : "+kor+", 영어 : "+eng+", 수학 : "+math);
		int sum = Integer.valueOf(kor) + Integer.valueOf(eng) + Integer.valueOf(math);
		System.out.println("총점 : " + sum);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ..");
	}

}
