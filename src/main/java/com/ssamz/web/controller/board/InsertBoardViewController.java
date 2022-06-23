package com.ssamz.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InsertBoardViewController {

	@RequestMapping("/insertBoard.do")
	public String insertBoard() {
		return "insertBoard";

		/*
		 * ModelAndView mav = new ModelAndView(); mav.setViewName("insertBoard"); 
		 * return mav;
		 */
	}

}
