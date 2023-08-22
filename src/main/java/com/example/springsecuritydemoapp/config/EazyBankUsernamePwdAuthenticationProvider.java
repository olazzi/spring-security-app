package com.example.springsecuritydemoapp.config;

import com.example.springsecuritydemoapp.modal.Customer;
import com.example.springsecuritydemoapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class EazyBankUsernamePwdAuthenticationProvider  implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username  = authentication.getName();
        String pwd  = authentication.getCredentials().toString();
        List<Customer> customer = customerRepository.findByEmail(username);
        if(customer.size() > 0){
            if(passwordEncoder.matches(pwd, customer.get(0).getPwd())){
               List<GrantedAuthority> authorities = new ArrayList<>();
               authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
               return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            }else{
                throw new RuntimeException("Invalid password");
            }
        }
        else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
