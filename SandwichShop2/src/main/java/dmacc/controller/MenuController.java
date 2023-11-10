package dmacc.controller;

//@author valei - vlunderwood CIS175 - Fall 2023 Nov 02, 2023

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Menu;
import dmacc.repo.IMenuRepo;
import jakarta.validation.Valid;



@Controller
public class MenuController {
	@Autowired
	IMenuRepo repo;

	@GetMapping("/")
	public String getForm(Menu menu) {
		return "index";
	}
	
	@GetMapping({"results.html" })
	public String viewAllItems(Model model) {
		if (repo.findAll().isEmpty()) {
			return "index.html";
		}
		model.addAttribute("menu", repo.findAll());
		return "results";
	}

	@GetMapping("/add.html")
	public String addNewItem(Model model) {
		Menu m = new Menu();
		model.addAttribute("menu", m);
		return "add.html";
	}
	

	@PostMapping("/add-menu")
	public String addNewItem(@Valid @ModelAttribute Menu m, Errors errors, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		    return "add.html";
		} else {
		    repo.save(m);
		    model.addAttribute("successMsg", "Details saved successfully!!");
		    return viewAllItems(model);
		}	
		
		
		
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateItem(@PathVariable("id") long id, Model model) {
		Menu m = repo.findById(id).orElse(null);
		model.addAttribute("menu", m);
		return "add.html";
	}

	@PostMapping("/update-menu/{id}")
	public String reviseItem(Menu m, Model model) {
		repo.save(m);
		return viewAllItems(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteable(@PathVariable("id") long id, Model model) {
		Menu m = repo.findById(id).orElse(null);
		repo.delete(m);
		if (repo.findAll().isEmpty()) {
			return "index.html";
		}
		return viewAllItems(model);
	}
	
}