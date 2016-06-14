package com.totalizator.mvc.viewmodels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by kasyanov on 6/14/2016.
 */

@JsonAutoDetect
public class MessageViewModel {

	private long id;
	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
