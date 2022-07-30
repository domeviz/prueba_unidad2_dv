package com.uce.edu.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {

	@Id
	@Column(name = "cime_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cime_id_seq")
	@SequenceGenerator(name = "cime_id_seq", sequenceName = "cime_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "cime_numero_cita")
	private String numeroCita;
	@Column(name = "cime_fecha_cita")
	private LocalDateTime fechaCita;
	@Column(name = "cime_valor_cita")
	private BigDecimal valorCita;
	@Column(name = "cime_lugar_cita")
	private String lugarCita;
	@Column(name = "cime_diagnostico")
	private String diagnostico;
	@Column(name = "cime_receta")
	private String receta;
	@Column(name = "cime_fecha_proxima_cita")
	private LocalDateTime fechaProximaCita;

	@ManyToOne
	@JoinColumn(name = "cime_id_paciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "cime_id_doctor")
	private Doctor doctor;

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numeroCita=" + numeroCita + ", fechaCita=" + fechaCita + ", valorCita="
				+ valorCita + ", lugarCita=" + lugarCita + ", diagnostico=" + diagnostico + ", receta=" + receta
				+ ", fechaProximaCita=" + fechaProximaCita + ", doctor=" + doctor + ", paciente=" + paciente + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(String numeroCita) {
		this.numeroCita = numeroCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaProximaCita() {
		return fechaProximaCita;
	}

	public void setFechaProximaCita(LocalDateTime fechaProximaCita) {
		this.fechaProximaCita = fechaProximaCita;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
