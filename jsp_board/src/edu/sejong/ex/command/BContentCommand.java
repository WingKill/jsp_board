package edu.sejong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.BDao;
import edu.sejong.ex.dto.BDto;

public class BContentCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bIdStr = request.getParameter("bid");
		int bid = Integer.parseInt(bIdStr);
		BDao dao = new BDao();
		
		dao.uphit(bid);
		BDto board = dao.contentView(bid);
		request.setAttribute("content_view", board);
	}
}
