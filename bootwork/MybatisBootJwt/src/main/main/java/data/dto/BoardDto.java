package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("BoardDto")
public class BoardDto {
    private int num;
    private int readcount;
    private String writer;
    private String myid;
    private String subject;
    private String content;
    private String photo;
    private String token;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeday;
}
