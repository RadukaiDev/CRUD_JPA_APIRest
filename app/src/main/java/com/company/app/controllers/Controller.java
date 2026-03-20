package com.company.app.controllers;

import java.util.List;
import com.company.app.repositories.Repository;
import com.company.app.models.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class Controller {

    @Autowired
    private Repository repo;

    @GetMapping()
    public String index(){
        return "conectado";
    }

    @GetMapping("personas")
    public List<Persona> getPersonas(){
        return repo.findAll();
    }

    @PostMapping("grabar")
    public String post(@RequestBody Persona persona){
    repo.save(persona);
    return "persona grabada";
    }
        
    @PutMapping("editar/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona) {
        Persona updatePersona = repo.findById(id).get();
        updatePersona.setName(persona.getName());
        updatePersona.setPhone(persona.getPhone());
        repo.save(updatePersona);

        return "persona actualizada";
    }

    @DeleteMapping("eliminar/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "persona eliminada";
    }

}
