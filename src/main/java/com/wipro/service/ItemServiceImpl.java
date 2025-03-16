package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.dao.ItemDao;
import com.wipro.entity.Item;

@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private ItemDao dao;
	
	@Override
	public List<Item> getItems(int pageNumber) {
		Pageable pageable=PageRequest.of(pageNumber, 10);
		return dao.findAll(pageable).getContent();
	}
}
