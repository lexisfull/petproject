package com.example.petproject.service;

import com.example.petproject.dao.AnalysisRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.mapper.AnalysisMapper;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisRepository analysisRepository;

    private final AnalysisMapper analysisMapper;

    public List<AnalysisDTO> getAllAnalysis(){
        return analysisRepository.findAll().stream()
                .map(analysisMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AnalysisDTO> getAllAnalysisPerson(Person personId){
        return analysisRepository.findByPersonId(personId).stream()
                .map(analysisMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void saveAnalysis(AnalysisDTO analysisDTO, Person id){
        var analysis = analysisMapper.toAnalysis(analysisDTO);
        analysis.setPersonId(id);
        analysisRepository.save(analysis);
    }

    public void deleteAnalysis(Long id){
        analysisRepository.deleteById(id);
    }

}
