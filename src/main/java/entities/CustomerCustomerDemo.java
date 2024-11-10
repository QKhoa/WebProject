package entities;

import jakarta.persistence.*;

@Entity
public class CustomerCustomerDemo {
    @EmbeddedId
    private CustomerCustomerDemoId id;

    @MapsId("customerID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private entities.Customer customerID;

    @MapsId("customerTypeID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerTypeID", nullable = false)
    private entities.CustomerDemographic customerTypeID;

    public CustomerCustomerDemoId getId() {
        return id;
    }

    public void setId(CustomerCustomerDemoId id) {
        this.id = id;
    }

    public entities.Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(entities.Customer customerID) {
        this.customerID = customerID;
    }

    public entities.CustomerDemographic getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(entities.CustomerDemographic customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

}