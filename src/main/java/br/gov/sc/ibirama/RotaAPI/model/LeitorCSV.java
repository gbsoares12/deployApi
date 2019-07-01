/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sc.ibirama.RotaAPI.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel Soares
 */
public class LeitorCSV {

    public boolean lerArquivo(String url) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url), "UTF-8"));
            String linha;
            String dados[];
            ArrayList<String[]> dadosCSV = new ArrayList<>();
            while ((linha = br.readLine()) != null) {
                dados = linha.split(";");
                dadosCSV.add(dados);
            }
            dadosCSV.remove(0); // Remove o cabeçalho
            for (String[] linhas : dadosCSV) {
                Rota rotaNova = new Rota();
//                rotaNova.setId(Long.parseLong(linhas[0]));
                rotaNova.setBairro(linhas[1]);
                rotaNova.setNome_rua(linhas[2]);
                rotaNova.setSegunda_manha(linhas[3]);
                rotaNova.setSegunda_tarde(linhas[4]);
                rotaNova.setTerca_manha(linhas[5]);
                rotaNova.setTerca_tarde(linhas[6]);
                rotaNova.setQuarta_manha(linhas[7]);
                rotaNova.setQuarta_tarde(linhas[8]);
                rotaNova.setQuinta_manha(linhas[9]);
                rotaNova.setQuinta_tarde(linhas[10]);
                rotaNova.setSexta_manha(linhas[11]);
                rotaNova.setSexta_tarde(linhas[12]);
                rotaNova.setSabado_manha(linhas[13]);
                rotaNova.setSabado_tarde(linhas[14]);
                rotaNova.setTipo_coleta(linhas[15]);
                salvarRotasNovas(rotaNova);
            }
            br.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void salvarRotasNovas(Rota novaRota) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.gov.sc.ibirama_RotaAPI_jar_0.0.1-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(novaRota);
            em.getTransaction().commit();
            System.out.println(novaRota.toString());
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
