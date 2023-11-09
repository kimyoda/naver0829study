package study.day1109.mvc3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BrunchFoodDto {
	private String name;
	private String photo;
	private String addr;
}
