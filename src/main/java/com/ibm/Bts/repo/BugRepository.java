package com.ibm.Bts.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ibm.Bts.entity.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {

}
