package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public int actualizarPorNumeroCitaQuery(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("UPDATE CitaMedica cm SET cm.diagnostico= :datoDiagnostico , cm.receta= :datoReceta , cm.fechaProximaCita= :datoFechaProximaCita WHERE cm.numeroCita= :datoNumeroCita");
		myQuery.setParameter("datoNumeroCita", numeroCita);
		myQuery.setParameter("datoDiagnostico", diagnostico);
		myQuery.setParameter("datoReceta", receta);
		myQuery.setParameter("datoFechaProximaCita", fechaProximaCita);
		return myQuery.executeUpdate();
	}

	@Override
	public CitaMedica buscarPorNumero(String numeroCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myTypedQuery=this.entityManager.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroCita=: datoNumero", CitaMedica.class);
		myTypedQuery.setParameter("datoNumero", numeroCita);
		return myTypedQuery.getSingleResult();
	}

}
