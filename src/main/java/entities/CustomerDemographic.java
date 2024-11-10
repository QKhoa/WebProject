package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "CustomerDemographics")
public class CustomerDemographic {
    @Id
    @Size(max = 10)
    @Nationalized
    @Column(name = "CustomerTypeID", nullable = false, length = 10)
    private String customerTypeID;

    @Nationalized
    @Lob
    @Column(name = "CustomerDesc")
    private String customerDesc;

    public String getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

}