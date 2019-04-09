package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IVilleDao;
import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.Ville;
import com.appgestion.web.services.IVilleService;

@Transactional
public class VilleServiceImp implements IVilleService{

	private IVilleDao dao;
	
	public void setDao(IVilleDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Ville save(Ville entity) {
		
		return dao.save(entity);
	}

	@Override
	public Ville update(Ville entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Ville> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Ville getById(long id) {
	
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Ville> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Ville findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Ville findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}

	@Override
	public List<Salle> selectAllSalleByVille(long idVille) {
		
		return dao.selectAllSalleByVille(idVille);
	}

	@Override
	public List<Client> selectAllClientByVille(long idVille) {
		
		return dao.selectAllClientByVille(idVille);
	}

}
