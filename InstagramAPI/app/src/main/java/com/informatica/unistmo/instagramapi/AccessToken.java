package com.informatica.unistmo.instagramapi;

public enum AccessToken {

    ACCESS_TOKEN("IGQVJXQnBPejRDaWExTDBJZAzExSklGVzFnM0N3Um1QWjZAMZAG9NRnY0VkJqa2lzdlNzZA2xvQ2V4SzlBU3E4a2FNNTY5V2F5ZA2JYZAE5LdXhLQmdjTUVOQUgzSWI0V2VHc3NfYVpNMVlUdjZAlOWlBUm9PcAZDZD");
    private String token;
    AccessToken(String token){
            this.token = token;
    }

    public String getToken() {
        return token;
    }
}
