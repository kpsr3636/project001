package com.shopme.admin.user;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.common.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/users")
	public String listaLL(Model model) {

		List<User> listUsers = userservice.listAll();

		model.addAttribute("listUsers", listUsers);

		return "users";
	}

	@GetMapping("/users/new")
	public String newUser(Model model) {

		List<com.shopme.common.entity.Role> listRoles = userservice.listRoles();

		User user = new User();
		user.setEnanled(true);

		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("pageTitle", "Create New User");

		return "user_form";
	}

	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes redirectAttributes) {

		System.out.println(user);
		userservice.save(user);
		redirectAttributes.addFlashAttribute("message", "The Usser has been saved Successfully");
		return "redirect:/users";
	}

	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {

		try {
			User user = userservice.getById(id);
			List<com.shopme.common.entity.Role> listRoles = userservice.listRoles();

			model.addAttribute("user", user);

			model.addAttribute("pageTitle", "EditUser(ID:" + id + ")");
			model.addAttribute("listRoles", listRoles);

			return "user_form";
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			return "redirect:/users";
		}

	}
	
	
	
	@GetMapping("/users/delete/{userId}")
	public String deleteUser(@PathVariable(name="userId") Integer userId, Model model, RedirectAttributes redirectAttributes) {
		
		
		try {
			
			userservice.delete(userId);
			redirectAttributes.addFlashAttribute("message", "The user Id "+userId+"has been deleted successfully");
			
			 //return "user_form";
		}catch(UserNotFoundException ex) {
				
				redirectAttributes.addFlashAttribute("message", ex.getMessage());
                 //  return "redirect:/users";
			}
		  return "redirect:/users";
		}
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	

