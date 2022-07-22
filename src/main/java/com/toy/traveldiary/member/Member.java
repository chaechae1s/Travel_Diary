package com.toy.traveldiary.member;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	
	@Id @GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	private String nickname;
	private boolean enabled;
	
	@ManyToMany
	@JoinTable(
	  name = "member_role", 
	  joinColumns = @JoinColumn(name = "member_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
}
