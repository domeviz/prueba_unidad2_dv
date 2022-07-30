package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import com.uce.edu.demo.modelo.CitaMedica;

public interface ICitaMedicaRepository {

	public void insertar(CitaMedica citaMedica);

	public CitaMedica buscar(Integer id);

	public void actualizar(CitaMedica citaMedica);
	
	public void eliminar(Integer id);
	
	public int actualizarPorNumeroCitaQuery(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);
}
