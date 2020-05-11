package org.com.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.com.dao.DiagnosticCentreRepositories;
import org.com.error.RecordNotFoundException;
import org.com.model.DiagnosticCentre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticCentreService {
	@Autowired
	private DiagnosticCentreRepositories dcdao;
	

//add Centre	
	public String addCentre(DiagnosticCentre diagnosticcentre)
	   {
		   dcdao.save(diagnosticcentre);
		   return "Centre Added Successfully...";
		   
	   }
	 
	 
//Update Centre	
	 public String updateCentre( int CentreId, DiagnosticCentre diagnosticcentredetails)
	    		throws RecordNotFoundException  {
	    	
		 DiagnosticCentre dc = dcdao.findById(CentreId).
	    	orElseThrow(() -> new RecordNotFoundException("Diagnostic Centre not found for the give id:" +CentreId));
	    	dc.setCentreName(diagnosticcentredetails.getCentreName());
	    	dc.setCentreAdress(diagnosticcentredetails.getCentreAdress());
	    	dc.setListOfTests(diagnosticcentredetails.getListOfTests());
	    	
	    	dcdao.save(dc);
	    	return "Centre Updated Successfully...";
	    }
	 
//Delete Centre	  
	 public String deleteCentre(int CentreId) throws RecordNotFoundException
	    {
	    	 dcdao.findById(CentreId).
	    	 orElseThrow(() -> new RecordNotFoundException("Centre not found for the given id" +CentreId));
	    	 dcdao.deleteById(CentreId);
	    	return "Centre Deleted Successfully...";
	    }
	 
//get All Centre
	 public List<DiagnosticCentre> getAllCentre(int centreId){
	    	
		    System.out.println("All Centres are:");
	    	return dcdao.findAll();
	    	
	    }

// get Centre By Id
	 public ResponseEntity<DiagnosticCentre> getCentreById(int centreId) throws RecordNotFoundException {
		 DiagnosticCentre d=dcdao.findById(centreId).
	   	 orElseThrow(() -> new RecordNotFoundException("Centre not found for the given id" +centreId));
	    	return ResponseEntity.ok().body(d);
	    }
	 }
