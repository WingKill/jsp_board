package edu.sejong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.BDao;
import edu.sejong.ex.dto.BDto;

public class BDeleteCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bidStr = request.getParameter("bid");
		int bid = Integer.valueOf(bidStr);
		
		BDto dto = new BDto();
		dto.setBid(bid);
		
		BDao dao = new BDao();		
		dao.delete(dto);
	}
}
