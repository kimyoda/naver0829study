package review_board;

import java.sql.Timestamp;

public class ReviewBoardDto {
	private int id;
	private String writer_id;
	private String title;
	private String content;
	private int view_cnt;
	private String delete_yn;
	private Timestamp create_dt;
	private Timestamp modify_dt;
	private Timestamp delete_dt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public Timestamp getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Timestamp create_dt) {
		this.create_dt = create_dt;
	}
	public Timestamp getModify_dt() {
		return modify_dt;
	}
	public void setModify_dt(Timestamp modify_dt) {
		this.modify_dt = modify_dt;
	}
	public Timestamp getDelete_dt() {
		return delete_dt;
	}
	public void setDelete_dt(Timestamp delete_dt) {
		this.delete_dt = delete_dt;
	}

}
