package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Bank;
import com.bank.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("/bank")
	public ResponseEntity<?> save(@RequestBody Bank bank)
	{
		long id=bankService.save(bank);
		return ResponseEntity.ok().body("New account created"+id);
	}
	
	@GetMapping("/bank/{id}")
	public ResponseEntity<Bank> get(@PathVariable("id") long id)
	{
		Bank bank=bankService.get(id);
		return ResponseEntity.ok().body(bank);
		
	}
	
	@PostMapping("/login/{id}/{pass}")
	public ResponseEntity<?> login(@PathVariable("id") long id,@PathVariable("pass") String pass)
	{
		Boolean b=bankService.login(id, pass);
		if(b==true)
		{
			return ResponseEntity.ok().body("login success");
		}
		else
		{
			return ResponseEntity.ok().body("login failed");
		}
	}
	
	@PostMapping("transfer/{fromid}/{toid}/{amt}")
	public ResponseEntity<?> transfer(@PathVariable("fromid") long fromid,@PathVariable("toid") long toid,@PathVariable("amt") Integer amount)
	{
		bankService.transferbalance(fromid, toid, amount);
		return ResponseEntity.ok().body("Amount transferred successfully from"+fromid+"to id"+toid);
	}
	
	@GetMapping("/allbank")
	public ResponseEntity<?> getAllBank()
	{
		List<Bank> l=bankService.getAllBank();
		return ResponseEntity.ok().body(l);
	}
	
	

}
