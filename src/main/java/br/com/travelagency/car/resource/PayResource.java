package br.com.travelagency.car.resource;

import br.com.travelagency.car.client.CarServiceClient;
import br.com.travelagency.car.dto.CarReserveDTO;
import br.com.travelagency.car.enums.ReserveType;
import br.com.travelagency.car.enums.ServiceStatus;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.travelagency.car.ConfigProducer;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CancellationException;

@RestController
@RequestMapping(path = "/carReserves")
public class PayResource {
	
	@Autowired
	private ConfigProducer orderSender;

	@Autowired
	private CarServiceClient carServiceClient;


    @PostMapping
        public void makePayment(@RequestBody CarReserveDTO carDTO) {

            if (carDTO.getServiceStatus().equals(ServiceStatus.REQUEST)) {

			List<CarReserveDTO> json = this.carServiceClient.findReserves(carDTO.getClientName(),  carDTO.getInitialDate(), carDTO.getServiceStatus());

			
			String jsonFormatado = new Gson().toJson(json);
			
			System.out.println(jsonFormatado);
			
			orderSender.sendQueue(jsonFormatado);


    	}

    	//else if (carDTO.getReserves().get(1).getReserveId() == 1) {

    		//Realizar get no hotel

    		//orderSender.sendQueue(model);


    	//}else {

    		//Realizar get no voo



    		//orderSender.sendQueue(model);

    	}
    	
    	
    	
    }

