package com.coding.unicorn.auction.app.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "identifiable_mark")
public class IdentifiableMark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "id")
	private Long id;
	private String side;
	private String location;
	private String mark;
	private String color;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "unicorn_id")
	private Unicorn unicorn;

	public IdentifiableMark() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Unicorn getUnicorn() {
		return unicorn;
	}

	public void setUnicorn(Unicorn unicorn) {
		this.unicorn = unicorn;
	}

	@Override
	public String toString() {
		return "IdentifiableMark [id=" + id + ", side=" + side + ", location=" + location + ", mark=" + mark
				+ ", color=" + color + ", unicorn=" + unicorn + "]";
	}

}
