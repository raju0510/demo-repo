package com.org.data;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Repository_Info_Data {
    public int total_count;
    public boolean incomplete_results;
    public ArrayList<Item> items;
}
