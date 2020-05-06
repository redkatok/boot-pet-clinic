package petclinic.services;

import petclinic.model.Owner;
import petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Owner findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll(Long id);
}
