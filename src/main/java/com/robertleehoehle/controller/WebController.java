package com.robertleehoehle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.robertleehoehle.beans.Items;

@Controller
public class WebController {
	@Autowired
	private ItemService service;
	
	@RequestMapping("/")
	public String ViewHomePage(Model model) {
		List<Items> listItems = service.listAll();
		model.addAttribute("listItems", listItems);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewItemForm(Model model) {
		Items items = new Items();
		model.addAttribute("items", items);
		
		return "new_item";
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute("items") Items items) {
		service.save(items);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showNewItemForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_item");
		
		Items items = service.get(id);
		mav.addObject("items", items);
		
		return mav;
		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteItem(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
	
}
