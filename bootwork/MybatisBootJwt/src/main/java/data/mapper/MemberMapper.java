package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import data.dto.MemberDto;

@Mapper
public interface MemberMapper {

    @Select("select count(*) from memberdb")
    public int getTotalCount();

    @Select("select * from memberdb order by num desc")
    public List<MemberDto> getAllMembers();

//
    @Insert("insert into memberdb (name,myid,pass,photo,hp,addr,gaipday)\n" +
            "        values (#{name},#{myid},#{pass},#{photo},#{hp},#{addr},now())")
    //@Insert 로 쿼리문을 여기서 직접써도 되지만 xml 에서 해보자
    public void insertMember(MemberDto dto);

    // 해당 아이디가 있는 지 확인, count 이용
    @Select("select count(*) from memberdb where myid=#{myid}")
    public int getIdCheck(String myid);

    @Delete("delete from memberdb where num=#{num}")
    public void deleteMember(int num);

    @Select("select * from memberdb where num=#{num}")
    public MemberDto getMember(int num);

    @Select("select * from  memberdb where myid=#{myid}")
    public MemberDto getLogin(String myid);


}
