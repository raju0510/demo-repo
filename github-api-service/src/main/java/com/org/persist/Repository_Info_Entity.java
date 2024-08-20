package com.org.persist;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Entity
@Table(name = "repo_stats")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Repository_Info_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String  full_name;
    private String  description;
    private String  clone_url;
    private int  stargazers_count;
    private Date created_at;
}
