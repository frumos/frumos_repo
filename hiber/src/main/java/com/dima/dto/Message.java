package com.dima.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dmytro Kovtun
 * 
 * @since 21.01.2012
 *
 * Example of many to many mapping via JPA annotation
 */

@Entity
@Table(name = "messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "url")
	private String url;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "message_keycode",
		joinColumns = {@JoinColumn(referencedColumnName = "id", name = "message_f_id")},
		inverseJoinColumns = {@JoinColumn(referencedColumnName = "id", name = "keycode_f_id")}	
	)
	private List<Keycode> keycodes;
	
	@ManyToOne
	@JoinColumn(name = "category_f_id")
	private Category category;

	public Integer getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Keycode> getKeycodes() {
		return keycodes;
	}

	public void setKeycodes(List<Keycode> keycodes) {
		this.keycodes = keycodes;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	

}
