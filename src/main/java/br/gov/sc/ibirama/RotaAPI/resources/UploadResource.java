/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sc.ibirama.RotaAPI.resources;

import br.gov.sc.ibirama.RotaAPI.model.LeitorCSV;
import br.gov.sc.ibirama.RotaAPI.model.User;
import br.gov.sc.ibirama.RotaAPI.repositorio.RotaRepositorio;
import br.gov.sc.ibirama.RotaAPI.responseUpload.UploadFileResponse;
import br.gov.sc.ibirama.RotaAPI.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Gabriel Soares
 */
@CrossOrigin()
@RestController
@RequestMapping("/upload")
public class UploadResource {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private RotaRepositorio rr;

    @GetMapping(produces = "application/json")
    public ResponseEntity<User> validateLogin() {
        return new ResponseEntity<>(
                new User("User successfully authenticated"),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) {
        System.out.println("Entrou, file: " + file);
        String fileName = fileStorageService.storeFile(file);
        LeitorCSV leitor = new LeitorCSV();
        if(!rr.findAll().isEmpty()){
                rr.deleteAllInBatch();
        }
        leitor.lerArquivo("./uploads/" + fileName);
        return new ResponseEntity<>(
                new UploadFileResponse(fileName, file.getContentType(), file.getSize()),
                HttpStatus.OK);
    }
}
