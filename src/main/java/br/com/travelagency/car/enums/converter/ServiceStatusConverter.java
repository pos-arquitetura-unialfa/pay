package br.com.travelagency.car.enums.converter;

import br.com.travelagency.car.enums.ServiceStatus;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class ServiceStatusConverter implements AttributeConverter<ServiceStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ServiceStatus serviceStatus) {
        return serviceStatus.getCode();
    }

    @Override
    public ServiceStatus convertToEntityAttribute(Integer code) {
        return ServiceStatus.getByCode(code);
    }
}
