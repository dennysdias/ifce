/*
 * @version     1.0.0
 * @author      Dennys Dias Lopes
 * @contact     dennys_dias@yahoo.com.br 
 * 
 * @copyright  	Copyright 2010 - 2016 J7 Smart Solutions, all rights reserved.
 * 
 */
package com.j7ss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;

/**
 * 
 * @author Dennys Dias
 * @date  10/08/2016
 * 
 */
@Entity
@Table(name = "professor")
public class Professor implements IGenericEntity<Professor>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	@Column(length=20)
	@Getter @Setter
	private String telefone;
	
	@Getter @Setter
	private String email;	
	
	@Getter @Setter
	private String qualificacao;
	
	@Getter @Setter
	private Integer idade;
	
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@Setter
	private Usuario usuario;
	
	@OneToMany(mappedBy="professor", cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.JOIN)
	@Getter @Setter
	private List<Curso> curso;
	
	
	
	
//******************************************************************************************************************************
//## Builder
	public Professor id(Integer id){
		this.id = id;
		return this;
	}
	
	public Professor nome(String nome){
		this.nome = nome;
		return this;
	}
	
	public Professor telefone(String telefone){
		this.telefone = telefone;
		return this;
	}
	
	public Professor email(String email){
		this.email = email;
		return this;
	}
	
	public Professor qualificacao(String qualificacao){
		this.qualificacao = qualificacao;
		return this;
	}
	
	public Professor idade(Integer idade){
		this.idade = idade;
		return this;
	}
	
	public Professor addCurso(Curso cursoObj){
		if(curso == null){
			curso = new  ArrayList<>();
		}
		curso.add(cursoObj);
		return this;
	}
	
	public Professor removeCurso(Curso cursoObj){
		if(curso != null){
			curso.remove(cursoObj);
		}
		return this;
	}
	
//******************************************************************************************************************************
//## Getters Setters
	@Override
	public boolean isNew() {
		return id == null;
	}



	public static DAO<Professor> getDao() {
		return dao;
	}

	public static void setDao(DAO<Professor> dao) {
		Professor.dao = dao;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(String qualificacao) {
		this.qualificacao = qualificacao;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}





	//******************************************************************************************************************************
//## DAO
	private static DAO<Professor> dao = new DAO<Professor>(Professor.class);
	
	@Override
	public Professor save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
	public static List<Professor> findAll(){
		return dao.findByQuery("SELECT p FROM Professor p"); 
	}
	
	public static Professor findById(Integer idProfessor){
		return dao.findOne(idProfessor);
	}
	
	public static List<Professor> findByNomeLike(String nome){
		return dao.findByQuery("SELECT p FROM Professor p WHERE lower(p.nome) like ?1" , "%"+nome.toLowerCase()+"%");
	}
	
	public static List<Professor> findByNome(String nome){
		return dao.findByQuery("SELECT p FROM Professor p WHERE p.nome = ?1" , nome);
	}
	
	public static Professor findByIdUsuario(Integer idUsuario){
		return dao.findOneByQuery("SELECT p FROM Professor p WHERE p.idUsuario = ?1" , idUsuario);
	}
	
	
}
