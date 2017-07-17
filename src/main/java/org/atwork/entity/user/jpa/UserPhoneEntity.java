package org.atwork.entity.user.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "userphone"
 *
 * @author Prasad Gudipati
 *
 */

@Entity
@Table(name="userphone")
public class UserPhoneEntity implements Serializable {	

	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	//----------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;


	//----------------------------------------------------------------------
	// ENTITY DATA FIELDS 
	//----------------------------------------------------------------------    
	@Column(name="type", length=10)
	private String type;

	@Column(name="phoneNumber", length=10)
	private String phoneNumber;

	@Column(name="createdBy", length=40)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="createdOn")
	private Date createdOn;
	

	//----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	//----------------------------------------------------------------------
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userEntity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	//----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	//----------------------------------------------------------------------
	public UserPhoneEntity() {
		super();
	}

	public void setId( Long id ) {
		this.id = id;
	}
	public Long getId() {
		return this.id;
	}

	//----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	//----------------------------------------------------------------------

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "UserPhoneEntity [id=" + id + ", type=" + type + ", phoneNumber=" + phoneNumber + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", userEntity=" + userEntity + "]";
	}    
}