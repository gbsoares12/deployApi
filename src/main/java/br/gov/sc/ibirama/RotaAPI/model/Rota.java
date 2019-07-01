/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sc.ibirama.RotaAPI.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gabriel Soares
 */
@Entity
public class Rota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome_rua;
    private String segunda_manha;
    private String segunda_tarde;
    private String terca_manha;
    private String terca_tarde;
    private String quarta_manha;
    private String quarta_tarde;
    private String quinta_manha;
    private String quinta_tarde;
    private String sexta_manha;
    private String sexta_tarde;
    private String sabado_manha;
    private String sabado_tarde;
    private String bairro;
    private String tipo_coleta;

    public Rota() {
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_rua() {
        return nome_rua;
    }

    public void setNome_rua(String nome_rua) {
        this.nome_rua = nome_rua;
    }

    public String getSegunda_manha() {
        return segunda_manha;
    }

    public void setSegunda_manha(String segunda_manha) {
        this.segunda_manha = segunda_manha;
    }

    public String getSegunda_tarde() {
        return segunda_tarde;
    }

    public void setSegunda_tarde(String segunda_tarde) {
        this.segunda_tarde = segunda_tarde;
    }

    public String getTerca_manha() {
        return terca_manha;
    }

    public void setTerca_manha(String terca_manha) {
        this.terca_manha = terca_manha;
    }

    public String getTerca_tarde() {
        return terca_tarde;
    }

    public void setTerca_tarde(String terca_tarde) {
        this.terca_tarde = terca_tarde;
    }

    public String getQuarta_manha() {
        return quarta_manha;
    }

    public void setQuarta_manha(String quarta_manha) {
        this.quarta_manha = quarta_manha;
    }

    public String getQuarta_tarde() {
        return quarta_tarde;
    }

    public void setQuarta_tarde(String quarta_tarde) {
        this.quarta_tarde = quarta_tarde;
    }

    public String getQuinta_manha() {
        return quinta_manha;
    }

    public void setQuinta_manha(String quinta_manha) {
        this.quinta_manha = quinta_manha;
    }

    public String getQuinta_tarde() {
        return quinta_tarde;
    }

    public void setQuinta_tarde(String quinta_tarde) {
        this.quinta_tarde = quinta_tarde;
    }

    public String getSexta_manha() {
        return sexta_manha;
    }

    public void setSexta_manha(String sexta_manha) {
        this.sexta_manha = sexta_manha;
    }

    public String getSexta_tarde() {
        return sexta_tarde;
    }

    public void setSexta_tarde(String sexta_tarde) {
        this.sexta_tarde = sexta_tarde;
    }

    public String getSabado_manha() {
        return sabado_manha;
    }

    public void setSabado_manha(String sabado_manha) {
        this.sabado_manha = sabado_manha;
    }

    public String getSabado_tarde() {
        return sabado_tarde;
    }

    public void setSabado_tarde(String sabado_tarde) {
        this.sabado_tarde = sabado_tarde;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipo_coleta() {
        return tipo_coleta;
    }

    public void setTipo_coleta(String tipo_coleta) {
        this.tipo_coleta = tipo_coleta;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rota)) {
            return false;
        }
        Rota other = (Rota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rota{" + "id=" + id + ", nome_rua=" + nome_rua + ", segunda_manha=" + segunda_manha + ", segunda_tarde=" + segunda_tarde + ", terca_manha=" + terca_manha + ", terca_tarde=" + terca_tarde + ", quarta_manha=" + quarta_manha + ", quarta_tarde=" + quarta_tarde + ", quinta_manha=" + quinta_manha + ", quinta_tarde=" + quinta_tarde + ", sexta_manha=" + sexta_manha + ", sexta_tarde=" + sexta_tarde + ", sabado_manha=" + sabado_manha + ", sabado_tarde=" + sabado_tarde + ", bairro=" + bairro + ", tipo_coleta=" + tipo_coleta + '}';
    }

}
