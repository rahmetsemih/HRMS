package com.semih.client;

import org.springframework.stereotype.Service;

@Service
public class EpostaValidate implements EpostaValidateService {


    @Override
    public boolean epostavalidate(String mail) {
        return true;
    }
}
