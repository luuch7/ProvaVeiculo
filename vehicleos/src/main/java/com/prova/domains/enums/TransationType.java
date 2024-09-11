package com.prova.domains.enums;

public enum TransationType {

    CASH_PAYMENT(0,"ROLE_CASH_PAYMENT"),FINANCING_PAYMENT(1,"ROLE_FINANCING_PAYMENT"),OTHERS(2,"ROLE_OTHERS");

    private int id;
    private String transationType;
    
    private TransationType(int id, String transationType) {
        this.id = id;
        this.transationType = transationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransationType() {
        return transationType;
    }

    public void setTransationType(String transationType) {
        this.transationType = transationType;
    }

    
    public static TransationType toEnum(Integer id){
        if(id==null) return null;
        for(TransationType x : TransationType.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil Invalido");
    }

}
