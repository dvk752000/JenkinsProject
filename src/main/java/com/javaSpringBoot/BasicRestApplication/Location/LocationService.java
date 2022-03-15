package com.javaSpringBoot.BasicRestApplication.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	   //database
	   @Autowired  
	   LocationRepository locationRepository;  
	   
	   //getting all student records  
	   public List<Location> getAllLocationsFromDB()   
	   {  
	   List<Location> locations = new ArrayList<Location>();  
	   locationRepository.findAll().forEach(location -> locations.add(location));  
	   return locations;  
	   }  
	   
	   public Location getLocationById(int id)   
	   {  
	   return locationRepository.findById(id).get();  
	   }  
	
	
	
   Location location1 = new Location("l1", "Lagos");
   Location location2 = new Location("l2", "Asaba");
   Location location3 = new Location("l3", "Budapest");	
   
   List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3));
	
   public List<Location> getAllLocations() {
		
	return locations;
   }
   public Location getLocation(String id) {
	    Location location = locations.stream()
		.filter(t -> id.equals(t.getId()))
		.findFirst()
		.orElse(null);
			
	    return location;
	}
   
   public void addLocation(Location location) {
	     locations.add(location);
	}
   
   public void deleteLocation(String id) {
	    locations.removeIf(t -> t.getId().equals(id));
	}
   
   
   

}