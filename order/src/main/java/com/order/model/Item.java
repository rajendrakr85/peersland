package com.order.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Entity
@ToString
@Data
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	@Column
	private String itemName;
	@Column
	private Double price;
	@Column
	private String description;
	
	public Item() {}
	@Override
	public int hashCode() {
		return Objects.hash(itemId,itemName,price);
	}
	
	@Override
	public boolean equals(Object obj) {
		Item item=(Item)obj;
		return this.itemId==item.itemId && this.itemName.equals(item.itemName) && this.price.equals(item.price) ;
	}
}

