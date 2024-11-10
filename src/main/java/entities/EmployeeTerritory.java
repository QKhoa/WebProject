package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EmployeeTerritories")
public class EmployeeTerritory {
    @EmbeddedId
    private EmployeeTerritoryId id;

    @MapsId("employeeID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EmployeeID", nullable = false)
    private entities.Employee employeeID;

    @MapsId("territoryID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TerritoryID", nullable = false)
    private entities.Territory territoryID;

    public EmployeeTerritoryId getId() {
        return id;
    }

    public void setId(EmployeeTerritoryId id) {
        this.id = id;
    }

    public entities.Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(entities.Employee employeeID) {
        this.employeeID = employeeID;
    }

    public entities.Territory getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(entities.Territory territoryID) {
        this.territoryID = territoryID;
    }

}