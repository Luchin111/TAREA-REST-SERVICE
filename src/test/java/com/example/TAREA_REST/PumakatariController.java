package com.example.TAREA_REST;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class PumakatariController {

    private final PumakatariRepository repository;


    PumakatariController(PumakatariRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    @GetMapping("/Pumakatari")
    List<Pumakatari> all() {
        return repository.findAll();
    }

/*
    @GetMapping("/Pumakatari/{id}")
    Resource<Pumakatari> one(@PathVariable Long id) {

        Pumakatari employee = repository.findById(id)
                .orElseThrow(() -> new PumakatariNotFoundException(id));

        return new Resource<>(employee,
                linkTo(methodOn(PumakatariController.class).one(id)).withSelfRel(),
                linkTo(methodOn(PumakatariController.class).all()).withRel("Pumakatari"));
    }*/
    @PostMapping("/Pumakatari")
    Pumakatari newEmployee(@RequestBody Pumakatari newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/Pumakatari/{id}")
    Pumakatari one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PumakatariNotFoundException(id));
    }

    @PutMapping("/Pumakatari/{id}")
    Pumakatari replaceEmployee(@RequestBody Pumakatari newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(pumakatari -> {
                    pumakatari.setPlaca(newEmployee.getPlaca());
                    pumakatari.setRuta(newEmployee.getRuta());
                    return repository.save(pumakatari);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/Pumakatari/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}