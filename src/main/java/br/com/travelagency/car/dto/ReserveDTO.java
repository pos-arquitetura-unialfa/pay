  
package br.com.travelagency.car.dto;

import br.com.travelagency.car.enums.ReserveType;
import lombok.Data;

@Data
public class ReserveDTO {

    private Long reserveId;

    private ReserveType reserveType;

}