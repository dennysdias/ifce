/*
 * @version     1.0.0
 * @author      Dennys Dias Lopes
 * @contact     dennys_dias@yahoo.com.br 
 * 
 * @copyright  	Copyright 2010 - 2016 J7 Smart Solutions, all rights reserved.
 * 
 */
package com.j7ss.view.admin;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.BasicView;
import com.j7ss.core.Messages;
import com.j7ss.entity.Professor;

/**
 * 
 * @author Dennys Dias Lopes
 * @date  10/08/2016
 * 
 */
@ManagedBean
@ViewScoped
public class AdminProfessorBean extends BasicView<Professor>{
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
	public void grid() {
		super.grid();		
	}
	
	@Override
	public void setEntity(Professor entity) {
		super.setEntity(entity);
		
	}
	
	
//## Growl Messages
	@Override
	public void onSave() {
		Messages.showGrowlInfo("Professor", "Professor <strong>{0}</strong> salvo com sucesso!", entity.getNome());
	}
	
	@Override
	public void onRemove(Professor professor) {
		Messages.showGrowlInfo("Professor", "Professor <strong>{0}</strong> removido com sucesso!", professor.getNome());
	}
	
	
//******************************************************************************************************************************
//## Getters Setters	
	
	@Override
	public Professor getEntity() {
		return entity == null ? entity = new Professor() : entity;
	}
	
	@Override
	public List<Professor> getEntitys() {
		return entitys == null ? entitys = Professor.findAll() : entitys;
	}
	

}
