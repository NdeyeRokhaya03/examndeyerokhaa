import java.util.List;
import java.util.Scanner;

import entities.Classe;
import entities.Professeur;
import services.ClasseService;
import services.ProfesseurService;
import entities.ProfesseurClasse;


public class ResponsablePegagogiqueView {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc = new Scanner(System.in);
        ClasseService classeService=new ClasseService() ;
        ProfesseurService professeurService=new ProfesseurService();
        do{
            System.out.println("1-Ajouter une classe");
            System.out.println("2-Lister les classes");
            System.out.println("3-Ajouter des professeurs");
            System.out.println("4-Lister les professeurs");
            System.out.println("5-Filtrer les classes d'un professeur");
            choix=sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                System.out.println("Entrez le niveau de la classe(L1, L2, L3)");
                String niveau=sc.nextLine();
                System.out.println("Entrez la filière de la classe");
                String filiere=sc.nextLine();
                Classe cl= new Classe();
                cl.setNiveau(niveau);
                cl.setFiliere(filiere);
               classeService.ajouterClasse(cl);
                System.out.println("Classe ajoutée avec succés");


                    break;
                case 2: 
                    System.out.println("Les classes sont les suivantes:");
                    List<Classe> classes= classeService.ListerClasse();
                        for (Classe c: classes) {
                            System.out.println(c.getNiveau() +" "+ c.getFiliere());    
                        }
                    break;

                case 3:
                Professeur professeur=new Professeur();
             
                  System.out.println("Entrer le nci");
                  professeur.setNci(sc.nextInt());
                  sc.nextLine();
                  System.out.println("Entrer le Nom Complet");
                  professeur.setNomComplet(sc.nextLine());
                  System.out.println("Entrer le grade");
                  professeur.setGrade(sc.nextLine());
                
                    classes = classeService.ListerClasse();
                    int response;
                
                    do {
                        for (Classe c : classes) {
                            System.out.println(c.getNiveau()+"-"+c.getFiliere());
                          }
                         System.out.println("Veuillez selectionner la classe à laquelle vous voulez affecter un professeur");
                          int idClasse=sc.nextInt(); 
                          cl= classeService.findClasseById(idClasse);
                          if (cl!=null) {
                            
                             ProfesseurClasse professeurDeClasse=new ProfesseurClasse();
                             
                             professeur.getProfesseurClasses().add(professeurDeClasse);

                          }else{
                             System.out.println("Cet Id n'existe pas");
                          } 
                         
                         System.out.println("Voulez continuez 1-Oui 2-Non"); 
                         response=sc.nextInt(); 

                        }while(response==1);
                        if(professeur.getProfesseurClasses().size()==0){
                            professeurService.ajouterUnProfesseur(professeur);

                        }

                    break;
            
                default:
                    break;
            }
        }while(choix!=5);
    
    }

}


