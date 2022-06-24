package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/dentists")
public class DentistController {
    @Autowired
    DentistService service;

    @PostMapping("")
    public ResponseEntity<String> createDentist(@RequestBody Dentist d) {
        ResponseEntity<String> response = null;

        if(service.save(d) != null) {
            response = ResponseEntity.ok("Dentist created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Dentist> getDentist() {
        return service.getAll();
    }
}