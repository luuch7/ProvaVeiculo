package com.prova.domains.enums;

public enum ClientType {

    NATURAL_PERSON(0, "ROLE_NATURAL_PERSON"), LEGAL_ENTITY(1, "ROLE_LEGAL_ENTITY");

    private Integer id;
    private String clientType;
    
    private ClientType(Integer id, String clientType) {
        this.id = id;
        this.clientType = clientType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
    
    public static ClientType toEnum(Integer id){
        if(id==null) return null;
        for(ClientType x : ClientType.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil Invalido");
    }
}