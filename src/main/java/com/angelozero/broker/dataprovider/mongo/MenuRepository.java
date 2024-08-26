package com.angelozero.broker.dataprovider.mongo;

import com.angelozero.broker.dataprovider.mongo.collections.MenuCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends MongoRepository<MenuCollection, String> {

    @Query("{ 'id': { $in: ?0 } }")
    List<MenuCollection> findByIds(List<String> ids);

}
