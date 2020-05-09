package br.com.travelagency.car.client;

import br.com.travelagency.car.dto.CarReserveDTO;
import br.com.travelagency.car.enums.ServiceStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient("car")
public interface CarServiceClient {

    @RequestMapping("/carReserves")
    List<CarReserveDTO> findReserves(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String initialDate, @RequestParam(required = false) ServiceStatus serviceStatus);

}