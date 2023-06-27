package filippelli.renato.techchallange1adjt.domain.address.dto;

import filippelli.renato.techchallange1adjt.domain.address.entity.Address;

import java.util.UUID;

public class AddressDTO {
    private UUID id;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;

    public AddressDTO(){}

    public AddressDTO(UUID id, String street, Integer number, String district, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public AddressDTO(Address address){
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

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
