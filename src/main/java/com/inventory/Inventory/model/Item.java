package com.inventory.Inventory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Item {

    private @Id @GeneratedValue UUID id;
    private @NonNull String name;
    private @NonNull String inventoryCode;
    private int amount;

    public Item(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty String inventoryCode, @JsonProperty int amount){
        this.id = id;
        this.name = name;
        this.inventoryCode = inventoryCode;
        this.amount = amount;
    }

    public Item() {}

    public UUID getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getInventoryCode(){
        return inventoryCode;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setInventoryCode(@NonNull String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

}
