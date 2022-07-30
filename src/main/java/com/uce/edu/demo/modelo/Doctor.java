package com.uce.edu.demo.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@Column(name = "doct_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doct_id_seq")
	@SequenceGenerator(name = "doct_id_seq", sequenceName = "doct_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "doct_cedula")
	private String cedula;
	@Column(name = "doct_nombre")
	private String nombre;
	@Column(name = "doct_apellido")
	private String apellido;
	@Column(name = "doct_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name = "doct_numero_consultorio")
	private String numeroConsultorio;
	@Column(name = "doct_codigo_senescyt")
	private String codigoSenescyt;
	@Column(name = "doct_genero")
	private String genero;

	@OneToMany(mappedBy = "doctor")
	private List<CitaMedica> citasMedicas;

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", numeroConsultorio=" + numeroConsultorio
				+ ", codigoSenescyt=" + codigoSenescyt + ", genero=" + genero + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public String getCodigoSenescyt() {
		return codigoSenescyt;
	}

	public void setCodigoSenescyt(String codigoSenescyt) {
		this.codigoSenescyt = codigoSenescyt;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

}
