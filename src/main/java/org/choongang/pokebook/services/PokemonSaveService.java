package org.choongang.pokebook.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.pokebook.entities.PokemonDetail;
import org.choongang.pokebook.entities.api.Pokemon;
import org.choongang.pokebook.mappers.PokemonMapper;

@Service
@RequiredArgsConstructor
public class PokemonSaveService {
    private final PokemonMapper mapper;

    public boolean save(Pokemon data) {

        PokemonDetail detail = PokemonDetail.builder()
                .seq(data.getId())
                .name(data.getName())
                .height(data.getHeight())
                .weight(data.getWeight())
                .baseExperience(data.getBase_experience())
                .frontImage(data.getSprites().getFront_default())
                .backImage(data.getSprites().getBack_default())
                .rawData(data.getRawData())
                .build();
        int result = mapper.register(detail);
        return result > 0;
    }
}