package com.prova.domains;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.prova.domains.enums.ClientType;

public class Client {
    
    private UUID id;
    private String name;
    private String cpfCnpj;
    private String email;
    private String password;
    private String dateBirth;
    private String phoneNumber;
    private Set<Integer> clientType = new HashSet<>();
    
    public Client(){
        super();
        addClientType(null);
    }

    public Client(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber) {
        this.id = id;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.dateBirth = dateBirth;
        this.phoneNumber = phoneNumber;
        addClientType(null);
    }

    public Set<ClientType> getClientType() {
        return clientType.stream().map(x -> ClientType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addClientType(ClientType clientType) {
        this.clientType.add(clientType.getId());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (cpfCnpj == null) {
            if (other.cpfCnpj != null)
                return false;
        } else if (!cpfCnpj.equals(other.cpfCnpj))
            return false;
        return true;
    }

    

    
}