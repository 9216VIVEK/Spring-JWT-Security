package com.SpringSecurity.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import lombok.Data;


@Entity
@Data
@Table(name="USER_DETAILS")
@Where(clause = "ROW_STATUS=1")
public class UserVO implements Serializable  {
		 
	private static final long serialVersionUID = 5178432L;

	public UserVO(){
		super();
	}
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	private Long userid;
	
	private String email;
	private String fullname;
	private String mobileNumber;
 	private String  username;
	private String  password;
	private Integer loginStatus;
	private Integer activeStatus;
	private Long registrationid;
	private String accountNumber;
	private Long roleid;
	private Integer  rowStatus;
	private LocalDateTime insertDate;
	private LocalDateTime updateDate;
	private Long insertedBy;
	private Long updatedBy;
	private String userCode; 
	private String employeeId;
	
//	@Enumerated(EnumType.STRING)
	private String role; 
	
	@Transient
	private String  token;
	
}

