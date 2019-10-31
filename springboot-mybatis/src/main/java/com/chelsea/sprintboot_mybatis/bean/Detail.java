package com.chelsea.sprintboot_mybatis.bean;

import java.io.Serializable;
import java.util.Date;

public class Detail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String groupName;
	private Date operTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

}
