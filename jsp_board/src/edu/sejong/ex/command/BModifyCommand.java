package edu.sejong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.BDao;
import edu.sejong.ex.dto.BDto;

public class BModifyCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bidStr = request.getParameter("bid");
		int bid = Integer.valueOf(bidStr);
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BDto dto = new BDto();
		dto.setBid(bid);
		dto.setBname(bname);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		
		BDao dao = new BDao();		
		dao.modify(dto);
	}
}
