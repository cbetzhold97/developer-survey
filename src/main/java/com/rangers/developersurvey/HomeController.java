package com.rangers.developersurvey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private JDBC jdbc;

	@GetMapping("/")
	public String index(Model model) {
		List<String> dates = jdbc.getDate();
		model.addAllAttributes(getModelAttr(dates));
		return "index";
	}

	private Map<String, Object> getModelAttr() {

		Map<String, Object> ret = new HashMap<>();
		return ret;
	}

	private Map<String, Object> getModelAttr(List<String> dates) {

		Map<String, Object> ret = getModelAttr();

		if (dates != null && !dates.isEmpty()) {
			ret.put("dates", Util.toJSONString(dates));
		}
		return ret;
	}
}
