//package com.example.petproject.controller;
//
//import com.example.petproject.dao.PersonRepository;
//import com.example.petproject.kafka.KafkaProducer;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@AllArgsConstructor
//@RestController
//public class KafkaController {
//
//    private final KafkaProducer kafkaProducer;
//
//    private final PersonRepository personRepository;
//
//    @PostMapping("/kafka/send")
//    public String send(@RequestParam Long id) {
//
//        var person = personRepository.findById(id).orElseThrow();
//        kafkaProducer.sendMessage(person.toString());
//
//        return "Success";
//    }
//
//}
