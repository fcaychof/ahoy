package com.ahoy.ccee.controller;

import com.ahoy.ccee.dto.Agentes;
import com.ahoy.ccee.model.Agente;
import com.ahoy.ccee.model.File;
import com.ahoy.ccee.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import java.time.LocalDateTime;

@Controller
@CrossOrigin()
@RequiredArgsConstructor
public class AgenteController {

    private final FileService service;

    @PostMapping("/agente/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try {

            byte[] bytes = file.getBytes();
            JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Agentes agenteList = (Agentes) JAXBIntrospector.getValue(unmarshaller.unmarshal(file.getInputStream()));
            System.out.println("Lista de Agentes ");
            service.saveFile(File.builder().nameFile(file.getOriginalFilename() +"_"+ LocalDateTime.now()).status("OK").build());
            agenteList.getAgente().forEach(p -> {
                service.saveAgente(Agente.builder().codigo(p.getCodigo()).nameFile(file.getName()).build());
                System.out.println("Codigo de Agente: " + p.getCodigo());
            });
            return ResponseEntity.status(HttpStatus.OK).body("Files uploaded successfully: " + file.getOriginalFilename());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Exception occurred for: " + file.getOriginalFilename() + "!");
        }
    }
}
