package cn.xsshome.mvcdo.pojo.ai.fpp.dbo;
/**
 * @author 小帅丶
 * @date 2018年10月9日
 * <p>Description: 人脸肤质分析数据库表对象</p>
 */
public class FPPFaceDO {
	/**
	 * 主键id
	 */
	private int fppId;
	/**
	 * 接口返回的标识
	 */
	private String faceToken;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 健康分数
	 */
	private String skinHealth;
	/**
	 * 色斑分数
	 */
	private String skinStain;
	/**
	 * 青春痘分数
	 */
	private String skinAcne;
	/**
	 * 黑眼圈
	 */
	private String skinDarkCircle;
	/**
	 * 检测时间
	 */
	private String detectDate;
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
	 * 接口类型
	 */
	private String apiType;
	public int getFppId() {
		return fppId;
	}
	public void setFppId(int fppId) {
		this.fppId = fppId;
	}
	public String getFaceToken() {
		return faceToken;
	}
	public void setFaceToken(String faceToken) {
		this.faceToken = faceToken;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSkinHealth() {
		return skinHealth;
	}
	public void setSkinHealth(String skinHealth) {
		this.skinHealth = skinHealth;
	}
	public String getSkinStain() {
		return skinStain;
	}
	public void setSkinStain(String skinStain) {
		this.skinStain = skinStain;
	}
	public String getSkinAcne() {
		return skinAcne;
	}
	public void setSkinAcne(String skinAcne) {
		this.skinAcne = skinAcne;
	}
	public String getSkinDarkCircle() {
		return skinDarkCircle;
	}
	public void setSkinDarkCircle(String skinDarkCircle) {
		this.skinDarkCircle = skinDarkCircle;
	}
	public String getDetectDate() {
		return detectDate;
	}
	public void setDetectDate(String detectDate) {
		this.detectDate = detectDate;
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
	public String getApiType() {
		return apiType;
	}
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	
}
