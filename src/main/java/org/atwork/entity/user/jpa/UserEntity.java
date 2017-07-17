package org.atwork.entity.user.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "user"
 *
 * @author Prasad Gudipati
 *
 */

@Entity
@Table(name="user")
public class UserEntity implements Serializable {	

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", nullable=false)
    private Long userId;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="email", length=40)
    private String email;

    @Column(name="username", length=12)
    private String username;

    @Column(name="password", length=20)
    private String password;
    
	//----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="userEntity", cascade = CascadeType.ALL)
    private List<UserHobbyEntity> userHobbyEntity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="userEntity", cascade = CascadeType.ALL)
    private List<UserPhoneEntity> userPhoneEntity;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="userEntity", cascade = CascadeType.ALL)
    private List<UserRoleEntity> userRoleEntity;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UserEntity() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUserId( Long userId ) {
        this.userId = userId ;
    }
    public Long getUserId() {
        return this.userId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : email ( VARCHAR ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    //--- DATABASE MAPPING : username ( VARCHAR ) 
    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 // Relationsship getter and setters
	public List<UserHobbyEntity> getUserHobbyEntity() {
		return userHobbyEntity;
	}

	public void setUserHobbyEntity(List<UserHobbyEntity> userHobbyEntity) {
		this.userHobbyEntity = userHobbyEntity;
	}

	public List<UserPhoneEntity> getUserPhoneEntity() {
		return userPhoneEntity;
	}

	public void setUserPhoneEntity(List<UserPhoneEntity> userPhoneEntity) {
		this.userPhoneEntity = userPhoneEntity;
	}

	public List<UserRoleEntity> getUserRoleEntity() {
		return userRoleEntity;
	}

	public void setUserRoleEntity(List<UserRoleEntity> userRoleEntity) {
		this.userRoleEntity = userRoleEntity;
	} 	
	
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(userId);
        sb.append("]:"); 
        sb.append(email);
        sb.append("|");
        sb.append(username);
        sb.append("|");
        sb.append(password);
        return sb.toString(); 
    }
}