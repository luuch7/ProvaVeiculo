package com.prova.services;

import com.prova.domains.Client;
import com.prova.domains.NaturalPerson;
import com.prova.repositories.ClientRepository;
import com.prova.repositories.NaturalPersonRepository;
import com.prova.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //private final NaturalPersonRepository naturalPersonRepository;
    private final ClientRepository clientRepository;

    /*public UserDetailsServiceImpl(NaturalPersonRepository naturalPersonRepository) {
        this.naturalPersonRepository = naturalPersonRepository;
    }*/

    public UserDetailsServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> naturalPerson = clientRepository.findByEmail(username);
        if(naturalPerson.isEmpty()){
            throw new UsernameNotFoundException("User not found: "+username);
        }
        return new UserSS(naturalPerson.orElse(null));
    }
}
