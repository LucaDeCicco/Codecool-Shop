package com.codecool.shop.model;

import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;

public class Client {
 private String name;
 private String email;
 private String phoneNumber;
 private String country;
 private String city;
 private String zipCode;
 private String Address;


 private static Client instance = null;
 public Client() {
 }

 public static Client getInstance() {
  if (instance == null) {
   instance = new Client();
  }
  return instance;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPhoneNumber() {
  return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
  this.phoneNumber = phoneNumber;
 }

 public String getCountry() {
  return country;
 }

 public void setCountry(String country) {
  this.country = country;
 }

 public String getCity() {
  return city;
 }

 public void setCity(String city) {
  this.city = city;
 }

 public String getZipCode() {
  return zipCode;
 }

 public void setZipCode(String zipCode) {
  this.zipCode = zipCode;
 }

 public String getAddress() {
  return Address;
 }

 public void setAddress(String address) {
  Address = address;
 }
}
