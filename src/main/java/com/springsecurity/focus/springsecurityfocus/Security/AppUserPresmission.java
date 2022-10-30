package com.springsecurity.focus.springsecurityfocus.Security;

public enum AppUserPresmission {
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write"),
    CONTENT_READ("content:read"),
    CONTENT_WRITE("content:write");
    private final String permission;


    AppUserPresmission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
