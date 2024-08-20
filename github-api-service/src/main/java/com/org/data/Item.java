package com.org.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class Item {

    public String full_name;
    public String description;
    public Date created_at;
    public String clone_url;
    public int stargazers_count;
}