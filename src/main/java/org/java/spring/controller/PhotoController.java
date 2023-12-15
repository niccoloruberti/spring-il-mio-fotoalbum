package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public String getPhotos(Model model) {
		
		List<Photo> photos = photoService.findAll();
		
		model.addAttribute("photos", photos);
		
		return "photos";
	}
}
