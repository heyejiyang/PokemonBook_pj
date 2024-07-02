package org.choongang.pokemon.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonDetail extends AbstractPokemonDetail {
    private long seq;
    private long num;
    private String name;
    private int weight;
    private double height;
    private int baseExperience;
    private String frontImage;
    private String backImage;
    private String pixelFrontImage;
    private String pixelBackImage;
    private String rawData;
    private String nameKr;
    private String description;
    private String type1;
    private String type2;
    //타입, 분류 가져오기
}