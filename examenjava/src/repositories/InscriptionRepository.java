package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import entities.Inscription;

public class InscriptionRepository extends Database{
    private final  String SQL_INSERT="INSERT INTO `inscription` (`id`, `annee`, `matricule`,) VALUES (?,?,?,)";
    private final String SQL_SELECT_ALL="SELECT * FROM `inscription i`, etudiant where i.matricule=e.matricule and i.anneelike?";
    private final String SQL_SELECT_ALL_CLASSE="SELECT * FROM `inscription i`, etudiant where i.matricule=e.matricule and i.annee like? and i.id_classe like ?";
    private final String SQL_SELECT_BY_MATRICULE="SELECT * FROM `etudiant` where matricule like ? ";

    public void insert(Inscription inscription){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT);
             statement.setInt(1,inscription.getId());
             statement.setString(2,inscription.getAnneeScolaire());
             statement.setString(3,inscription.getEtudiant().getMatricule());
             executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  List<Inscription>selectInscriptionByAnnee(String anneeScolaire){
        List<Inscription> inscriptions=new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ALL);
            statement.setString(1, anneeScolaire);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Inscription inscription=new Inscription(); 
                inscription.setId(rs.getInt("id")); 
                inscription.setAnneeScolaire("anneeScolaire"); 
                Etudiant etudiant= new Etudiant();
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNomcomplet(rs.getString("nomComplet"));
                etudiant.setTuteur(rs.getString("tuteur"));
                inscription.setEtudiant(etudiant);
                inscriptions.add(inscription);
              
            }
            rs.close();
            fermerConnexion();

       } catch (SQLException e) {
           System.out.println("Erreur de connexion de la BD");
       }
       return inscriptions;
      }

      public  List<Inscription>selectInscriptionByAnnee(String anneeScolaire, int idClasse){
        List<Inscription> inscriptions=new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ALL_CLASSE);
            statement.setString(1, anneeScolaire);
            statement.setInt(2, idClasse);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Inscription inscription=new Inscription(); 
                inscription.setId(rs.getInt("id")); 
                inscription.setAnneeScolaire("anneeScolaire"); 
                Etudiant etudiant= new Etudiant();
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNomcomplet(rs.getString("nomComplet"));
                etudiant.setTuteur(rs.getString("tuteur"));
                inscription.setEtudiant(etudiant);
                inscriptions.add(inscription);
              
            }
            rs.close();
            fermerConnexion();

       } catch (SQLException e) {
           System.out.println("Erreur de connexion de la BD");
       }
       return inscriptions;
      }


    public Inscription selectInscriptionByMatricule(String matricule) {
        Inscription inscription= null;
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_BY_MATRICULE);
            statement.setString(1, matricule);
            ResultSet rs=executeSelect();
            if(rs.next()){
                inscription= new Inscription();
                inscription.setId(rs.getInt ("id"));
                inscription.setAnneeScolaire(rs.getString ("anneescolaire"));
                Etudiant etudiant= new Etudiant();
                etudiant.setMatricule(rs.getString ("matricule"));
                 etudiant.setNomcomplet(rs.getString("nomComplet"));
                 etudiant.setTuteur(rs.getString("tuteur"));
                 inscription.setEtudiant(etudiant);
                }
                statement.close();
                rs.close();
                conn.close();
            }catch (SQLException e) {
                System.out.println("Erreur de connexion à la BD");
            }
            return inscription;

}
}
