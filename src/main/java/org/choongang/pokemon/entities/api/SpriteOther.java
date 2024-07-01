package org.choongang.pokemon.entities.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpriteOther {
    private SpriteImage dream_world;
    private SpriteImage home;
    private SpriteImage showdown;

    //일반적으로 JSON 데이터는 다양한 소스에서 제공되며, 각 소스마다 필드 이름이 다를 수 있습니다.
    // 예를 들어, 한 API에서는 official-artwork라는 필드 이름을 사용하고,
    // 다른 API에서는 officialArtwork라는 이름을 사용할 수 있습니다.
    // 이런 경우, Java 객체의 필드 이름을 하나로 통일하기 어렵기 때문에
    // @JsonAlias를 사용하여 여러 이름을 하나의 Java 필드로 매핑할 수 있습니다.
    @JsonAlias("official-artwork")
    private SpriteImage official_artwork;
}