package com.springsecurity.focus.springsecurityfocus.Security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.springsecurity.focus.springsecurityfocus.Security.AppUserPresmission.*;

public enum AppUserRole {
    EMPLOYEE(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(EMPLOYEE_WRITE,EMPLOYEE_READ,CONTENT_WRITE,CONTENT_READ)),
    ADMINTRAINEE(Sets.newHashSet(EMPLOYEE_READ,CONTENT_READ));
    private final Set<AppUserPresmission> permissions;

    AppUserRole(Set<AppUserPresmission> permissions) {
        this.permissions = permissions;
    }
}
