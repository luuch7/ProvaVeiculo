package com.prova.domains.enums;

public enum VehicleSale {
    
    DONE(0,"ROLE_DONE"), INPROGRESS(1,"ROLE_INPROGRESS"), INSALE(2,"ROLE_INSALE");

    private Integer id;
    private String vehicleSale;
    

    private VehicleSale(Integer id, String vehicleSale) {
        this.id = id;
        this.vehicleSale = vehicleSale;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getVehicleSale() {
        return vehicleSale;
    }


    public void setVehicleSale(String vehicleSale) {
        this.vehicleSale = vehicleSale;
    }


    public static VehicleSale toEnum(Integer id){
        if(id==null) return null;
        for(VehicleSale x : VehicleSale.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil Invalido");
    }
}