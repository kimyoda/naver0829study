package mycar.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
/*
*  은행 서비스에서 사용자(TABLE_USER)가 1개 이상의 계좌(TABLE_ACCOUNT)를
*  가질 수 있다고 가저알경우 TABLE_USER 입장에서 보면 OneToMany 이고,
*  TABLE_ACCOUNT 입장에서 보면 ManyToOne이다.
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mycar_comment")
public class MyCarCommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne // 서브테이블에는 ManyToOne : 하나의 등록글에 여러개의 댓글을 달 수 있다
    @JoinColumn(name = "num")
    private MyCarDto mycar; // join table 선언

    private String comment; // 기본 컬럼명은 comment, length 는 255가 된다(생략 시)

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/seoul")
    @Column(updatable = false)  // 수정 시 수정컬럼에서 제외
    @CreationTimestamp // 엔터티가 생성되는 시점의 시간이 자동등록
    private Timestamp writeday;

}
