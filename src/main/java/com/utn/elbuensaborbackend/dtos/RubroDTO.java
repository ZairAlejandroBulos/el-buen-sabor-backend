package com.utn.elbuensaborbackend.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RubroDTO extends BaseDTO {

    private String denominacion;

    private Long rubroPadreId;

    private List<RubroDTO> subRubros;
}
