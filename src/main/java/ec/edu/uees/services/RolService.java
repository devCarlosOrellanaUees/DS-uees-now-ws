package ec.edu.uees.services;

import ec.edu.uees.entities.RolDTO;
import ec.edu.uees.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<RolDTO> findAllRoles(){
        return rolRepository.findAll();
    }
}
