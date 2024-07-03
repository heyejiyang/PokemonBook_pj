package org.choongang.pokemon.services;

import lombok.Data;

public class RequestProfile123 {

    @Data
    public class RequestProfile
    {
        private String userName;
        private String password;
        private String confirmPassword;
        private long myPokemonSeq;
    }
}
