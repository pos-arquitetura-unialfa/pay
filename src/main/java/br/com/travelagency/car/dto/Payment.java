package br.com.travelagency.car.dto;

import br.com.travelagency.car.enums.ReserveType;
import lombok.Data;

@Data
public class Payment {

    private Long reserveId;

    private ReserveType reserveType;

}
