package org.choongang.pokemon.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;
import org.choongang.pokemon.entities.GachaDetail;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.entities.api.Pokemon;
import org.choongang.pokemon.mappers.PokemonMapper;

@Service
@RequiredArgsConstructor
public class PokemonGachaService {
    private final PokemonMapper mapper;

//    public boolean save(Pokemon data, Member member) {
//        GachaDetail detail = GachaDetail.builder()
//                .email(member.getEmail())
//                .seq(data.getId())
//                .frontImage(data.getSprites().getOther().getOfficial_artwork().getFront_default())
//                .nameKr(data.getNameKr())
//                .build();
//        int result = mapper.register(detail);
//        return result > 0;
//    }
}

