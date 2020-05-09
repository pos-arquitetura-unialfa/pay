package br.com.travelagency.car.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum ServiceStatus {

    REQUEST(1, "Request"),
    PENDING_PAYMENT(2, "Pending Payment"),
    CONFIRM(3, "Confirm"),
    CANCEL(4, "Cancel");

    private Integer code;

    private String description;


    ServiceStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ServiceStatus getByCode(Integer code) {
        return Stream.of(ServiceStatus.values())
                .filter(ss -> ss.code == code)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
