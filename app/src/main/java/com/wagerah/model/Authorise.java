package com.wagerah.model;

/**
 * Created by ankurharna on 08/04/18.
 */

public class Authorise {
    /*
    * "access_token": "xxx",
    "token_type": "Bearer",
    "expires_in": 2592000,
    "refresh_token": "xxx",
    "scope": "profile history offline_access"*/

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    private String access_token,token_type,expires_in,refresh_token,scope;
}
