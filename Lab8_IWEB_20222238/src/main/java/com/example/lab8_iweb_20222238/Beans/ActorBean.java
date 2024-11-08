package com.example.lab8_iweb_20222238.Beans;

public class ActorBean {
    private int idActor;
    private String nombre;
    private String apellido;
    private int anoNacimiento;
    private boolean premioOscar;

    public ActorBean() {
    }

    public int getIdActor() {
        return this.idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnoNacimiento() {
        return this.anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public boolean isPremioOscar() {
        return this.premioOscar;
    }

    public void setPremioOscar(boolean premioOscar) {
        this.premioOscar = premioOscar;
    }
}
