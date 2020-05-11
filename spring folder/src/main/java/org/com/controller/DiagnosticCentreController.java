package org.com.controller;


import java.util.List;
import java.util.Set;

import org.com.error.RecordNotFoundException;
import org.com.model.DiagnosticCentre;
import org.com.service.DiagnosticCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/centre")
public class DiagnosticCentreController {

	@Autowired
	private DiagnosticCentreService dcservice;
	
	// add new centre
	@PostMapping("/addCentre")
	public String addCentre(@RequestBody DiagnosticCentre diagnosticcentre) {

		return dcservice.addCentre(diagnosticcentre);

	}

	// update centre
	@PutMapping("/updateCentre/{centreId}")
	public String updateCentre(@PathVariable(value = "centreId") int centreId, @RequestBody DiagnosticCentre diagnosticcentredetails)
			throws RecordNotFoundException {

		return dcservice.updateCentre(centreId, diagnosticcentredetails);
	}

	// delete centre
	@DeleteMapping("/deleteCentre/{centreId}")
	public String deleteCentre(@PathVariable(value = "centreId") int centreId) throws RecordNotFoundException {

		return dcservice.deleteCentre(centreId);
	}

	// get Centre By Id
	@GetMapping("/findCentreById/{centreId}")
	public ResponseEntity<DiagnosticCentre> getCentreById(@PathVariable(value = "centreId") int centreId)
			throws RecordNotFoundException {

		return dcservice.getCentreById(centreId);
	}

	// Get All Centre
	@GetMapping("/AllCentre")
	public List<DiagnosticCentre> getAllCentre(int centreId) {

		return dcservice.getAllCentre(centreId);

	}

	

}
