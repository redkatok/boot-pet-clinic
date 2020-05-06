package petclinic.services;

import petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(Long id);
    Owner save(Long id);
    Owner findById(Long id);
    Set<Owner> findAll(Long id);
}
