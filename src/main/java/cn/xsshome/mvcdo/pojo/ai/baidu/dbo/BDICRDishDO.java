package cn.xsshome.mvcdo.pojo.ai.baidu.dbo;
/**
 * 
 * @author 福淑
 * @date 2018年5月9日
 * <p>Description: 图像识别菜品识别表对象</p>
 */
public class BDICRDishDO {
	/**
	 * 主键id
	 */
	private Long icrId;
	/**
	 * 日志id
	 */
	private String logId;
	/**
	 * 返回结果数目
	 */
	private Integer resultNum;
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
	 * 图片路径
	 */
	private String imagePath;
	/**
	 * 微信用户openid
	 */
	private String openId;
	/**
	 * 微信用户昵称
	 */
	private String nikeName;
	/**
	 * 入口类型 web wcs
	 */
	private String enterType;
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
	public Long getIcrId() {
		return icrId;
	}
	public void setIcrId(Long icrId) {
		this.icrId = icrId;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public Integer getResultNum() {
		return resultNum;
	}
	public void setResultNum(Integer resultNum) {
		this.resultNum = resultNum;
	}
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	public String getEnterType() {
		return enterType;
	}
	public void setEnterType(String enterType) {
		this.enterType = enterType;
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
