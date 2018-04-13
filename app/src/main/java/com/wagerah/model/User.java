package com.wagerah.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ankurharna on 06/04/18.
 */
/*
{
  "picture": "https://d1w2poirtb3as9.cloudfront.net/f3be498cb0bbf570aa3d.jpeg",
  "first_name": "Uber",
  "last_name": "Developer",
  "uuid": "f4a416e3-6016-4623-8ec9-d5ee105a6e27",
  "rider_id": "8OlTlUG1TyeAQf1JiBZZdkKxuSSOUwu2IkO0Hf9d2HV52Pm25A0NvsbmbnZr85tLVi-s8CckpBK8Eq0Nke4X-no3AcSHfeVh6J5O6LiQt5LsBZDSi4qyVUdSLeYDnTtirw==",
  "email": "uberdevelopers@gmail.com",
  "mobile_verified": true,
  "promo_code": "uberd340ue"
}
 */
public class User {

    @Nullable
    @SerializedName("picture")
    private String photo;

    @Nullable
    @SerializedName("first_name")
    private String firstName ;

    @Nullable
    @SerializedName("last_name")
    private String lastName;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("rider_id")
    private String riderId;

    @Nullable
    private String email;

    @Nullable
    @SerializedName("mobile_verified")
    private Boolean isMobileVerified;

    @Nullable
    @SerializedName("promo_code")
    private String promoCode;


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Boolean getMobileVerified() {
        return isMobileVerified;
    }

    public void setMobileVerified(Boolean mobileVerified) {
        isMobileVerified = mobileVerified;
    }

    public User(){

    }

    @Override
    public String toString() {
        String finalString =  firstName + " " +
                lastName + " " +
                email + " " +
                isMobileVerified;

        return finalString ;
    }
}
