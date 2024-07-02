package org.choongang.global;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListData<T> {
    private List<T> items;
    private Pagination pagination;
    //목록 데이터와 페이징 데이터
}