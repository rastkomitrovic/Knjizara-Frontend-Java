package com.fon.knjizarafrontend.service;

public interface EmailService {

    void sendMail(String to,String subject,String text);
}
