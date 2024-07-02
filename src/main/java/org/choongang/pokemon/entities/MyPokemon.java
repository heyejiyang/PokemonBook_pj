package org.choongang.pokemon.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyPokemon {
    private long seq;
    private String frontImage;
    private String nameKr;
    private String nickName;
}
