package cn.xsshome.mvcdo.vo;

public class BDDishResponse extends RestResponse{
	/**
	 * 卡路里，每100g的卡路里含量
	 */
	private String calorie;
	/**
	 * 是否包含卡路里
	 */
	private String hasCalorie;
	/**
	 * 菜名
	 */
	private String dishName;
	/**
	 * 置信度值，0-1
	 */
	private String probability;
	/**
	 * 百度百科url
	 */
	private String baikeUrl;
	/**
	 * 百科图片链接
	 */
	private String imageUrl;
	/**
	 * 百科内容描述
	 */
	private String description;
	public String getCalorie() {
		return calorie;
	}
	public void setCalorie(String calorie) {
		this.calorie = calorie;
	}
	public String getHasCalorie() {
		return hasCalorie;
	}
	public void setHasCalorie(String hasCalorie) {
		this.hasCalorie = hasCalorie;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getProbability() {
		return probability;
	}
	public void setProbability(String probability) {
		this.probability = probability;
	}
	public String getBaikeUrl() {
		return baikeUrl;
	}
	public void setBaikeUrl(String baikeUrl) {
		this.baikeUrl = baikeUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
