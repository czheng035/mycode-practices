package com.czheng035.model;

import javax.persistence.Column;

public class BarcodeEntity extends BaseEntity {
	@Column(name = "format_name")
	private String formatName;
	
	@Column(name = "content")
	private String content;

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
