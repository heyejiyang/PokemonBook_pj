package org.choongang.pokemon.entities.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
//Jackson 라이브러리에서 사용되는 어노테이션입니다.
// 이 어노테이션은 JSON 데이터의 필드 중에 클래스에 정의되지 않은 필드가 있을 때,
// 해당 필드를 무시하도록 설정하는 역할을 합니다.
public class Ability {
    private Item ability;
    private boolean is_hidden;
    private int slot;
}