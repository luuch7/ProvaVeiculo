package com.prova.domains.enums;

public enum VehicleType {

    CAR(0,"ROLE_CAR"),MOTOCICLE(1,"ROLE_MOTOCICLE"),TRUCK(2,"ROLE_TRUCK");
    
    private Integer id;
    private String vehicleType;

    private VehicleType(Integer id, String vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public static VehicleType toEnum(Integer id){
        if(id==null) return null;
        for(VehicleType x : VehicleType.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil Invalido");
    }
    
}
