package com.angelozero.broker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MenuDTO {

    private String id;
    private String highLevel;
    private String name;
    private List<MenuDTO> menus = new ArrayList<>();
}
