package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);

	public Paciente buscar(Integer id);

	public void actualizar(Paciente paciente);

	public void eliminar(Integer id);
	
	public Paciente buscarPorCedulaNamed(String cedula);
	
	public List<PacienteSencillo> reportePacientes(LocalDateTime fechaNacimiento, String genero);
	
}
