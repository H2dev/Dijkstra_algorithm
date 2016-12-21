package hr.razv.h2.dijkstra.web.controllers;

import hr.razv.h2.dijkstra.MatricaDirekt;
import hr.razv.h2.dijkstra.ModelRjesenje;

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
public class PocetniController {
	
	private static final String PRIKAZ_INDEX = "index";
	private static final String PRIKAZ_UPIS_UDALJENOSTI = "upis_udaljenosti";
	private static final String REZULTAT = "rezultat";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PocetniController.class);
	
//	@Scope("session")
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String indexPage ( ModelMap model ) {
//		
//		return PRIKAZ_INDEX;
//	}
	
	
	@Scope("session")
	@RequestMapping(value = {"/", "index", "/upis_udaljenosti"}, method = RequestMethod.GET)
	public String upis_udaljenosti ( ModelMap model, 
									 HttpSession session,
									 @RequestParam(value="n", required=false) Integer n ){
		
		ArrayList<Character> listaSlova = new ArrayList<Character>();
//		int unicodeIndex = 41;
//		String unicode = "\\u" + "00";
		for (int i = 0; i < 26; i++) {
			listaSlova.add( (char) (65 + i) );
		}
		
	
		session.setAttribute("n", n);
		session.setAttribute("listaSlova", listaSlova);
						
		
		return PRIKAZ_UPIS_UDALJENOSTI;
	}
	
	
	@Scope("session")
	@RequestMapping(value = "/rezultat", method = RequestMethod.POST)
	public String rezultat ( ModelMap model, 
									     HttpSession session,
									     HttpServletRequest request ){
		
		System.out.println("element00: " + request.getParameter("element00"));
		System.out.println("element01: " + request.getParameter("element01"));
		
		int n = (int) session.getAttribute("n");
		
		String[][] matrica = new String[n][n];
		
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) {
				String stringIndeks = Integer.toString(i) + Integer.toString(j);
				matrica[i][j] = request.getParameter( "element" + stringIndeks );
			}		
		
		session.setAttribute("matrica", matrica);
		
		ModelRjesenje rjesenje = MatricaDirekt.provuciMatricu( n, matrica );
		
		model.addAttribute("duljinaPuta", rjesenje.getRjesenjeDuljinaPuta() );
		model.addAttribute("put", rjesenje.getRjesenjePut().toString() );
		model.addAttribute("matrica", matrica);
		model.addAttribute("n", n);
				
		System.out.println("Ukupna duljina puta je: " + rjesenje.getRjesenjeDuljinaPuta() + " jedinica.\n");
		System.out.println("Put je redosljedom: " + rjesenje.getRjesenjePut() );
		
		return REZULTAT;
	}

	
		
}
