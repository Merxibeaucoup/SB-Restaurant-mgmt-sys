package com.edgar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurant_table")
@Data
public class RestaurantTable {
   
    @Id
    @Column(name = "TABLE_ID")
    private long tableId;

    @Column(name = "TABLE_CAPACITY")
    private int capacity;

//    @Column(name = "TABLE_STATUS")
//    private TableStatus status;

}
