package person.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PersonDao {
    private PersonRepository personRepository;

    // 추가
    public void insertPerson(PersonDto dto) {
        personRepository.save(dto);
    }

    // 전체 출력
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll();
    }

    // 삭제
    public void deletePerson(int num) {
        personRepository.deleteById(num);
    }

    public PersonDto getSelectData(int personNum) {
        return personRepository.getReferenceById(personNum);
    }

    public void updatePerson(PersonDto dto) {
        // dto에 personNum이 포함되어 있어야 수정이 가능하다
        // 없을경우 추가가 됀거다.
        personRepository.save(dto);

    }

}
