package com.example.petproject.controller.api;

import com.example.petproject.controller.AnalysisController;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.service.AnalysisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/analysis")
@RestController
@RequiredArgsConstructor
@Tag(name = "анализы", description = "методы для работы с анализами")
public class AnalysisAPI implements AnalysisController {

    private final AnalysisService analysisService;

    @Override
    public ResponseEntity<List<AnalysisDTO>> getAllAnalysis(){
        return new ResponseEntity<>(analysisService.getAllAnalysis(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<AnalysisDTO>> getAnalysisPerson(@PathVariable Long personId){
        return new ResponseEntity<>(analysisService.getAllAnalysisPerson(personId), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> addAnalysis(@RequestBody AnalysisDTO analysisDTO){
        analysisService.saveAnalysis(analysisDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteAnalysis(@PathVariable Long id){
        analysisService.deleteAnalysis(id);
        return ResponseEntity.ok().build();
    }

}
