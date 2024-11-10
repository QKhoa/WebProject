package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.util.Objects;

@Embeddable
public class CustomerCustomerDemoId implements java.io.Serializable {
    private static final long serialVersionUID = 6043625734713071426L;
    @Size(max = 5)
    @NotNull
    @Nationalized
    @Column(name = "CustomerID", nullable = false, length = 5)
    private String customerID;

    @Size(max = 10)
    @NotNull
    @Nationalized
    @Column(name = "CustomerTypeID", nullable = false, length = 10)
    private String customerTypeID;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CustomerCustomerDemoId entity = (CustomerCustomerDemoId) o;
        return Objects.equals(this.customerTypeID, entity.customerTypeID) &&
                Objects.equals(this.customerID, entity.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerTypeID, customerID);
    }

}