package com.domain.deepcode;

public class ProfessorJava {

    ProfessorJava professor = new ProfessorJava(
            "Mirella",
            "98098234894");

    private int id;
    private String name;
    private String CPF;
    private String telefone;

    public ProfessorJava(String name, String CPF) {
        this.name = name;
        this.CPF = CPF;
    }

    public ProfessorJava(int id, String name, String CPF, String telefone) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
