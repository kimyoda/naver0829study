package data;

public class ShopDto {
	private String sangpum;
	private String photo;
	private String color;
	private int price;
	
	public ShopDto() {
		super();
	}

	public ShopDto(String sangpum, String photo, String color, int price) {
		super();
		this.sangpum = sangpum;
		this.photo = photo;
		this.color = color;
		this.price = price;
	}

	public String getSangpum() {
		return sangpum;
	}

	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
