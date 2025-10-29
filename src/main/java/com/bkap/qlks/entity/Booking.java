package com.bkap.qlks.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bkap_booking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String accountId;
	private Integer totalAmount;
	private Integer isCancel;
	private String paymentStatus;
	private Date createdAt;
	private Date updateAt;
	private Integer deleteFlg;
	
}
