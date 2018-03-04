package mc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mc.daos.MedicosDAO;
import mc.models.Medico;


@Controller
public class MedicosController {

	
	@RequestMapping(value="medicos/lista", method=RequestMethod.GET)
	public ModelAndView listar(HttpSession session) {
		
		String email = (String) session.getAttribute("email");
		ModelAndView modelAndView = new ModelAndView();
		
		if(email != null){
			MedicosDAO dao = new MedicosDAO();
			List<Medico> lista = dao.getLista();
			
			modelAndView.setViewName("medicos/listar");
			modelAndView.addObject("lista", lista);
			
			System.out.println("Lista de médicos");
		}else{
			modelAndView.setViewName("ap/denied");
		}
		
		return modelAndView;
	}
	
}
