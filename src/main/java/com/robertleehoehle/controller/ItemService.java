package com.robertleehoehle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.robertleehoehle.beans.Items;
import com.robertleehoehle.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	public List<Items> listAll() {
		return repo.findAll();
	}
	
	public void save(Items items) {
		repo.save(items);
	}
	
	public Items get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
