package data.mapper;


import data.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {

    public int getTotalCount(String search);

    public List<BoardDto> getAllDatas(HashMap<String, Object> map);

    public void insertBoard(BoardDto dto);

}