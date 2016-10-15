package main;

import java.util.Map;

import dao.RubricaDao;
import servizi.ServizioRubrica;
import model.Rubrica;
import model.Voce;




public class MainRubrica{

	public static void main(String[] args) {
		
		RubricaDao rDao = new RubricaDao();
		rDao.inserisciRubrica("Andrea");
		Rubrica r=rDao.trovaRubrica(1);
		
		System.out.println(r.getNome());
			
		ServizioRubrica g = new ServizioRubrica();
		
		Voce v1 = g.aggiungiVoce(r, "aaa", "aaa", "111");
		System.out.println(v1.getId_Voce()+" "+v1.getNome()+" "+v1.getCognome()+" "+v1.getTelefono());
		Voce v2 = g.aggiungiVoce(r, "bbb", "bbb", "222");
		System.out.println(v2.getId_Voce()+" "+v2.getNome()+" "+v2.getCognome()+" "+v2.getTelefono());
		Voce v3 = g.aggiungiVoce(r, "ccc", "ccc", "333");
		System.out.println(v3.getId_Voce()+" "+v3.getNome()+" "+v3.getCognome()+" "+v3.getTelefono());
		Voce v4 = g.aggiungiVoce(r, "ddd", "ddd", "444");
		System.out.println(v4.getId_Voce()+" "+v4.getNome()+" "+v4.getCognome()+" "+v4.getTelefono());
		
		System.out.println();
		Voce v5 = g.getVoce(r, "bbb", "bbb");
		System.out.println(v5.getId_Voce()+"\t"+v5.getNome()+"\t"+v5.getCognome()+"\t"+v5.getTelefono());
		
		System.out.println();
	
//		Voce v6 = g.aggiornaVoce(r, "ccc", "ccc", "eee", "eee", "555");
////		System.out.println(v6.getId_Voce()+"\t"+v6.getNome()+"\t"+v6.getCognome()+"\t"+v6.getTelefono());
		g.aggiornaVoce(r, "ccc", "ccc", "eee", "eee", "555");
		g.cancellaVoce(r, "ddd", "ddd");
		
		System.out.println();
		
		Map<Integer, Voce> voci = g.getTutteVoci(r);
		
		for(Map.Entry<Integer, Voce> voce : voci.entrySet()){
			System.out.println(voce.getKey()+"\t"+voce.getValue().getNome()+"\t"
					+voce.getValue().getCognome()+"\t"+voce.getValue().getTelefono());
			
		}

	}

}