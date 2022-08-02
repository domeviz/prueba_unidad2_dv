package com.uce.edu.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		this.iGestorCitaMedicaService.actualizarCita("1", "Conjuntivitis", "Gotero",
				LocalDateTime.of(2025, 1, 7, 12, 30));
		
		List<PacienteSencillo> ps = this.iGestorCitaMedicaService
				.reportePacientes(LocalDateTime.of(1970, 10, 2, 12, 10), "F");
		for (PacienteSencillo i : ps) {
			LOG.debug("Paciente encontrado: " + i);
		}
	}

}
