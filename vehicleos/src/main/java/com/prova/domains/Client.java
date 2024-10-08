package com.prova.domains;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.prova.domains.dtos.ClientDTO;
import com.prova.domains.enums.ClientType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @Column(unique = true)
    protected String name;

    @Column(unique = true)
    protected String cpfCnpj;
    protected String email;
    protected String password;
    protected String dateBirth;
    protected String phoneNumber;

    //se der erro é aqui
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "client_types")
    protected Set<Integer> clientType = new HashSet<>();

    
    //private Address address;
    
    public Client(){
        super();
        addClientType(ClientType.NATURAL_PERSON);
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
        addClientType(ClientType.NATURAL_PERSON);
    }

    public Client(ClientDTO obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpfCnpj = obj.getCpfCnpj();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.dateBirth = obj.getDateBirth();
        this.phoneNumber = obj.getPhoneNumber();
    }

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    //get e set do enum igual a apostila
    public Set<ClientType> getClientType() {
        return clientType.stream().map(x -> ClientType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addClientType(ClientType clientType) {
        this.clientType.add(clientType.getId());
    }

    public void setClientType(Set<Integer> clientType){
        this.clientType = clientType;
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