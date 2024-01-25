package data.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import data.dto.BoardDto;

@Mapper
public interface BoardMapper {

    @Select("SELECT COUNT(*) FROM simpleboard WHERE subject LIKE CONCAT('%', #{search}, '%')")
    public int getTotalCount(String search);

    @Select("SELECT * FROM simpleboard WHERE subject LIKE CONCAT('%',#{search},'%') ORDER BY num DESC LIMIT #{start},#{perpage}")
    public List<BoardDto> getAllDatas(HashMap<String, Object> map);

    @Insert("INSERT INTO simpleboard (writer, myid, subject, content, photo, readcount, writeday) " +
            "VALUES (#{writer}, #{myid}, #{subject}, #{content}, #{photo}, 0, NOW())")
    public void insertBoard(BoardDto dto);

    @Select("select * from simpleboard where num=#{num}")
    public BoardDto getSelectPage(int num);

    @Update("update simpleboard set readcount=readcount+1 where num=#{num}")
    public void updateReadcount(int num);

}