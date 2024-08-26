package com.angelozero.broker.dataprovider.mongo.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "menu")
public class MenuCollection {

    @Id
    private String id;

    private String highLevel;

    private String name;

}
