package filippelli.renato.techchallange1adjt.domain.address.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;
@Entity
@Table(name="address")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;

    public Address(){
    }
    public Address(String street, Integer number, String district, String city, String state) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String rua) {
        this.street = rua;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer numero) {
        this.number = numero;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String bairro) {
        this.district = bairro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String cidade) {
        this.city = cidade;
    }

    public String getState() {
        return state;
    }

    public void setState(String estado) {
        this.state = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", rua='" + street + '\'' +
                ", numero=" + number +
                ", bairro='" + district + '\'' +
                ", cidade='" + city + '\'' +
                ", estado='" + state + '\'' +
                '}';
    }
}
