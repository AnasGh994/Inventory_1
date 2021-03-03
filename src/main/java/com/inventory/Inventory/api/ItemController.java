package com.inventory.Inventory.api;

import com.inventory.Inventory.model.Item;
import com.inventory.Inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemservice) {
        this.itemService = itemservice;
    }
    @PostMapping("/add")
    public Item addItem(@Validated @NonNull @RequestBody Item item){
        return itemService.addItem(item);
    }

    @GetMapping("/getAll")
    public List<Item> getAllPeople(){
        return itemService.getAllItem();
    }
    @GetMapping(path = "{id}")
    public Item getItemById(@PathVariable("id") UUID id){
        return itemService.getItemById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteItemById(@PathVariable("id") UUID id){
        itemService.deleteItem(id);
    }
    @PutMapping(path = "{id}")
    public Item updateItem(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Item itemToUpdate){
        //itemService.updateItem(id, itemToUpdate);
        itemToUpdate.setId(id);
        return itemService.addItem(itemToUpdate);
    }
}
