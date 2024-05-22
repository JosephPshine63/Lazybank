package dev.pioruocco.lazybank.model.dto;

public class AuthorityDto {

    private Long id;
    private String name;
    private CustomerDto customer;

    public AuthorityDto(Long id, String name, CustomerDto customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public AuthorityDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
