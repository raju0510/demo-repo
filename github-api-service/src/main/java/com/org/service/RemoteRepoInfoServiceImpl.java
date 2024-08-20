package com.org.service;

import com.org.config.WebClientConfiguration;
import com.org.data.Item;
import com.org.data.Repository_Info_Data;
import com.org.persist.Repository_Info_Entity;
import com.org.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RemoteRepoInfoServiceImpl implements RemoteRepoInfoService {

    @Autowired
   private  WebClientConfiguration webClientConfig;

    @Autowired
    private UserRepository userRepository ;
    @Override
    public List<Item> retriveReopInfo() {

        Optional<Repository_Info_Data> result = webClientConfig.webClientConsumer().blockOptional();
        //return result.isPresent() ? result.get() : new Repository_Info_Data();
        Repository_Info_Data repo_data = result.orElseGet(Repository_Info_Data::new);
        //save results to database
        saveResult(repo_data);
        return repo_data.getItems();
    }

    /**
     * Save the response to the database
     * @param repo_data
     */
    private  void saveResult(Repository_Info_Data repo_data) {

        List<Repository_Info_Entity> repoentityList = repo_data.getItems().
                stream()
                .map(new Function<Item, Repository_Info_Entity>() {
                    @Override
                    public Repository_Info_Entity apply(Item item) {
                        Repository_Info_Entity repositoryInfoEntity = new Repository_Info_Entity();
                        repositoryInfoEntity.setFull_name(item.getFull_name());
                        repositoryInfoEntity.setDescription(item.getDescription());
                        repositoryInfoEntity.setClone_url(item.getClone_url());
                        repositoryInfoEntity.setStargazers_count(item.getStargazers_count());
                        repositoryInfoEntity.setCreated_at(item.getCreated_at());

                        return repositoryInfoEntity;
                    }
                }).toList();

        log.info("======================================");
        log.info("entity list to save {}",repoentityList);


        List<Repository_Info_Entity> savedList = (List<Repository_Info_Entity>) userRepository.saveAll
                (
                    repoentityList.stream()
                    .filter(entity -> !userRepository.findByFullName(entity.getFull_name()).isPresent())
                    .collect(Collectors.toList())
                );
        log.info("======================================");
        log.info("saved list ",savedList);
    }
}
