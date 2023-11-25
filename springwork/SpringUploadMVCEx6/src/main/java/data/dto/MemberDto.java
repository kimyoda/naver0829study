package data.dto;

import lombok.Data;

@Data // set, get, Tostring (전부 다 포함)
public class MemberDto {
	private String name;
	private String hp;
	private String addr;
	private String photo;
	private String photo2;
}
