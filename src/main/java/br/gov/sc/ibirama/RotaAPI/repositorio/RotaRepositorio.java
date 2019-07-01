/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sc.ibirama.RotaAPI.repositorio;

import br.gov.sc.ibirama.RotaAPI.model.Rota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Gabriel Soares
 */
public interface RotaRepositorio extends JpaRepository<Rota, Long> {

    @Query(value = "SELECT r.* FROM Rota r WHERE r.nome_rua ~* :rua", nativeQuery = true)
    List<Rota> buscarRotaPelaRua(@Param("rua") String rua);
    
    @Query(value = "SELECT r.* FROM Rota r WHERE r.bairro ~* :bairro", nativeQuery = true)
    List<Rota> buscarRotaPeloBairro(@Param("bairro") String bairro);
    
    @Query(value = "SELECT r.* FROM Rota r WHERE r.bairro ~* :bairro AND r.nome_rua ~* :rua", nativeQuery = true)
    List<Rota> buscarRotaPeloBairroERua(@Param("bairro") String bairro, @Param("rua") String rua);
    
    @Query(value = "SELECT r.* FROM Rota r WHERE r.bairro ~* :bairro AND r.nome_rua ~* :rua AND r.tipo_coleta ~* :coleta", nativeQuery = true)
    List<Rota> buscarRotaPeloBairroRuaColeta(@Param("bairro") String bairro, @Param("rua") String rua, @Param("coleta") String coleta);
    
    @Query(value = "SELECT r.* FROM Rota r WHERE r.bairro ~* :bairro AND r.tipo_coleta ~* :coleta", nativeQuery = true)
    List<Rota> buscarRotaPeloBairroEColeta(@Param("bairro") String bairro, @Param("coleta") String coleta);
    
    @Query(value = "SELECT r.* FROM Rota r WHERE r.nome_rua ~* :rua AND r.tipo_coleta ~* :coleta", nativeQuery = true)
    List<Rota> buscarRotaPelaRuaEColeta(@Param("rua") String rua, @Param("coleta") String coleta);
    
    @Query(value = "SELECT r.* FROM Rota r WHERE r.tipo_coleta ~* :coleta", nativeQuery = true)
    List<Rota> buscarRotaPelaColeta(@Param("coleta") String coleta);

    
}
