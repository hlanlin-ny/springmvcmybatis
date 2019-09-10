package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;


/**
 * 系统用户表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public class SysUser  extends BaseEntity {
	private static final long serialVersionUID = 1L;

	public static final String USERNAME_PATTERN = "^[\\u4E00-\\u9FA5\\uf900-\\ufa2d_a-zA-Z][\\u4E00-\\u9FA5\\uf900-\\ufa2d\\w]{1,19}$";
	public static final String EMAIL_PATTERN = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?";
	public static final String MOBILE_PHONE_NUMBER_PATTERN = "^0{0,1}(13[0-9]|15[0-9]|14[0-9]|18[0-9])[0-9]{8}$";
	public static final int USERNAME_MIN_LENGTH = 4;
	public static final int USERNAME_MAX_LENGTH = 20;
	public static final int PASSWORD_MIN_LENGTH = 6;
	public static final int PASSWORD_MAX_LENGTH = 20;
	
	//主键，自增ID
	private Long id;
	//部门ID
	private Long userDepartmentId;

	//姓名
	@NotBlank()
	@Length(min = 2, max = 20, message = "用户名必须在2-20个字符之间")
	private String realName;

	//用户名
	@NotBlank()
	@Length(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH, message = "用户名必须在4-20个字符之间")
	@Pattern(regexp = USERNAME_PATTERN, message = "用户名不符合规定")
	private String username;

	//密码
	//@NotBlank()
	//@Length(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH, message = "用户名必须在6-20个字符之间")
	@JsonIgnore    //springmvc生成json不包含此字段
	private String password;

	//密码盐值
	@JsonIgnore    //springmvc生成json不包含此字段
	private String passwordSalt;

	//是否管理员
	@NotNull()
	private Boolean isAdmin;

	//手机号
	private String mobile;
	//邮箱
	private String email;

	//激活状态  0：未激活   1：已激活
	@NotNull()
	private Boolean activated;
	//锁定状态 0：正常   1：锁定
	@NotNull()
	private Boolean locked;
	//禁用状态  0：正常   1：禁用
	@NotNull()
	private Boolean disabled;
	//状态  0：正常   1：删除
	private Boolean isDeleted;
	//注册时间 或 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createdTime;
	//创建人
	private String createdBy;
	//创建人IP
	private String createdIp;
	//修改时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date modificationTime;
	//修改人
	private String modificationBy;
	//修改人IP
	private String modificationIp;
	//备注
	private String remark;



	/**
	 * 设置：主键，自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键，自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：部门ID
	 */
	public void setUserDepartmentId(Long userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}
	/**
	 * 获取：部门ID
	 */
	public Long getUserDepartmentId() {
		return userDepartmentId;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：密码盐值
	 */
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	/**
	 * 获取：密码盐值
	 */
	public String getPasswordSalt() {
		return passwordSalt;
	}
	/**
	 * 设置：是否管理员
	 */
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	/**
	 * 获取：是否管理员
	 */
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：注册时间 或 创建时间
	 */
	public void setCreatedTime(Date registerTime) {
		this.createdTime = registerTime;
	}
	/**
	 * 获取：注册时间 或 创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：激活状态  0：未激活   1：已激活
	 */
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	/**
	 * 获取：激活状态  0：未激活   1：已激活
	 */
	public Boolean getActivated() {
		return activated;
	}
	/**
	 * 设置：锁定状态  0：正常   1：锁定
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	/**
	 * 获取：锁定状态  0：正常   1：锁定
	 */
	public Boolean getLocked() {
		return locked;
	}
	/**
	 * 设置：禁用状态  0：禁用   1：正常
	 */
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	/**
	 * 获取：禁用状态  0：禁用   1：正常
	 */
	public Boolean getDisabled() {
		return disabled;
	}
	/**
	 * 设置：0：正常   1：删除
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：0：正常   1：删除
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 设置：创建IP
	 */
	public void setCreatedIp(String createdIp) {
		this.createdIp = createdIp;
	}
	/**
	 * 获取：创建IP
	 */
	public String getCreatedIp() {
		return createdIp;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModificationTime() {
		return modificationTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setModificationBy(String modificationBy) {
		this.modificationBy = modificationBy;
	}
	/**
	 * 获取：修改人
	 */
	public String getModificationBy() {
		return modificationBy;
	}
	/**
	 * 设置：修改人IP
	 */
	public void setModificationIp(String modificationIp) {
		this.modificationIp = modificationIp;
	}
	/**
	 * 获取：修改人IP
	 */
	public String getModificationIp() {
		return modificationIp;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}





	//供界面使用

	//部门名称
	private String userDepartmentName;
	//角色名称
	private String userRoleNames;
	//角色ID
	private List<Long> userRoleIds;
	/**
	 * 设置：部门名称
	 */
	public void setUserDepartmentName(String userDepartmentName) {
		this.userDepartmentName = userDepartmentName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getUserDepartmentName() {
		return userDepartmentName;
	}
	/**
	 * 设置：角色名称
	 */
	public void setUserRoleNames(String userRoleNames) {
		this.userRoleNames = userRoleNames;
	}
	/**
	 * 获取：角色名称
	 */
	public String getUserRoleNames() {
		return userRoleNames;
	}
	/**
	 * 设置：角色ID
	 */
	public List<Long> getUserRoleIds() {
		return userRoleIds;
	}
	/**
	 * 获取：角色ID
	 */
	public void setUserRoleIds(List<Long> userRoleIds) {
		this.userRoleIds = userRoleIds;
	}

	@Override
	public String toString() {
		return "SysUser{" +
				"id=" + id +
				", userDepartmentId=" + userDepartmentId +
				", realName='" + realName + '\'' +
				", username='" + username + '\'' +
				//", password='" + password + '\'' +
				//", passwordSalt='" + passwordSalt + '\'' +
				", isAdmin=" + isAdmin +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", activated=" + activated +
				", locked=" + locked +
				", disabled=" + disabled +
				", isDeleted=" + isDeleted +
				", createdTime=" + createdTime +
				", createdBy='" + createdBy + '\'' +
				", createdIp='" + createdIp + '\'' +
				", modificationTime=" + modificationTime +
				", modificationBy='" + modificationBy + '\'' +
				", modificationIp='" + modificationIp + '\'' +
				", remark='" + remark + '\'' +
				", userDepartmentName='" + userDepartmentName + '\'' +
				", userRoleNames='" + userRoleNames + '\'' +
				", userRoleIds=" + userRoleIds +
				'}';
	}
}
