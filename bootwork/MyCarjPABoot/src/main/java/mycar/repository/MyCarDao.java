package mycar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarDto;

@Repository
@AllArgsConstructor
public class MyCarDao {

    // JpaRepository 를 상속받을경우 기본적인 SQL을 실행해주는 각종 메서드 호출 가능
    MyCarDaoInter daoInter;

    // 전체갯수 구하기
    public Long getTotalCount() {
        return daoInter.count();

    }

    // db 저장
    public void insertMyCar(MyCarDto dto) {
        daoInter.save(dto); // save는 dto에 num 값이 포함되어 있으므로 update, 없으면 insert를 실행한다
    }

    // 전체출력
    public List<MyCarDto> getAllCars() {
        return daoInter.findAll(); // 전체 데이터 반환
        // Sort 오름차순 문법(JPA)
//        return daoInter.findAll(Sort.by(Sort.Direction.DESC,"carprice")); // 가격이 비싼거부터 출력
//        return daoInter.findAll(Sort.by(Sort.Direction.ASC,"carprice")); // 가격이 싼거부터 출력
    }

    // 페이지 출력
    public Page<MyCarDto> getAllCars(Pageable pageable) {

        return daoInter.findAll(pageable); // 전체 데이터 반환
    }

    // num에 해당하는 dto 반환
    public MyCarDto getData(Long num) {

//        return daoInter.getById(num); // deprecate
        return daoInter.getReferenceById(num);
    }

    // delete
    public void deleteMyCar(Long num) {
        daoInter.deleteById(num);
    }

    // update
    public void updateMyCar(MyCarDto dto) {
        daoInter.save(dto); // dto에 num이 포함되어 있으므로 수정된다.
    }

    // 자동차명, 가격, 색상만 수정(사진 수정 안하는 메서드)
    public void updateMycarNoPhoto(MyCarDto dto) {

//        Long num = dto.getNum();
//        String carname = dto.getCarname();
//        String carcolor = dto.getCarcolor();
//        int carprice = dto.getCarprice();
//
//        daoInter.updateMycarNoPhoto(num, carname, carprice, carcolor);

        // DTO로 직접 파라미터를 넘긴경우로 테스트하기
        // 사진을 제외한 나머지 컬럼을 모두 수정하기
        daoInter.updateMyCarDTONoPhoto(dto);
    }



}
