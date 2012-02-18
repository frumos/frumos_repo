package com.dima.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Dmytro Kovtun
 * @since 21.01.2012
 * 
 * Example of many to many mapping JPA mapping
 */

@Entity
@Table(name = "keycodes")
public class Keycode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(name = "keycode")
	private String keycode;
	
	@ManyToMany(mappedBy = "keycodes", fetch = FetchType.LAZY)
	private List<Message> messages;
	
	public Integer getId() {
		return id;
	}

	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
