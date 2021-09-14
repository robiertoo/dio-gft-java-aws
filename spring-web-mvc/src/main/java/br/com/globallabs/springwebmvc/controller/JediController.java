package br.com.globallabs.springwebmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;

@Controller
public class JediController {
	@Autowired
	private JediRepository repository;
	
	@GetMapping("/jedi")
	public ModelAndView jedi() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jedi");
		mv.addObject("allJedi", repository.getAll());
		return mv;
	}
	
	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("new-jedi");
		
		mv.addObject("jedi", new Jedi());
		return mv;
	}
	
	@PostMapping("/jedi")
	public String newJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "new-jedi";
		
		repository.add(jedi);
		redirect.addFlashAttribute("message", "Jedi successfully created!");
		
		return "redirect:jedi";
		
	}
}
