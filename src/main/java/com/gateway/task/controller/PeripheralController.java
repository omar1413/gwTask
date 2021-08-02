package com.gateway.task.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.task.entity.Peripheral;
import com.gateway.task.service.PeripheralService;

@RestController
@RequestMapping("peripheral")
public class PeripheralController extends BaseController {
	
	@Autowired
	private PeripheralService peripheralService;
	
	@DeleteMapping("/{id}")
	public Map<String, String> remove(@PathVariable Long id){
		peripheralService.remove(id);
		Map<String , String> map =  new HashMap<String, String>();
		map.put("success", "true");
		return map;
	}
	
	
	@GetMapping("/{id}")
	public Peripheral get(@PathVariable Long id){
		return peripheralService.get(id);
		
		
	}

}
