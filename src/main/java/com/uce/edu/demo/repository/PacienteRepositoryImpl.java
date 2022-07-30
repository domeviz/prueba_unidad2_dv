package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Paciente buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myNamedQuery = this.entityManager.createNamedQuery("Paciente.buscarPorCedula");
		myNamedQuery.setParameter("datoCedula", cedula);
		return (Paciente) myNamedQuery.getSingleResult();
	}

	@Override
	public List<PacienteSencillo> reportePacientes(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.modelo.PacienteSencillo(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :datoFechaNacimiento AND p.genero = :datoGenero",
				PacienteSencillo.class);
		myQuery.setParameter("datoFechaNacimiento", fechaNacimiento);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}
}
