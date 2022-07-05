package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.service.DentistService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {


    @Autowired
    DentistService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Dentist d) throws BadRequestException {
        ResponseEntity<String> response = null;

        if(service.save(d) != null) {
            response = ResponseEntity.ok("Dentist created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Dentist> getAll() throws BadRequestException {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Dentist getById(@PathVariable Long id) throws BadRequestException {
        return service.getById(id);
    }
    
    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long id) throws BadRequestException {
         return service.delete(id);
    }

    @PutMapping
    public String update(@RequestBody Dentist d) throws BadRequestException {
        return service.updateDentist(d);
    }

}
