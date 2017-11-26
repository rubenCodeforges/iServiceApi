package com.codeforges.common.user;


import java.sql.Timestamp;

/**
 * @description https://developers.google.com/identity/protocols/OpenIDConnect#obtainuserinfo
 */
public class GoogleUserIdTokenDto {
    private String iss;
    private String at_hash;
    private boolean email_verified;
    private String sub;
    private String azp;
    private String email;
    private String name;
    private String picture;
    private String aud;
    private Timestamp iat;
    private Timestamp exp;
    private String nonce;
    private String hd;

    public GoogleUserIdTokenDto() {
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getAt_hash() {
        return at_hash;
    }

    public void setAt_hash(String at_hash) {
        this.at_hash = at_hash;
    }

    public boolean isEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(boolean email_verified) {
        this.email_verified = email_verified;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getAzp() {
        return azp;
    }

    public void setAzp(String azp) {
        this.azp = azp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public Timestamp getIat() {
        return iat;
    }

    public void setIat(Timestamp iat) {
        this.iat = iat;
    }

    public Timestamp getExp() {
        return exp;
    }

    public void setExp(Timestamp exp) {
        this.exp = exp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}