package filippelli.renato.techchallenge1adjt.domain.dto;

import filippelli.renato.techchallenge1adjt.domain.entity.Address;

import java.util.UUID;

public class AddressResponse {
    private UUID id;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;

    public AddressResponse(Address address){
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.district = address.getDistrict();
        this.city = address.getCity();
        this.state = address.getState();
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
