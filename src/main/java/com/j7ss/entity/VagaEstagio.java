/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@j7ss.com ( http://www.j7ss.com )
 * 
 * @copyright  	Copyright 2010 - 2016 J7 Smart Solutions, all rights reserved.
 * 
 */
package com.j7ss.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.DateUtil;
import com.j7ss.core.IGenericEntity;
import com.j7ss.entity.constraint.VagaEstagioAtividadeDiariaStatus;
import com.j7ss.entity.constraint.VagaEstagioStatus;
import com.j7ss.entity.constraint.VagaEstagioTurno;
import com.j7ss.entity.constraint.VagaEstagioType;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
@Entity
@Table(name = "vaga_estagio")
@ToString(of={"nome"}) @EqualsAndHashCode(of={"id"})
public class VagaEstagio implements IGenericEntity<VagaEstagio>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private String requisitos;
	
	@Getter @Setter
	private String atividades;   // Atividades a serem desenvolvidas
	
	@Getter @Setter
	private String resultados;   // Resultados esperados
	
	@Getter @Setter
	private String setor;   	// Setor de realização do estagio
	
	@Getter @Setter
	private String beneficios;
	
	@Getter @Setter
	private Integer cargaHoraria;
	
	@Getter @Setter
	private Double remuneracao;
	
	@Getter @Setter
	private VagaEstagioTurno turno;
	
	@Getter @Setter
	private Date horaInicioEstagio;
	
	@Getter @Setter
	private Date horaFimOuIntervalo;
	
	@Getter @Setter
	private Date horaRetorno;
	
	@Getter @Setter
	private Date horaFimEstagio;
	
	@Getter @Setter
	private Date vigenciaInicio;
	
	@Getter @Setter
	private Date vigenciaFim;
	
	@Getter @Setter
	private Double valorTransporte;
	
	@Getter @Setter
    private String apoliceNumero;
	
	@Getter @Setter
	private String apoliceEmpresa;
	
	@Getter @Setter
	private VagaEstagioStatus status = VagaEstagioStatus.NOVA;
	
	@Getter @Setter
	private VagaEstagioType type = VagaEstagioType.OBRIGATORIO;
	
	@ManyToOne
	@Getter @Setter
	private Aluno aluno;
	
	@ManyToOne
	@Setter
	private Empresa empresa;
	
	@ManyToOne
	@Setter
	private EmpresaSupervisor empresaSupervisor;
	
	@OneToMany(mappedBy="vagaEstagio", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.SUBSELECT)  
	@OrderBy("date")
	@Setter
	private List<VagaEstagioAtividadeDiaria> atividadesDiaria;
	
	@OneToMany(mappedBy="vagaEstagio", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.SUBSELECT)  
	@OrderBy("ordem")
	@Setter
	private List<DocumentoVagaEstagio> documentosVagaEstagio;
	
	public VagaEstagio(){ }
	
	public VagaEstagio(String nome){
		this.nome = nome;
	}

	
//******************************************************************************************************************************
//## Builder
	public VagaEstagio idVaga(Integer id){
		this.id = id;
		return this;
	}
	
	public VagaEstagio nome(String nome){
		this.nome = nome;
		return this;
	}
	
	public VagaEstagio descricao(String descricao){
		this.descricao = descricao;
		return this;
	}
	
	public VagaEstagio requisitos(String requisitos){
		this.requisitos = requisitos;
		return this;
	}
	
	public VagaEstagio atividades(String atividades){
		this.atividades = atividades;
		return this;
	}
	
	public VagaEstagio beneficios(String beneficios){
		this.beneficios = beneficios;
		return this;
	}
	
	public VagaEstagio cargaHoraria(Integer cargaHoraria){
		this.cargaHoraria = cargaHoraria;
		return this;
	}
	
	public VagaEstagio remuneracao(Double remuneracao){
		this.remuneracao = remuneracao;
		return this;
	}
	
	public VagaEstagio turno(VagaEstagioTurno turno){
		this.turno = turno;
		return this;
	}
	
	public VagaEstagio horaInicioEstagio(Date horaInicioEstagio){
		this.horaInicioEstagio = horaInicioEstagio;
		return this;
	}
	
	public VagaEstagio horaFimOuIntervalo(Date horaFimOuIntervalo){
		this.horaFimOuIntervalo = horaFimOuIntervalo;
		return this;
	}
	
	public VagaEstagio horaRetorno(Date horaRetorno){
		this.horaRetorno = horaRetorno;
		return this;
	}
	
	public VagaEstagio horaFimEstagio(Date horaFimEstagio){
		this.horaFimEstagio = horaFimEstagio;
		return this;
	}
	
	public VagaEstagio vigenciaInicio(Date vigenciaInicio){
		this.vigenciaInicio = vigenciaInicio;
		return this;
	}
	
	public VagaEstagio vigenciaFim(Date vigenciaFim){
		this.vigenciaFim = vigenciaFim;
		return this;
	}
	
	public VagaEstagio valorTransporte(Double valorTransporte){
		this.valorTransporte = valorTransporte;
		return this;
	}
	
	public VagaEstagio apoliceNumero(String apoliceNumero){
		this.apoliceNumero = apoliceNumero;
		return this;
	}
	
	public VagaEstagio apoliceEmpresa(String apoliceEmpresa){
		this.apoliceEmpresa = apoliceEmpresa;
		return this;
	}
	
	public VagaEstagio aluno(Aluno aluno){
		this.aluno = aluno;
		return this;
	}
	
	public VagaEstagio empresa(Empresa empresa){
		this.empresa = empresa;
		return this;
	}
	
	public VagaEstagio empresaSupervisor(EmpresaSupervisor empresaSupervisor){
		this.empresaSupervisor = empresaSupervisor;
		return this;
	}

	public VagaEstagio addDocumento(DocumentoVagaEstagio docAluno) throws DAOException{
		this.getDocumentosVagaEstagio().add(docAluno.vagaEstagio(this).save());
		return this;
	}
	
	public VagaEstagio addAtividadeDiaria(VagaEstagioAtividadeDiaria atividadeDiaria) throws DAOException{
		this.getAtividadesDiaria().add(atividadeDiaria.vagaEstagio(this).save());
		return this;
	}
	
//******************************************************************************************************************************
//## Getters Setters
	@Override
	public boolean isNew() {
		return id == null;
	}
	
	public Empresa getEmpresa() {
		return empresa == null ? empresa  = new Empresa() : empresa;
	}
	
	public EmpresaSupervisor getEmpresaSupervisor() {
		return empresaSupervisor == null ? empresaSupervisor = new EmpresaSupervisor() : empresaSupervisor;
	}
	
	public List<Documento> getDocumentos(){
		List<Documento> documentos = new ArrayList<>();
		for (DocumentoVagaEstagio docA : documentosVagaEstagio) {
			documentos.add(docA.getDocumento());
		}
		return documentos;
	}
	
	public Integer getHorasConcluidas(){
		int value = 0;
		for (VagaEstagioAtividadeDiaria atividade : getAtividadesDiaria()) {
			if(atividade.getStatus().equals(VagaEstagioAtividadeDiariaStatus.OK)){
				value = value + atividade.getQuantidadeHoras();
			}
		}
		return value;
	}
	
	public Integer getDuracaoEstagio(){
		return getAluno().getCurso().getDuracaoEstagio();
	}
	
	public List<DocumentoVagaEstagio> getDocumentosVagaEstagio() {
		return documentosVagaEstagio; // == null && !isNew() ? documentosVagaEstagio = DocumentoVagaEstagio.findByVagaEstagio(this) : documentosVagaEstagio;
	}
	
	public List<VagaEstagioAtividadeDiaria> getAtividadesDiaria() {
		return atividadesDiaria;  //== null && !isNew() ? atividadesDiaria = VagaEstagioAtividadeDiaria.findByVagaEstagio(this) : atividadesDiaria;
	}
	
	public String getVigenciaInicioFormat(){
		return DateUtil.format(vigenciaInicio);
	}
	
	public String getVigenciaFimFormat(){
		return DateUtil.format(vigenciaFim);
	}
	
	public String getHoraInicioEstagioFormat(){
		if(horaInicioEstagio != null){
			return DateUtil.getHora(horaInicioEstagio);
		}
		return "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	
	public String getHoraFimOuIntervaloFormat(){
		if(horaFimOuIntervalo != null){
			return DateUtil.getHora(horaFimOuIntervalo);
		}
		return "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	
	public String getHoraRetornoFormat(){
		if(horaRetorno != null){
			return DateUtil.getHora(horaRetorno);
		}
		return "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	
	public String getHoraFimEstagioFormat(){
		if(horaFimEstagio != null){
			return DateUtil.getHora(horaFimEstagio);
		}
		return "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Double getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(Double remuneracao) {
		this.remuneracao = remuneracao;
	}

	public VagaEstagioTurno getTurno() {
		return turno;
	}

	public void setTurno(VagaEstagioTurno turno) {
		this.turno = turno;
	}

	public Date getHoraInicioEstagio() {
		return horaInicioEstagio;
	}

	public void setHoraInicioEstagio(Date horaInicioEstagio) {
		this.horaInicioEstagio = horaInicioEstagio;
	}

	public Date getHoraFimOuIntervalo() {
		return horaFimOuIntervalo;
	}

	public void setHoraFimOuIntervalo(Date horaFimOuIntervalo) {
		this.horaFimOuIntervalo = horaFimOuIntervalo;
	}

	public Date getHoraRetorno() {
		return horaRetorno;
	}

	public void setHoraRetorno(Date horaRetorno) {
		this.horaRetorno = horaRetorno;
	}

	public Date getHoraFimEstagio() {
		return horaFimEstagio;
	}

	public void setHoraFimEstagio(Date horaFimEstagio) {
		this.horaFimEstagio = horaFimEstagio;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public Double getValorTransporte() {
		return valorTransporte;
	}

	public void setValorTransporte(Double valorTransporte) {
		this.valorTransporte = valorTransporte;
	}

	public String getApoliceNumero() {
		return apoliceNumero;
	}

	public void setApoliceNumero(String apoliceNumero) {
		this.apoliceNumero = apoliceNumero;
	}

	public String getApoliceEmpresa() {
		return apoliceEmpresa;
	}

	public void setApoliceEmpresa(String apoliceEmpresa) {
		this.apoliceEmpresa = apoliceEmpresa;
	}

	public VagaEstagioStatus getStatus() {
		return status;
	}

	public void setStatus(VagaEstagioStatus status) {
		this.status = status;
	}

	public VagaEstagioType getType() {
		return type;
	}

	public void setType(VagaEstagioType type) {
		this.type = type;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public static DAO<VagaEstagio> getDao() {
		return dao;
	}

	public static void setDao(DAO<VagaEstagio> dao) {
		VagaEstagio.dao = dao;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setEmpresaSupervisor(EmpresaSupervisor empresaSupervisor) {
		this.empresaSupervisor = empresaSupervisor;
	}

	public void setAtividadesDiaria(
			List<VagaEstagioAtividadeDiaria> atividadesDiaria) {
		this.atividadesDiaria = atividadesDiaria;
	}

	public void setDocumentosVagaEstagio(
			List<DocumentoVagaEstagio> documentosVagaEstagio) {
		this.documentosVagaEstagio = documentosVagaEstagio;
	}



	//******************************************************************************************************************************
//## DAO
	private static DAO<VagaEstagio> dao = new DAO<VagaEstagio>(VagaEstagio.class);
	
	@Override
	public VagaEstagio save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
	public static List<VagaEstagio> findAll(){
		return dao.findAll();
	}
	
	public static List<VagaEstagio> findByAluno(Aluno aluno){
		return dao.findByQuery("Select v From VagaEstagio v Where v.aluno = ?1", aluno);
	}
}
