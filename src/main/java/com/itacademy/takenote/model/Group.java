package com.itacademy.takenote.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class Group implements Serializable{
	
	/* Um grupo deve estar vinculado a um ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/* 
	 * O grupo Red Velvet possui apenas 5 membros: Yeri, Seulgi, Joy, Wendy e Irene.
	 * Logo, possuo uma lista de Pessoa. 
	 * 
	 * List<Pessoa>.posicao(1) = Yeri
	 * List<Pessoa>.posicao(2) = Seulgi
	 * List<Pessoa>.posicao(3) = Joy
	 * List<Pessoa>.posicao(4) = Wendy
	 * List<Pessoa>.posicao(5) = Irene
	 * 
	 */
	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Person> members;
	
	/*
	 * Yeri já está no grupo.
	 * Yeri não pode entrar no Red Velvet novamente, somente em caso de exclusão da mesma.
	 * Yeri não pode estar em dois grupos ao mesmo tempo.
	 * Yeri entrou no Red Velvet.	[True]
	 * Yeri entrou no Blackpink.	[False]
	 * Yeri saiu do Red Velvet.		[True]
	 * Yeri entrou no Blackpink.	[True]
	 * Yeri entrou no Blackpink.	[False]
	 * 
	 */
	
	/* Um grupo deve possuir um nome! */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Person> getMembers() {
		return members;
	}

	public void setMembers(List<Person> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
