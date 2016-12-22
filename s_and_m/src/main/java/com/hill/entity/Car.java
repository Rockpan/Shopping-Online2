package com.hill.entity;

/**
 * 购物车实体类
 * 
 * @author 潘希城
 *
 */
public class Car {

	private int id;// 购物车id
	private String name;// 商品名称
	private String description;// 商品描述
	private int price;// 商品价格
	private int count;// 购买数量
	private String store_name;// 店铺名称
	private int user_id;//用户id
	private int product_id;//商品id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
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
		return "Car [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", count="
				+ count + ", store_name=" + store_name + ", user_id=" + user_id + ", product_id=" + product_id + "]";
	}


}
