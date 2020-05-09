package br.com.travelagency.car.dto;

import br.com.travelagency.car.enums.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CarReserveDTO {
	
	private Long id;
    private String carModel;
    private BigDecimal dailyPrice;
    private String endDate;

    private String clientName;
    private String initialDate;
    private ServiceStatus serviceStatus;
    
}
