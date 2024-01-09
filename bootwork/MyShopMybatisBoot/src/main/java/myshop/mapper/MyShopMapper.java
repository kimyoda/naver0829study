package myshop.mapper;

import myshop.data.MyShopDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyShopMapper {

    public int getTotalCount();

    // 직접 insert 쿼리문 설정하기
    @Insert("""
			insert into myshop (sangpum,color,photo,price,writeday)
			values (#{sangpum},#{color},#{photo},#{price},now())
			""")
    public void insertShop(MyShopDto dto);

    // 전체 목록 출력( 직접 sql문으로 설정하기)
    @Select("select * from myshop order by num desc")
    public List<MyShopDto> getSangpumList();

    // xml로 설정해보자
    public MyShopDto getData(int num);

    // delete는 직접 sql문으로 설정해서 삭제
    @Delete("delete from myshop where num=#{num}")
    public void deleteShop(int num);

    }
