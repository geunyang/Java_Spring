package com.ballza.lunch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ballza.lunch.model.LunchRow;
import com.ballza.lunch.service.LunchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/lunch")
public class LunchController {

	private final LunchService lunchService;

	public LunchController(LunchService lunchService) {
		this.lunchService = lunchService;
	}

//	@RequestMapping(value = {"/",""}, method=RequestMethod.GET)
//	public String home() {
//		String queryString = lunchService.queryString(null);
//		lunchService.getLunchRows(queryString);
//		return "home";
//	}
//	
	@ResponseBody
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<LunchRow> home() {
		String queryString = lunchService.queryString(null);
		List<LunchRow> lunchs = lunchService.getLunchRows(queryString);
		return lunchs;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String list(Model model) {

		String queryString = lunchService.queryString(null);
		List<LunchRow> lunchs = lunchService.getLunchRows(queryString);

		model.addAttribute("LUNCHS", lunchs);

		return "home";
	}

	@RequestMapping(value = "/{MLSV_YMD}/menu", method = RequestMethod.GET)
	public String detail(@PathVariable("MLSV_YMD") String MLSV_YMD, Model model) {

		String queryString = lunchService.queryString(null);
		List<LunchRow> lunchs = lunchService.getLunchRows(queryString);

		LunchRow vo = null;
		for (LunchRow VV : lunchs) {
			if (VV.getMLSV_YMD().equals(MLSV_YMD)) {
				vo = VV;
				break;
			}

		}
		log.debug("실험결과 : " + vo);
		model.addAttribute("RECALL", vo);

		return "/menu";
	}

}