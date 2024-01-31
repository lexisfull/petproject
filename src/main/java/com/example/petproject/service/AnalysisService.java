package com.example.petproject.service;

import com.example.petproject.dao.AnalysisRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;
import com.example.petproject.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisRepository analysisRepository;
    private final ModelMapper modelMapper;

    public List<AnalysisDTO> getAllAnalysis(){
        return analysisRepository.findAll().stream()
                .map(this::convertAnalysisDTO)
                .collect(Collectors.toList());
    }

    public List<AnalysisDTO> getAllAnalysisPerson(Person personId){
        return analysisRepository.findByPersonId(personId).stream()
                .map(this::convertAnalysisDTO)
                .collect(Collectors.toList());
    }

//    public List<AnalysisDTO> getAllAnalysisPerson(String name){
//        return analysisRepository.findByPersonIdName(name).stream()
//                .map(this::convertAnalysisDTO)
//                .collect(Collectors.toList());
//    }

    public void saveAnalysis(AnalysisDTO analysisDTO){
        analysisRepository.save(convertAnalysis(analysisDTO));
    }

    private AnalysisDTO convertAnalysisDTO(Analysis analysis){
        return modelMapper.map(analysis, AnalysisDTO.class);
    }

    private Analysis convertAnalysis(AnalysisDTO analysisDTO){
        return modelMapper.map(analysisDTO, Analysis.class);
    }

    public void deleteAnalysis(Long id){
        analysisRepository.deleteById(id);
    }

}
