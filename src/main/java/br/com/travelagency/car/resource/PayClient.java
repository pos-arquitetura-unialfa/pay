package br.com.travelagency.car.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.travelagency.car.dto.ReserveDTO;

@FeignClient("car")
public interface PayClient {
	
	@RequestMapping("/carReserves")
	public ReserveDTO findByCarReserv(@PathVariable String clientName, String initialDate, br.com.travelagency.car.enums.ServiceStatus serviceStatus);

	

}
