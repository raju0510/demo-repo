package com.org.service;

import com.org.config.WebClientConfiguration;
import com.org.data.Item;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//@AllArgsConstructor
@SpringBootTest
class RemoteRepoInfoServiceImplTest {
    @Autowired
    RemoteRepoInfoService remoteRepoInfoService;

    List<Item> expected = null;

    @BeforeEach
    void setUp() throws ParseException {
        String pattern = "EEE MMM dd HH:mm:ss zzz yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        // Set the time zone to SGT (Singapore Time)
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
        // The date string to parse
        String dateString_one = "Mon Aug 19 21:05:55 SGT 2024";
        String dateString_two = "Tue Aug 20 14:19:21 SGT 2024";

        Date date_one = sdf.parse(dateString_one);
        Date date_two = sdf.parse(dateString_two);


        expected = Arrays.asList(new Item("raju0510/demo-repo",
                        " demo repository to leverage github api",date_one ,
                        "https://github.com/raju0510/demo-repo.git",1),

                new Item("raju0510/demo-repo-1",
                        "public demo repository for testing",date_two ,
                        "https://github.com/raju0510/demo-repo-1.git",0)
        );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void When_retriveReopInfo_Expcet_NotNull() {
       List<Item> result = remoteRepoInfoService.retriveReopInfo();
        assertNotNull(result);
    }

    @Test
    void When_retriveReopInfo_Except_Same_Result() {
        List<Item> actual = remoteRepoInfoService.retriveReopInfo();
        assertEquals(expected,actual);
    }


}