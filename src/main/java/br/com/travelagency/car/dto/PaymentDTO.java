package br.com.travelagency.car.dto;

import java.util.List;

import lombok.Data;

@Data
public class PaymentDTO {

    private String numeberCreditCar;
    private List<ReserveDTO> reserves;

}