package org.choongang.pokemon.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GachaDetail extends AbstractPokemonDetail{
    private String email;
    private long seq;
    private String nameKr;
    private String frontImage;
    private String InputNickname;
}
