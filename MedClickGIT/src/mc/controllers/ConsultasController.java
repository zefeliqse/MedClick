package mc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mc.daos.ConsultasDAO;
import mc.daos.MedicosDAO;
import mc.daos.PacientesDAO;
import mc.models.Consultas;
import mc.models.Medico;
import mc.models.Paciente;

@Controller
public class ConsultasController {

	@RequestMapping(value = "consultas/lista", method = RequestMethod.GET)
	public ModelAndView listar(HttpSession session) {

		String email = (String) session.getAttribute("email");

		ModelAndView modelAndView = new ModelAndView();

		if (email != null) {

			PacientesDAO dao2 = new PacientesDAO();

			long id = dao2.getId(email);

			ConsultasDAO dao = new ConsultasDAO();

			List<Consultas> l1 = dao.getAllByID(id);
			List<Consultas> l2 = dao.getListaPasClie(id);
			List<Consultas> l3 = dao.getListaDiaClie(id);
			List<Consultas> l4 = dao.getListaFutClie(id);

			modelAndView.setViewName("consultas/listar");
			modelAndView.addObject("completa", l1);
			modelAndView.addObject("passadas", l2);
			modelAndView.addObject("dia", l3);
			modelAndView.addObject("futuras", l4);
		} else {

			modelAndView.setViewName("ap/denied");

		}

		System.out.println("Lista de consultas");
		return modelAndView;
	}

	@RequestMapping(value = "consultas/remarcar", method = RequestMethod.GET)
	public ModelAndView selecionar(long id, HttpSession session) {

		String email = (String) session.getAttribute("email");
		Long tst = id;

		ModelAndView modelAndView = new ModelAndView();

		if (email != null) {

			if (id < 0 || tst == null) {
				modelAndView.setViewName("consultas/lista");
				return modelAndView;
			}

			ConsultasDAO dao = new ConsultasDAO();
			Consultas con = dao.getByID(id);

			modelAndView.setViewName("consultas/remarcar");
			modelAndView.addObject("con", con);

		}

		System.out.println("Remarcando...");
		return modelAndView;
	}

	@RequestMapping(value = "consultas/remarcar", method = RequestMethod.POST)
	public ModelAndView remarcar(Consultas c, HttpSession session) {
		ConsultasDAO dao = new ConsultasDAO();
		dao.remarcar(c);

		return listar(session);
	}

	@RequestMapping(value = "consultas/cancelar", method = RequestMethod.GET)
	public ModelAndView cancelar(long id, HttpSession session) {

		String email = (String) session.getAttribute("email");
		ModelAndView modelAndView = new ModelAndView();

		if (email != null) {
			ConsultasDAO dao = new ConsultasDAO();
			dao.cancelar(id);

			return listar(session);
		} else {

			modelAndView.setViewName("ap/denied");
			return modelAndView;
		}

	}

	@RequestMapping(value = "consultas/marcar", method = RequestMethod.POST)
	public String marcar(Consultas c, HttpSession session) {
		PacientesDAO dao2 = new PacientesDAO();
		ConsultasDAO dao = new ConsultasDAO();

		String email = (String) session.getAttribute("email");
		String cpf = dao2.getCof(email);

		if (cpf != null) {
			c.setCpf(cpf);
			dao.marcar(c);
		}

		return "redirect:lista";
	}

	@RequestMapping(value = "consultas/marcar", method = RequestMethod.GET)
	public ModelAndView marcar(HttpSession session) {

		String email = (String) session.getAttribute("email");

		ModelAndView modelAndView = new ModelAndView();

		if (email != null) {

			MedicosDAO dao = new MedicosDAO();
			List<Medico> medicos = dao.getLista();

			modelAndView.setViewName("consultas/form");
			modelAndView.addObject("medicos", medicos);
		} else {
			modelAndView.setViewName("ap/denied");
		}

		return modelAndView;
	}
}
