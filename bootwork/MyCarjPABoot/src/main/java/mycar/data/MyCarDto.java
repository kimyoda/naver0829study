package mycar.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "mycar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCarDto {

    @Id // 각 인티티를 구별할 수 있도록 식별 아이디를 갖도록 설계
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(name = "carname", length = 30) // 컬럼명은 변수와 같을경우 생략가능
    private String carname;

    private int carprice;

    @Column(length = 20)
    private String carcolor;

    @Column(length = 30) // length 생략 시 255
    private String carguip;

    @Column(length = 100)
    private String carphoto;

    @Column(updatable = false) // 수정 시 컬럼 제외
    @CreationTimestamp
    private Timestamp writeday;

    // @Transient: 테이블의 컬럼으로는 생성되지 않고 객체에서만 사용가능한 멤버변수
    @Transient
    private int commentcount;

    @Transient
    private String message;
}
