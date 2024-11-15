package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.util.Objects;

@Embeddable
public class EmployeeTerritoryId implements java.io.Serializable {
    private static final long serialVersionUID = -884394053781790431L;
    @NotNull
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeID;

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "TerritoryID", nullable = false, length = 20)
    private String territoryID;

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(String territoryID) {
        this.territoryID = territoryID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeTerritoryId entity = (EmployeeTerritoryId) o;
        return Objects.equals(this.territoryID, entity.territoryID) &&
                Objects.equals(this.employeeID, entity.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(territoryID, employeeID);
    }

}