package com.wipro.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wipro.entity.Item;

public interface ItemDao extends PagingAndSortingRepository<Item, Integer> {
	
}
