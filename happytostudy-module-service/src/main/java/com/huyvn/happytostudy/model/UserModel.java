package com.huyvn.happytostudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Huy Nghi on 9/17/2015.
 */
@Document(collection = "user")
public class UserModel implements UserDetails{

    @Id
    private String id;

    private String name;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<String>();


    protected UserModel()
    {
		/* Reflection instantiation */
    }


    public UserModel(String name, String passwordHash)
    {
        this.name = name;
        this.password = passwordHash;
    }


    public String getId()
    {
        return this.id;
    }


    public void setId(String id)
    {
        this.id = id;
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public Set<String> getRoles()
    {
        return this.roles;
    }


    public void setRoles(Set<String> roles)
    {
        this.roles = roles;
    }


    public void addRole(String role)
    {
        this.roles.add(role);
    }


    @Override
    public String getPassword()
    {
        return this.password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Set<String> roles = this.getRoles();

        if (roles == null) {
            return Collections.emptyList();
        }

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }


    @Override
    public String getUsername()
    {
        return this.name;
    }


    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }


    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }


    @Override
    public boolean isEnabled()
    {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}