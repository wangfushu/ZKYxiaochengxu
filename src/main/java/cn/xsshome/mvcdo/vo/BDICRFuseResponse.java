package cn.xsshome.mvcdo.vo;

public class BDICRFuseResponse extends RestResponse{
	/**
	 * 识别的名称
	 */
	private String icrName;
	/**
	 * 识别的分数
	 */
	private String score;
	/**
	 * 识别的年份
	 */
	private String year;
	/**
	 * 识别的颜色
	 */
	private String colorResult;
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
	public String getIcrName() {
		return icrName;
	}
	public void setIcrName(String icrName) {
		this.icrName = icrName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getColorResult() {
		return colorResult;
	}
	public void setColorResult(String colorResult) {
		this.colorResult = colorResult;
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
