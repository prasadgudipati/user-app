package org.atwork.entity.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long userId = Long.valueOf(-1);

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 40 )
    private String email;

	@Size( max = 12 )
    private String username;

    @Size( max = 20 )
    private String password;

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
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------

		public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(userId);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(username);
        sb.append("|");
        sb.append(password);
        return sb.toString(); 
    } 

}