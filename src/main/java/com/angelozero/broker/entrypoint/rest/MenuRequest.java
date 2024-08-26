package com.angelozero.broker.entrypoint.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MenuRequest {

    private String id;
    private String highLevel;
    private String name;
    private List<MenuRequest> menus;
}
