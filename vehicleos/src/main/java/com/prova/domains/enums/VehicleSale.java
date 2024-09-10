package com.prova.domains.enums;

public enum VehicleSale {
    
    DONE(0,"ROLE_DONE"), INPROGRESS(1,"ROLE_INPROGRESS"), INSALE(2,"ROLE_INSALE");

    private Integer id;
    private String VehicleSale;
    
    private VehicleSale(Integer id, String vehicleSale) {
        this.id = id;
        VehicleSale = vehicleSale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleSale() {
        return VehicleSale;
    }

    public void setVehicleSale(String vehicleSale) {
        VehicleSale = vehicleSale;
    }

}