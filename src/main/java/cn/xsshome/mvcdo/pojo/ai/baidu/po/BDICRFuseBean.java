package cn.xsshome.mvcdo.pojo.ai.baidu.po;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;



/**
 * 接口返回的对象 针对于logo、animal、plant、ingredient、car通用
 * @author 福淑
 * @date 2018年5月10日
 * <p>Description: logo、animal、plant、ingredient、car融合对象</p>
 */
public class BDICRFuseBean {
	private long log_id;
	private Integer result_num;
	private List<Result> result;
	private String color_result;
	private LocationResult location_result;
	
	public long getLog_id() {
		return log_id;
	}
	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}
	public Integer getResult_num() {
		return result_num;
	}
	public void setResult_num(Integer result_num) {
		this.result_num = result_num;
	}
	public List<Result> getResult() {
		return result;
	}
	public void setResult(List<Result> result) {
		this.result = result;
	}
	public String getColor_result() {
		return color_result;
	}
	public void setColor_result(String color_result) {
		this.color_result = color_result;
	}
	public LocationResult getLocation_result() {
		return location_result;
	}
	public void setLocation_result(LocationResult location_result) {
		this.location_result = location_result;
	}
	public static class Result{
		private String probability;
		private String name;
		private String score;
		private String year;
		@JSONField(name="type")
		private String logoType;
		private LocationResult location;
		private BaiKeInfo baike_info;
		
		public BaiKeInfo getBaike_info() {
			return baike_info;
		}
		public void setBaike_info(BaiKeInfo baike_info) {
			this.baike_info = baike_info;
		}
		public String getProbability() {
			return probability;
		}
		public void setProbability(String probability) {
			this.probability = probability;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public String getLogoType() {
			return logoType;
		}
		public void setLogoType(String logoType) {
			this.logoType = logoType;
		}
		public LocationResult getLocation() {
			return location;
		}
		public void setLocation(LocationResult location) {
			this.location = location;
		}
		
	}
	public static class LocationResult{
		private Integer width;
		private Integer height;
		private Integer top;
		private Integer left;
		public Integer getWidth() {
			return width;
		}
		public void setWidth(Integer width) {
			this.width = width;
		}
		public Integer getHeight() {
			return height;
		}
		public void setHeight(Integer height) {
			this.height = height;
		}
		public Integer getTop() {
			return top;
		}
		public void setTop(Integer top) {
			this.top = top;
		}
		public Integer getLeft() {
			return left;
		}
		public void setLeft(Integer left) {
			this.left = left;
		}
		
	}
	public static class BaiKeInfo{
		private String baike_url;
		private String image_url;
		private String description;
		public String getBaike_url() {
			return baike_url;
		}
		public void setBaike_url(String baike_url) {
			this.baike_url = baike_url;
		}
		public String getImage_url() {
			return image_url;
		}
		public void setImage_url(String image_url) {
			this.image_url = image_url;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	}
}
