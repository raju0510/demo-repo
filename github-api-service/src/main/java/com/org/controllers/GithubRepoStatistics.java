package com.org.controllers;

import com.org.data.Item;

import com.org.service.RemoteRepoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GithubRepoStatistics {

    @Autowired
    RemoteRepoInfoService repoInfoService;
    @GetMapping("/repo-info")
    public List<Item> retriveReopInfo() {
        return repoInfoService.retriveReopInfo();
    }

}
