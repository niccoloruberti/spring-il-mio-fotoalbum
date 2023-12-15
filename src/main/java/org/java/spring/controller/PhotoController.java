package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public String getPhotos(Model model) {
		
		List<Photo> photos = photoService.findAll();
		
		model.addAttribute("photos", photos);
		
		return "photos";
	}
	
	@GetMapping("/photos/{id}")
	public String getPhoto(Model model, @PathVariable int id) {
		
		Photo photo = photoService.findById(id);
		
		List<Category> categories = photo.getCategories();
		
		model.addAttribute("photo", photo);
		
		model.addAttribute("categories", categories);
		
		return "photo";
	}
}
