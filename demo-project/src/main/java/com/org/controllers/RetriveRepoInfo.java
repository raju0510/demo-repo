package com.org.controllers;

import com.org.data.Item;

import com.org.service.RemoteRepoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetriveRepoInfo {

    @Autowired
    RemoteRepoInfoService repoInfoService;
    @GetMapping("/status")
    public String status() {
        return "It Works!";
    }

    @GetMapping("/repo-info")
    public List<Item> retriveReopInfo() {
        return repoInfoService.retriveReopInfo();
    }

}
