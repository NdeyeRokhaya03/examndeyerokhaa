package repositories;

import java.sql.SQLException;

import entities.ProfesseurClasse;

public class ProfesseurClasseRepository extends Database{
    private final String SQL_INSERT="INSERT INTO `professeur_classe (id_classe, id_professeur) VALUES (?, ?, ?);";
    public void insert(ProfesseurClasse  professeurClasse){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT);
             statement.setInt(1,professeurClasse.getClasse().getId());
             statement.setInt(2,professeurClasse.getProfesseur().getId());
             executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 
}

    

