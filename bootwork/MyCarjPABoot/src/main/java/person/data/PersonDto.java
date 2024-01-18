package person.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PersonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personNum;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String photo;

    @Column(length = 5)
    private String blood;

    private int age;

    @CreationTimestamp
    @Column(updatable = false) // 수정 시 컬럼 제외
    @JsonFormat(pattern =  "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeday;

}
