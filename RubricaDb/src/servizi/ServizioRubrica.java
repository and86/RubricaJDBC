package servizi;


import java.util.Map;

import model.Rubrica;
import model.Voce;
import dao.VoceDao;

public class ServizioRubrica {

	private VoceDao vDao = new VoceDao();

	public Voce aggiungiVoce(Rubrica r, String nome, String cognome,
			String telefono) {
		
		Voce v = null;
		boolean bool = vDao.inserisciVoce(nome, cognome, telefono,
				r.getId_rubrica());
		if (bool) {
			v = vDao.trovaVoce(nome, cognome, r.getId_rubrica());
		}
		return v;
	}
	
	public Voce getVoce(Rubrica r,String nome,String cognome){
		Voce v=null;
		v=vDao.trovaVoce(nome, cognome, r.getId_rubrica());
		return v;
	}
	
	public Map<Integer,Voce> getTutteVoci(Rubrica r){
		return vDao.trovaVoce(r.getId_rubrica());
				
	}
	
	public Voce aggiornaVoce(Rubrica r,String nomeVecchio,String cognomeVecchio,
			String nome,String cognome,String telefono){
		
		Voce v=null;
		v=vDao.trovaVoce(nomeVecchio, cognomeVecchio, r.getId_rubrica());
		if(v!=null){
			vDao.aggiornaVoce(nome, cognome, telefono, r.getId_rubrica());
			v=vDao.trovaVoce(nome, cognome, r.getId_rubrica());
		}
		return v;
	}
	
//	public void aggiornaVoce(Rubrica r,String nomeVecchio,String cognomeVecchio,
//			String nome,String cognome,String telefono){
//				
//		Voce v=vDao.trovaVoce(nomeVecchio, cognomeVecchio, r.getId_rubrica());
//		vDao.aggiornaVoce(v.getId_Voce());
//	}
			
		
		
		
	
	public void cancellaVoce(Rubrica r,String nome,String cognome){
		Voce v=vDao.trovaVoce(nome, cognome, r.getId_rubrica());
		vDao.cancellaVoce(v.getId_Voce());
	}
	
	
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void deleteVoce(Rubrica r, String nome, String cognome){
//		Voce v = vDAO.trovaVoce(nome, cognome, r.getId_rubrica());
//		vDAO.rimuoviVoce(v.getId_voce());		
	}

	



