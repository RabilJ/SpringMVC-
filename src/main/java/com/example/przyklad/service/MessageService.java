package com.example.przyklad.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String printMessage(){
        return "Cześć, tu Kuba. Wszystko działa!";
    }
}
