package hellojpa;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Address address;

    public AddressEntity(String old1, String street, String zipcode) {
        this.address = new Address(old1, street, zipcode);
    }

    public AddressEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
