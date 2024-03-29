package com.artefatox.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artefatox.repository.demo.Demo;
import com.artefatox.repository.demo.DemoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoRepository repository;
	
	@GetMapping
	public List<Demo> list() {
		return repository.findAll();
	}
	
	@PostMapping
	@Transactional
	public Demo create(@RequestBody Demo demo) {
		return repository.save(demo);
	}
}
