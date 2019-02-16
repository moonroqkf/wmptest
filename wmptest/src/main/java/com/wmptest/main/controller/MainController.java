package com.wmptest.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmptest.main.service.MainService;
import com.wmptest.main.vo.MainVo;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 메인화면
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/index")
	  public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/main/index");
		
		return mv;
	  }
	
	/**
	 * 출력버튼에 대한 ajax 요청 처리
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/printOut", method=RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody MainVo printOut(@ModelAttribute MainVo vo) {
		
		logger.info("url :: "+vo.getUrl());
		logger.info("pringGroupSize :: "+vo.getPrintGroupSize());
		
		vo = mainService.printOut(vo);
		
		return vo;
	}
	
	
}