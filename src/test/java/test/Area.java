package test;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-12 21:10.
 */
public class Area {

	@Id
	private Integer id;
	private String code;
	private String desc;
	private String address;
	@Column(name = "p_code")
	private String parentCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
}
