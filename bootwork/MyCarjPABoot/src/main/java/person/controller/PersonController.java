    package person.controller;

    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.*;
    import person.data.PersonDao;
    import person.data.PersonDto;

    import java.util.List;

    @RestController
    @RequiredArgsConstructor
    public class PersonController {
        private final PersonDao personDao;

        // 추가
        @PostMapping("/person/add")
        public void insert(@RequestBody PersonDto dto) {
            System.out.println("add>>" + dto);

            // db insert
            personDao.insertPerson(dto);
        }

        // 출력
        @GetMapping("/person/list")
        public List<PersonDto> list() {
            System.out.println("list>>");
            return personDao.getAllPersons();
        }

        // 삭제
        @DeleteMapping("/person/delete")
        public void delete(@RequestParam int num) {
            System.out.println("delete>>" + num);
            personDao.deletePerson(num);
        }
    }
