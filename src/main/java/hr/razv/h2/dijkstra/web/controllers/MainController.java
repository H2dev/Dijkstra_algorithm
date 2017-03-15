package hr.razv.h2.dijkstra.web.controllers;

import hr.razv.h2.dijkstra.MatrixDirect;
import hr.razv.h2.dijkstra.ResultModel;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	private static final String DISTANCE_ENTRY_VIEW = "distance_entry";
	private static final String RESULT = "result";

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

	@Scope("session")
	@RequestMapping(value = { "/", "/distance_entry" }, method = RequestMethod.GET)
	public String distance_entry(ModelMap model, HttpSession session,
			@RequestParam(value = "n", required = false) Integer n) {

		logger.info("I'm in distance_entry controller");

		ArrayList<Character> characterList = new ArrayList<Character>();
		for (int i = 0; i < 26; i++) {
			characterList.add((char) (65 + i));
		}

		session.setAttribute("n", n);
		session.setAttribute("characterList", characterList);

		return DISTANCE_ENTRY_VIEW;
	}

	@Scope("session")
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(ModelMap model, HttpSession session, HttpServletRequest request) {

		logger.info("I'm in result controller");

		int n = (int) session.getAttribute("n");
		String[][] matrix = new String[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				String stringIndex = Integer.toString(i) + Integer.toString(j);
				matrix[i][j] = request.getParameter("element" + stringIndex);
			}

		session.setAttribute("matrix", matrix);

		ResultModel result = MatrixDirect.processMatrix(n, matrix);

		model.addAttribute("routeDistance", result.getResultRouteDistance());
		model.addAttribute("route", result.getResultRoute().toString());
		model.addAttribute("matrix", matrix);
		model.addAttribute("n", n);

		return RESULT;
	}

}
