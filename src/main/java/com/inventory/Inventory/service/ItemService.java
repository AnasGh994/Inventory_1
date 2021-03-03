package com.inventory.Inventory.service;

import com.inventory.Inventory.dao.ItemRepo;
import com.inventory.Inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    private ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }
    public Item addItem(Item item){
        return itemRepo.save(item);
    }
    public List<Item> getAllItem(){
        return itemRepo.findAll();
    }
    public Optional<Item> getItemById(UUID id){
        return itemRepo.findById(id);
    }
    public void deleteItem(UUID id){
        itemRepo.deleteById(id);
    }
    //public int updateItem(UUID id, Item newItem){return itemRepo.updateItemById(itemRepo.findById(id));}
}
