package org.choongang.file.mappers;


import org.apache.ibatis.session.SqlSession;
import org.choongang.file.entities.FileInfo;
import org.choongang.global.config.DBConn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class MapperTest {
    private FileInfoMapper mapper;

    @BeforeEach
    void init(){
        mapper = DBConn.getSession().getMapper(FileInfoMapper.class);
    }

    @DisplayName("파일 등록 테스트")
    @Test
    void registerTest(){
        String gid = UUID.randomUUID().toString();
        String location1 = "loc1";
        String location2 = "loc2";

        for(int i = 0; i < 10; i++){
            FileInfo item = FileInfo.builder()
                    .gid(gid)
                    .location(i % 2 == 0? location1 : location2)
                    .fileName("파일" + i + ".png")
                    .extension(".png")
                    .contentType("image/png")
                    .done(i % 2)
                    .build();
            mapper.register(item);
        }
    }

    @Test
    void getListTest(){
        String gid = "9873a2d8-43e5-44ec-80ea-378b65612c6a";
        List<FileInfo> items = mapper.getListDone(gid, "loc1");
        items.forEach(System.out::println);
    }

    @Test
    void updateDoneTest(){
        String gid = "9873a2d8-43e5-44ec-80ea-378b65612c6a";
        mapper.updateDone(gid);
    }

    @Test
    void deleteTest(){
        mapper.delete(14L);
    }
    @Test
    void deletesTest(){
        String gid = "9873a2d8-43e5-44ec-80ea-378b65612c6a";
        String loc = "loc2";
        mapper.deletes(gid, loc);
    }
}
