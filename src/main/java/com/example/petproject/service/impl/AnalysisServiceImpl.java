package com.example.petproject.service.impl;

import com.example.petproject.dao.AnalysisRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.mapper.AnalysisMapper;
import com.example.petproject.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AnalysisServiceImpl implements AnalysisService{

    private final AnalysisRepository analysisRepository;

    private final PersonRepository personRepository;

    private final AnalysisMapper analysisMapper;


    @Override
    public List<AnalysisDTO> getAllAnalysis(){
        return analysisRepository.findAll().stream()
                .map(analysisMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnalysisDTO> getAllAnalysisPerson(Long personId){
        return analysisRepository.findAllByPersonId(personId).stream()
                .map(analysisMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAnalysis(AnalysisDTO analysisDTO){
        var analysis = analysisMapper.toAnalysis(analysisDTO);
        var person = personRepository.findById(analysisDTO.getPersonId()).orElseThrow();
        analysis.setPerson(person);
        analysisRepository.save(analysis);
    }

    @Override
    public void deleteAnalysis(Long id){
        analysisRepository.deleteById(id);
    }

}
