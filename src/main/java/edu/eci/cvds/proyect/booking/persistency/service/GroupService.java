package edu.eci.cvds.proyect.booking.persistency.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.cvds.proyect.booking.persistency.dto.GroupDto;
import edu.eci.cvds.proyect.booking.persistency.entity.Group;
import edu.eci.cvds.proyect.booking.persistency.repository.GroupRepository;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private static final String Group_ID_NULL = "El ID de  grupo no puede ser null";
    private static final String Group_ID_NOT_FOUND = "grupo no encontrado con ID: ";

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAll(){
        return groupRepository.findAll();
    }

    public Group getOne(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException(Group_ID_NULL);
        }
        return groupRepository.findById(id).orElseThrow(() -> new RuntimeException(Group_ID_NOT_FOUND + id));
    }
    

    public Group save(GroupDto groupDto){
        if (groupDto == null) {
            throw new RuntimeException("El grupo no puede ser nulo");
        }
        Integer id = autoIncrement();
        Group group = new Group(id,groupDto.getUserId(),groupDto.getName(),groupDto.getNumber());
        return groupRepository.save(group);
    }

    public Group update(Integer id, GroupDto groupDto){
        if (id == null) {
            throw new IllegalArgumentException(Group_ID_NULL);
        }
        
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException(Group_ID_NOT_FOUND + id));
        group.setUserId(groupDto.getUserId());
        group.setName(groupDto.getName());
        group.setNumber(groupDto.getNumber());
        return groupRepository.save(group);
    }

    public Group delete(Integer id){
        if (id == null) {
            throw new IllegalArgumentException(Group_ID_NULL);
        }
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException(Group_ID_NOT_FOUND + id));
        groupRepository.delete(group);
        return group;
    }

    //private methods
    private Integer autoIncrement() {
        List<Group> groups = groupRepository.findAll();
        return groups.isEmpty() ? 1 : groups.stream()
                .max(Comparator.comparing(Group::getId))
                .orElseThrow(() -> new RuntimeException("No se pudo determinar el siguiente ID"))
                .getId() + 1;
    }
    
}
