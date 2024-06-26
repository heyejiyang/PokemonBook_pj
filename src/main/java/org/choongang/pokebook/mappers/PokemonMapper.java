package org.choongang.pokebook.mappers;

import org.choongang.pokebook.entities.PokemonDetail;

public interface PokemonMapper {
    int register(PokemonDetail params);
    PokemonDetail get(long seq);
}