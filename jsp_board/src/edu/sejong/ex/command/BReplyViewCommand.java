package edu.sejong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.BDao;
import edu.sejong.ex.dto.BDto;

public class BReplyViewCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bidStr = request.getParameter("bid");
		BDao dao = new BDao();
		
		dao.uphit(Integer.valueOf(bidStr));
		
		BDto dto = dao.replyView(bidStr);
		
		
		request.setAttribute("reply_view", dto);
	}
}
