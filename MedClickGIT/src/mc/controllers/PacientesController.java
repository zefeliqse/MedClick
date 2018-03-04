package mc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mc.daos.ConsultasDAO;
import mc.daos.PacientesDAO;
import mc.models.Consultas;
import mc.models.Paciente;


@Controller
public class PacientesController {
	
	@RequestMapping(value = "pacientes/lista", method = RequestMethod.GET)
	public ModelAndView listar(HttpSession session) {
		
		System.out.println("Alguém quer ver a lista");
		
		String email = (String) session.getAttribute("email"); // Recebe o email
		ModelAndView modelAndView = new ModelAndView();
		
		if(email != null){
			PacientesDAO dao = new PacientesDAO();
			List<Paciente> pacientes = dao.getLista();

			modelAndView.setViewName("pacientes/listar");
			modelAndView.addObject("lista", pacientes);

			System.out.println("Lista de pacientes");
		}else{
			
			modelAndView.setViewName("ap/denied");
		}
		

		return modelAndView;
	}

	@RequestMapping("pacientes/form")
	public String form() {

		System.out.println("Acessando form");
		return "pacientes/form";
	}


	
	@RequestMapping(value = "pacientes/cadastro", method = RequestMethod.POST)
	public String adicionar(Paciente p, HttpSession session) {
		
		System.out.println("Adicionando paciente");
	
		
		PacientesDAO dao = new PacientesDAO();
		
		if(dao.inserir(p) == true){
			session.setAttribute("email", p.getEmail());
			
			return "redirect:/";
		}else{
			
			return "pacientes/form";
		}
		
		
		
	}

	@RequestMapping(value = "pacientes/login", method = RequestMethod.GET)
	public String acesso() {
		return "pacientes/login";
	}

	@RequestMapping(value = "pacientes/login", method = RequestMethod.POST)
	public ModelAndView login(Paciente p, HttpSession session) {

		PacientesDAO dao = new PacientesDAO();
		ModelAndView modelAndView = new ModelAndView();
		
		session.setAttribute("email", p.getEmail());

		if (dao.login(p) == 1) {

			return painel(session);

		}else{
			
			modelAndView.setViewName("pacientes/form");
			session.invalidate();
			return modelAndView;
		}
		

	}

	@RequestMapping(value = "pacientes/pan", method = RequestMethod.GET)
	public ModelAndView painel(HttpSession session) {

		PacientesDAO dao1 = new PacientesDAO();
		ConsultasDAO dao2 = new ConsultasDAO();
		ModelAndView modelAndView = new ModelAndView();

		String email = (String) session.getAttribute("email");
		System.out.println(email);

		if (email != null) {
			Paciente p = dao1.getByEmail(email);

			if (p != null) {
				List<Consultas> con = dao2.getConsultasByCpf(p.getCpf());
				modelAndView.addObject("consultas", con);
				modelAndView.setViewName("pacientes/painel");

			} else {

				modelAndView.setViewName("pacientes/login");
			}

		} else {
			System.out.println("Deu erro!");
		}

		return modelAndView;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		
		return "redirect:/";
		
	}
	
}
