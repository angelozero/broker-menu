package com.angelozero.broker.dataprovider.mongo.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "person")
public class PersonCollection {

    @Id
    private String id;

    @Indexed
    private String cpf;

    @Indexed
    private String email;

    private String name;

    private List<String> menusIds;
}
