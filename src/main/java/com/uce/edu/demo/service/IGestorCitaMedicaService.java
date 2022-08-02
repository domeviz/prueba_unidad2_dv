package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.PacienteSencillo;

public interface IGestorCitaMedicaService {

	public void agendar(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);
	
	public int actualizarPorNumeroCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);
	
	public List<PacienteSencillo> reportePacientes(LocalDateTime fechaNacimiento, String genero);
	
	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);
}
