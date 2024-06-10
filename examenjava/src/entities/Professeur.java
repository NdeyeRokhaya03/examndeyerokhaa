package entities;

import java.util.List;

public class Professeur {
    private int id;
    private String nomComplet;
    private String grade;
    private int Nci;

    


List<ProfesseurClasse> professeurClasses;
    public List<ProfesseurClasse> getProfesseurClasses() {
    return professeurClasses;
}

public void setProfesseurClasses(List<ProfesseurClasse> professeurClasses) {
    this.professeurClasses = professeurClasses;
}

    public Professeur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getNci() {
        return Nci;
    }

    public void setNci(int nci) {
        Nci = nci;
    }
}
