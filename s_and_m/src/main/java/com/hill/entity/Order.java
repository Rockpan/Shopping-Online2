package com.hill.entity;

public class Order {

	private int id;// ����id
	private String card;// ������
	private int status;// ����״̬
	private String product_name;// ��Ʒ����
	private String category;// ��Ʒ����
	private int count;// ��Ʒ����
	private int price;// ��Ʒ�۸�
	private String user_name;// �û�����
	private int user_id;// �û�id
	private int product_id;// ��Ʒid

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", card=" + card + ", status=" + status + ", product_name=" + product_name
				+ ", category=" + category + ", count=" + count + ", price=" + price + ", user_name=" + user_name
				+ ", user_id=" + user_id + ", product_id=" + product_id + "]";
	}
}
