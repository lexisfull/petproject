package com.example.petproject.factory;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.dto.PersonDTO;
import com.example.petproject.dto.ProductDTO;
import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Eating;
import com.example.petproject.model.Executor;
import com.example.petproject.model.Measurments;
import com.example.petproject.model.Person;
import com.example.petproject.model.Product;
import com.example.petproject.model.Recommendation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestObjectFactory {
    public static AnalysisDTO buildAnalysisDTO(){
        return AnalysisDTO.builder()
                .id(1L)
                .personId(1L)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();
    }

    public static List<Analysis> buildListAnalysis(){
        Person person1 = buildPerson();
        person1.setId(1L);
        Analysis analysis = Analysis.builder()
                .id(1L)
                .person(person1)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();
        Analysis analysis2 = Analysis.builder()
                .id(2L)
                .person(person1)
                .resultAnalyses("analysis2")
                .subscribedOn(LocalDate.of(2024, 3, 3))
                .build();
        List<Analysis> analysisList = new ArrayList<>();
        analysisList.add(analysis);
        analysisList.add(analysis2);
        return analysisList;
    }

    public static Analysis buildAnalysis(){
        Person person = buildPerson();
        return Analysis.builder()
                .id(1L)
                .person(person)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();

    }

    public static Person buildPerson(){
        return Person.builder()
                .id(1L)
                .name("Vova")
                .build();
    }

    public static Eating buildEating(){
        Person person = buildPerson();
        return Eating.builder()
                .id(1L)
                .person(person)
                .reasonEating("захотелось")
                .build();
    }

    public static List<Eating> buildListEating(){
        Eating eating1 = buildEating();
        Eating eating2 = buildEating();
        eating2.setId(2L);
        List<Eating> eatingList = new ArrayList<>();
        eatingList.add(eating1);
        eatingList.add(eating2);
        return eatingList;
    }


    public static EatingDTO buildEatingDTO(){
        return EatingDTO.builder()
                .id(1L)
                .personId(1L)
                .reasonEating("захотелось")
                .build();
    }

    public static List<EatingDTO> buildListEatingDTO(){
        EatingDTO eatingDTO1 = buildEatingDTO();
        EatingDTO eatingDTO2 = buildEatingDTO();
        eatingDTO2.setId(2L);
        eatingDTO2.setPersonId(1L);
        List<EatingDTO> eatingDTOList = new ArrayList<>();
        eatingDTOList.add(eatingDTO1);
        eatingDTOList.add(eatingDTO2);
        return eatingDTOList;
    }

    public static ExecutorDTO buildExecutorDTO(){

        return ExecutorDTO.builder()
                .id(1L)
                .age(35)
                .name("Masha")
                .experience(5)
                .build();

    }

    public static List<ExecutorDTO> buildListExecutorDTO(){

        ExecutorDTO executorDTO1 = buildExecutorDTO();
        ExecutorDTO executorDTO2 = buildExecutorDTO();
        executorDTO2.setId(2L);
        executorDTO2.setName("Sasha");
        executorDTO2.setAge(30);
        executorDTO2.setExperience(4);
        List<ExecutorDTO> executorDTOList = new ArrayList<>();
        executorDTOList.add(executorDTO1);
        executorDTOList.add(executorDTO2);

        return executorDTOList;
    }

    public static Executor buildExecutor(){

        return Executor.builder()
                .id(1L)
                .age(35)
                .name("Masha")
                .experience(5)
                .build();

    }

    public static List<Executor> buildListExecutor(){

        Executor executor1 = buildExecutor();
        Executor executor2 = buildExecutor();
        executor2.setId(2L);
        executor2.setName("Sasha");
        executor2.setAge(30);
        executor2.setExperience(4);
        List<Executor> executorList = new ArrayList<>();
        executorList.add(executor1);
        executorList.add(executor2);

        return executorList;
    }


    public static MeasurmentsDTO buildMeasurmentsDTO(){
        return MeasurmentsDTO.builder()
                .id(1L)
                .height(175)
                .weight(80)
                .build();
    }

    public static Measurments buildMeasurments(){
        return Measurments.builder()
                .id(1L)
                .height(175)
                .weight(80)
                .build();
    }

    public static List<MeasurmentsDTO> buildListMeasurmentsDTO(){
        MeasurmentsDTO measurmentsDTO1 = buildMeasurmentsDTO();
        MeasurmentsDTO measurmentsDTO2 = buildMeasurmentsDTO();
        measurmentsDTO2.setId(2L);
        measurmentsDTO2.setHeight(170);
        measurmentsDTO2.setWeight(95);

        List<MeasurmentsDTO> measurmentsDTOList = new ArrayList<>(){{
            add(measurmentsDTO1);
            add(measurmentsDTO2);
        }};

        return measurmentsDTOList;
    }

    public static List<Measurments> buildListMeasurments(){
        Measurments measurments1 = buildMeasurments();
        Measurments measurments2 = buildMeasurments();
        measurments2.setId(2L);
        measurments2.setHeight(170);
        measurments2.setWeight(95);

        List<Measurments> measurmentsList = new ArrayList<>(){{
            add(measurments1);
            add(measurments2);
        }};

        return measurmentsList;
    }


    public static PersonDTO buildPersonDTO(){
        return PersonDTO.builder()
                        .id(1L)
                        .name("Vova")
                        .age(35)
                        .build();
    }



    public static List<PersonDTO> buildListPersonDTO(){
        PersonDTO personDTO1 = buildPersonDTO();
        PersonDTO personDTO2 = buildPersonDTO();
        personDTO2.setId(2L);
        personDTO2.setName("Sasha");
        List<PersonDTO> personDTOList = new ArrayList<>(){{
           add(personDTO1);
           add(personDTO2);
        }};
        return personDTOList;
    }

    public static List<Person> buildListPerson(){
        Person person1 = buildPerson();
        Person person2 = buildPerson();
        person1.setId(2L);
        person2.setName("Sasha");
        List<Person> personList = new ArrayList<>(){{
            add(person1);
            add(person2);
        }};
        return personList;
    }

    public static ProductDTO buildProductDTO(){
        return ProductDTO.builder()
                .id(1L)
                .name("рис")
                .fat(7.2)
                .protein(17d)
                .carbohydrates(72d)
                .build();
    }

    public static Product buildProduct(){
        return Product.builder()
                .id(1L)
                .name("рис")
                .fat(7.2)
                .protein(17d)
                .carbohydrates(72d)
                .build();
    }

    public static List<ProductDTO> buildListProductDTO(){
        ProductDTO productDTO1 = buildProductDTO();
        ProductDTO productDTO2 = buildProductDTO();
        productDTO2.setId(2L);
        productDTO2.setFat(1D);
        productDTO2.setName("греча");
        List<ProductDTO> productDTOList = new ArrayList<>(){{
            add(productDTO1);
            add(productDTO2);
        }};
        return productDTOList;
    }

    public static List<Product> buildListProduct(){
        Product product1 = buildProduct();
        Product product2 = buildProduct();
        product2.setId(2L);
        product2.setFat(1D);
        product2.setName("греча");
        List<Product> productList = new ArrayList<>(){{
            add(product1);
            add(product2);
        }};
        return productList;
    }


    public static RecommendationDTO buildRecommendationDTO(){
        return RecommendationDTO.builder()
                .id(1L)
                .personId(1L)
                .recommendation("commit")
                .build();
    }

    public static Recommendation buildRecommendation(){
        return Recommendation.builder()
                .id(1L)
                .recommendation("commit")
                .build();
    }


    public static List<RecommendationDTO> buildListRecommendationDTO(){
        RecommendationDTO recommendationDTO1 = buildRecommendationDTO();
        RecommendationDTO recommendationDTO2 = buildRecommendationDTO();
        recommendationDTO2.setId(2L);
        recommendationDTO2.setRecommendation("commit2");
        return new ArrayList<>(){{
            add(recommendationDTO1);
            add(recommendationDTO2);
        }};
    }

    public static List<Recommendation> buildListRecommendation(){
        Recommendation recommendation1 = buildRecommendation();
        Recommendation recommendation2 = buildRecommendation();
        recommendation2.setId(2L);
        recommendation2.setRecommendation("commit2");
        return new ArrayList<Recommendation>(){{
           add(recommendation1);
           add(recommendation2);
        }};
    }




}
