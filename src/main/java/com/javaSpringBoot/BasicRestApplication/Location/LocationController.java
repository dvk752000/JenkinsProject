package com.javaSpringBoot.BasicRestApplication.Location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	
   @Autowired
   private LocationService locationService;
   
   @RequestMapping(method=RequestMethod.POST, value="/locations")
   public void addLocation(@RequestBody Location location) {
   	locationService.addLocation(location);
   }
   
   @RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
   public void deleteLocation(@PathVariable String id) {
       locationService.deleteLocation(id);
   }
	
   @RequestMapping(value = "/locations")
   public List<Location> getAllLocations() 
   {
	return locationService.getAllLocations();
   }		
   
   @RequestMapping(value = "/locations/{id}")
   public Location getLocation(@PathVariable String id) {
   	return locationService.getLocation(id);
   }
   

   
   
   
   //DataBase functions
   @GetMapping("/allLocations")  
   private List<Location> getAllLocationsDb()   
   {  
   return locationService.getAllLocationsFromDB();  
   }  
   @GetMapping("/student/{id}")  
   private Location getLocation(@PathVariable("id") int id)   
   {  
   return locationService.getLocationById(id);  
   }  
}
