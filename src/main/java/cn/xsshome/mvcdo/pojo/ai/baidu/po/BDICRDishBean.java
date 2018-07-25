package cn.xsshome.mvcdo.pojo.ai.baidu.po;

import java.util.List;
/**
 *
 * @author 小帅丶
 * @date 2018年7月25日
 * <p>Description: 菜品识别Bean 增加百科内容</p>
 */
public class BDICRDishBean {
	private long log_id;
	private Integer result_num;
	private List<Result> result;
	
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

	public static class Result{
		private String probability;
		private boolean has_calorie;
		private String calorie;
		private String name;
		private BaiKeInfo baike_info;
		public String getProbability() {
			return probability;
		}
		public void setProbability(String probability) {
			this.probability = probability;
		}
		public boolean isHas_calorie() {
			return has_calorie;
		}
		public void setHas_calorie(boolean has_calorie) {
			this.has_calorie = has_calorie;
		}
		public String getCalorie() {
			return calorie;
		}
		public void setCalorie(String calorie) {
			this.calorie = calorie;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public BaiKeInfo getBaike_info() {
			return baike_info;
		}
		public void setBaike_info(BaiKeInfo baike_info) {
			this.baike_info = baike_info;
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
