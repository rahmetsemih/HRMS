package com.semih.client;

import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService {
    @Override
    public boolean validate(String tcNo) {
        return tcNo.length() != 11;
    }


}
