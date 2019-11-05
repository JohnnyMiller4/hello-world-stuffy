package com.stuffy.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stuffy.business.Stuffy;
import com.stuffy.db.StuffyRepository;

@CrossOrigin
@RestController
@RequestMapping("/stuffies")
public class StuffyController {
	
//	@GetMapping("/") //exposes the following method to the web.
//	public Stuffy createAStuffy() {
//		Stuffy s = new Stuffy(1, "Monkey", "Blue", "Large", 4);
//		return s;
//	}
	
	@Autowired
	private StuffyRepository stuffyRepo;
	
	//list - return all stuffies
	@GetMapping("/") //exposes the following method to the web.
	public JsonResponse listStuffies() {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(stuffyRepo.findAll());
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	
	//get - return 1 stuffy for the given id
	@GetMapping("/{id}") //exposes the following method to the web.
	public JsonResponse getStuffy(@PathVariable int id) {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(stuffyRepo.findById(id));
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	//URL = http://localhost:8080/stuffies/5 = Dolphin stuffy table
	
	//demo of request parameters
	//URL = http://localhost:8080/stuffies?id=10&type=fish&color=pink&size=small&limbs=0
//	@GetMapping("")
//	public Stuffy createAStuffy(@RequestParam int id, @RequestParam String type,
//			@RequestParam String color, @RequestParam String size, @RequestParam int limbs) {
//		Stuffy s = new Stuffy(id, type, color, size, limbs);
//		return s;
//	}
	
		//add - adds a new stuffy
		@PostMapping("/")
		public JsonResponse addStuffy(@RequestBody Stuffy s) {
		JsonResponse jr = null;
			try {
				jr = JsonResponse.getInstance(stuffyRepo.save(s));
			}
			catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
		return jr;
		}
		
		//update - updates a stuffy
		@PutMapping("/")
		public JsonResponse updateStuffy(@RequestBody Stuffy s) {
		JsonResponse jr = null;
			try {
				if (stuffyRepo.existsById(s.getId())) {
				jr = JsonResponse.getInstance(stuffyRepo.save(s));
				} else {
					//record doesn't exist
					jr = JsonResponse.getInstance("Error updating Stuffy. ID: " + s.getId() + " does not exist.");
				}
			}
			catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
		return jr;
		}
		
		//delete - delete a stuffy
		@DeleteMapping("/{id}")
		public JsonResponse deleteStuffy(@PathVariable int id) {
		JsonResponse jr = null;	
			try {
				if (stuffyRepo.existsById(id)) {
					stuffyRepo.deleteById(id);
					jr = JsonResponse.getInstance("Delete sucessful!");
				} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error deleting Stuffy. ID: " + id + " does not exist.");
				}
			}
			catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
		return jr;
		}
	
		

}
