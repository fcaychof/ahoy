package com.ahoy.ccee.service;

import com.ahoy.ccee.dto.FileDto;
import com.ahoy.ccee.model.Agente;
import com.ahoy.ccee.model.File;
import com.ahoy.ccee.repository.AgenteRepository;
import com.ahoy.ccee.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    private final AgenteRepository agenteRepository;
    private final FileRepository fileRepository;

    public void saveAgente(Agente agente) {
        agenteRepository.save(agente);
    }

    public void saveFile(File file) {
        fileRepository.save(file);
    }

    public List<FileDto> findAll() {
        List<FileDto> fileDtoList = new ArrayList<>();
        fileRepository.findAll().forEach(w -> fileDtoList.add(FileDto.builder().id(w.getId()).name(w.getNameFile()).status(w.getStatus()).build()));
        return fileDtoList;
    }

}
