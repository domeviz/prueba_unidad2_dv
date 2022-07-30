package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaMedicaService;

@SpringBootApplication
public class PruebaUnidad2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(PruebaUnidad2DvApplication.class);

	@Autowired
	private IDoctorService iDoctorService;

	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Autowired
	private IGestorCitaMedicaService iGestorCitaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Doctor d1 = new Doctor();
		d1.setCedula("123456");
		d1.setNombre("Domenica");
		d1.setApellido("Vizcarra");
		d1.setFechaNacimiento(LocalDateTime.of(1998, 10, 27, 10, 20));
		d1.setCodigoSenescyt("112344");
		d1.setGenero("F");
		d1.setNumeroConsultorio("1");

		Doctor d2 = new Doctor();
		d2.setCedula("789012");
		d2.setNombre("Luis");
		d2.setApellido("Ortiz");
		d2.setFechaNacimiento(LocalDateTime.of(1978, 1, 17, 20, 30));
		d2.setCodigoSenescyt("679889");
		d2.setGenero("M");
		d2.setNumeroConsultorio("3");

		this.iDoctorService.insertar(d1);

		LOG.debug("Se ha insertado el Doctor: " + d1);

		this.iDoctorService.insertar(d2);

		LOG.debug("Se ha insertado el Doctor: " + d2);

		Paciente p1 = new Paciente();
		p1.setCedula("173425332");
		p1.setNombre("Camila");
		p1.setApellido("Vaquez");
		p1.setFechaNacimiento(LocalDateTime.of(1997, 11, 7, 20, 03));
		p1.setCodigoSeguro("123");
		p1.setEstatura("159");
		p1.setPeso("50");
		p1.setGenero("F");

		Paciente p2 = new Paciente();
		p2.setCedula("9982112");
		p2.setNombre("Rodrigo");
		p2.setApellido("Mendez");
		p2.setFechaNacimiento(LocalDateTime.of(1977, 12, 4, 19, 13));
		p2.setCodigoSeguro("456");
		p2.setEstatura("169");
		p2.setPeso("70");
		p2.setGenero("M");

		this.iPacienteRepository.insertar(p1);

		LOG.debug("Se ha insertado el Paciente: " + p1);

		this.iPacienteRepository.insertar(p2);

		LOG.debug("Se ha insertado el Paciente: " + p2);

		this.iGestorCitaMedicaService.agendar("1", LocalDateTime.now(), new BigDecimal(100), "Amazonas", "789012",
				"173425332");

		int resultado = this.iGestorCitaMedicaService.actualizarPorNumeroCita("1", "Enfermo", "Paracetamol",
				LocalDateTime.of(2025, 1, 7, 12, 30));

		LOG.debug("Cantidad de registros actualizados: " + resultado);

		List<PacienteSencillo> ps = this.iGestorCitaMedicaService
				.reportePacientes(LocalDateTime.of(1977, 12, 4, 19, 13), "F");
		for (PacienteSencillo i : ps) {
			LOG.debug("Pacientes encontrados: " + i);
		}

	}

}
