package com.springsecurity.focus.springsecurityfocus.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.springsecurity.focus.springsecurityfocus.Security.AppUserPresmission.*;

public enum AppUserRole {
    EMPLOYEE(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(EMPLOYEE_WRITE,EMPLOYEE_READ,CONTENT_WRITE,CONTENT_READ)),
    ADMINTRAINEE(Sets.newHashSet(EMPLOYEE_READ,CONTENT_READ));
    private final Set<AppUserPresmission> permissions;

    AppUserRole(Set<AppUserPresmission> permissions) {
        this.permissions = permissions;
    }
    public Set<AppUserPresmission> getPermissions(){
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
       Set<SimpleGrantedAuthority> persmissions= getPermissions().stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        persmissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
       return persmissions;
    }

}
