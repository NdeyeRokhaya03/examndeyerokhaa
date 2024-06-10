package services;

import java.util.List;

import entities.Inscription;
import repositories.InscriptionRepository;

public class InscriptionService {
    InscriptionRepository inscriptionRepository=new InscriptionRepository();

    public void faireInscription(Inscription inscription){
        inscriptionRepository.insert(inscription);
    }
   

    public List<Inscription>listerInscriptionParAnnee(String anneeScolaire){
        return inscriptionRepository.selectInscriptionByAnnee(anneeScolaire);
    }
    public List<Inscription>listerInscriptionParAnnee(String anneeScolaire, int idClasse){
        return inscriptionRepository.selectInscriptionByAnnee(anneeScolaire,idClasse);
   }
   public Inscription rechercherInscriptionparMatriculeEtudiant(String matricule){
    return inscriptionRepository.selectInscriptionByMatricule(matricule);
}
}
   