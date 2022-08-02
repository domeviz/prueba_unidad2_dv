package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;
import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	@Autowired
	private IDoctorRepository iDoctorRepository;
	
	@Autowired
	private IPacienteRepository iPacienteRepository;
	
	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;
	
	@Override
	public void agendar(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		CitaMedica cm=new CitaMedica();
		cm.setNumeroCita(numeroCita);
		cm.setFechaCita(fechaCita);
		cm.setValorCita(valorCita);
		cm.setLugarCita(lugarCita);
		
		Doctor d= this.iDoctorRepository.buscarPorCedulaTyped(cedulaDoctor);
		cm.setDoctor(d);
		
		Paciente paciente=this.iPacienteRepository.buscarPorCedulaNamed(cedulaPaciente);
		cm.setPaciente(paciente);
		
		this.iCitaMedicaRepository.insertar(cm);
	}

	@Override
	public int actualizarPorNumeroCita(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		return this.iCitaMedicaRepository.actualizarPorNumeroCitaQuery(numeroCita, diagnostico, receta, fechaProximaCita);
	}

	@Override
	public List<PacienteSencillo> reportePacientes(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.reportePacientes(fechaNacimiento, genero);
	}

	@Override
	public void actualizarCita(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		CitaMedica cm =this.iCitaMedicaRepository.buscarPorNumero(numeroCita);
		cm.setDiagnostico(diagnostico);
		cm.setReceta(receta);
		cm.setFechaProximaCita(fechaProximaCita);
		
		 this.iCitaMedicaRepository.actualizar(cm);
	}
	

}
