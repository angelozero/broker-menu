package com.angelozero.broker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDTO {

    private String id;
    private String cpf;
    private String email;
    private String name;
    private List<MenuDTO> menus;
}
