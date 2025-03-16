package com.wipro.service;

import java.util.List;

import com.wipro.entity.Item;

public interface IItemService {
	public  List<Item> getItems(int pageNumber);
}
