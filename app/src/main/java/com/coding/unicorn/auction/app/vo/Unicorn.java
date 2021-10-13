package com.coding.unicorn.auction.app.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "unicorns")
public class Unicorn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eyeColor;
	private String hairColor;
	private int height;
	private String heightUnit;
	private String hornColor;
	private int hornLength;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("unicornId")
	@Column(name = "id")
	private Long id;
	@OneToMany(mappedBy = "unicorn", cascade = { CascadeType.ALL })
	private List<IdentifiableMark> identifiableMarks = new ArrayList<>();;
	private String name;
	private String weight;
	private String weightUnit;

	public Unicorn() {
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getHeightUnit() {
		return heightUnit;
	}

	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}

	public String getHornColor() {
		return hornColor;
	}

	public void setHornColor(String hornColor) {
		this.hornColor = hornColor;
	}

	public int getHornLength() {
		return hornLength;
	}

	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<IdentifiableMark> getIdentifiableMarks() {
		return identifiableMarks;
	}

	public void setIdentifiableMarks(List<IdentifiableMark> identifiableMarks) {
		this.identifiableMarks = identifiableMarks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	@Override
	public String toString() {
		return "Unicorn [eyeColor=" + eyeColor + ", hairColor=" + hairColor + ", height=" + height + ", heightUnit="
				+ heightUnit + ", hornColor=" + hornColor + ", hornLength=" + hornLength + ", id=" + id
				+ ", identifiableMarks=" + identifiableMarks + ", name=" + name + ", weight=" + weight + ", weightUnit="
				+ weightUnit + "]";
	}

}
