package com.totalizator.dao.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by home
 */
@Entity
@Table(name = "users")
@NamedStoredProcedureQuery(name = "User.updateCash", procedureName = "updateUserCash", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "userCash", type = Float.class)
})
public class User implements UserDetails {

	@Id
	@GeneratedValue(generator = "user_native")
	@GenericGenerator(name = "user_native", strategy = "native")
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private long id;
	@Column(name = "Username", nullable = false, unique = true, updatable = false)
	private String username;
	@Column(name = "Password", nullable = false)
	private String password;
	@Column(name = "webPurse", nullable = false)
	private String webPurse;
	@Column(name = "cash", nullable = false)
	private float cash = 50000;
	@Column(name = "Enabled", nullable = false)
	private boolean enabled;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_roles",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Bet> bets;

	@Column(name = "mail", nullable = false)
	private String mail;

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set<Bet> getBets() {
		return bets;
	}

	public void setBets(Set<Bet> bets) {
		this.bets = bets;
	}

	public String getWebPurse() {
		return webPurse;
	}

	public void setWebPurse(String webPurse) {
		this.webPurse = webPurse;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getRoles();
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {return true;}

	@Override
	public boolean isAccountNonLocked() {return true;}

	@Override
	public boolean isCredentialsNonExpired() {return true;}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public String getUsername(String username) {
		return this.username;
	}

	public String getPassword(String password) {
		return this.password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean getEnabled(){
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addCash(float cash){
		this.cash += cash;
	}
}
