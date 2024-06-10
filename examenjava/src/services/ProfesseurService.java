package services;

import java.util.List;

import entities.Professeur;
import entities.ProfesseurClasse;
import repositories.ProfesseurClasseRepository;
import repositories.ProfesseurRepository;


public class ProfesseurService {
      ProfesseurRepository professeurRepository=new ProfesseurRepository();
      private ProfesseurClasseRepository professeurClasseRepository=new ProfesseurClasseRepository();

      public  void ajouterUnProfesseur(Professeur professeur){
      
         professeurRepository.insert(professeur);
         Professeur lastProfesseur= professeurRepository.selectLastProfesseur();
         List<ProfesseurClasse> professeurClasses = professeur.getProfesseurClasses();
         for (ProfesseurClasse pc  : professeurClasses) {
            pc.setProfesseur(lastProfesseur);
            professeurClasseRepository.insert(pc);
         }

      }

      //public  Commande RecupererCommandeParNumero(String numero){
         // return commandeRepository.selectCommandeByNum(numero);
      }

