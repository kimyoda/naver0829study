package myshop.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("MyShopDto")
public class MyShopDto {
    private int num;
    private String sangpum;
    private String photo;
    private int price;
    private String color;
    private Timestamp writeday;
}
