package edu.eci.cvds.proyect.booking.persistency.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.cvds.proyect.booking.persistency.dto.GroupDto;
import edu.eci.cvds.proyect.booking.persistency.entity.Group;
import edu.eci.cvds.proyect.booking.persistency.service.GroupService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Group")
public class GroupController {
    
    private GroupService groupService;
    private static final String ERROR_KEY = "Error";
    private static final String MESSAGE_KEY = "Message";
    private static final Logger logger = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAll() {
        try {
            return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = (e.getCause() != null) ? e.getCause().toString() : e.getMessage();
            logger.error("Error al obtener el grupo: {}", errorMessage, e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOne(@PathVariable("userId") Integer userId) {
        try {
            return new ResponseEntity<>(groupService.getOne(userId), HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "Error al obtener el grupo con usuario ID " + userId;
            logger.error("{}: {}", errorMessage, e.getMessage(), e);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put(ERROR_KEY, errorMessage);
            errorResponse.put("details", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }


    @PostMapping 
    public ResponseEntity<Object> save(@RequestBody GroupDto groupDto) {
        try {
            Group savedGroup = groupService.save(groupDto);
            return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMessage = (e.getCause() != null) ? e.getCause().toString() : e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put(ERROR_KEY, "Error al guardar el grupo");
            errorResponse.put(MESSAGE_KEY, errorMessage);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody GroupDto groupDto) {
        try {
            return new ResponseEntity<>(groupService.update(id, groupDto), HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = (e.getCause() != null) ? e.getCause().toString() : e.getMessage();
            logger.error("Error al actualizar grupo con ID {}: {}", id, errorMessage, e);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put(ERROR_KEY, "Error al actualizar el grupo");
            errorResponse.put(MESSAGE_KEY, errorMessage);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        try {
            groupService.delete(id);
            return new ResponseEntity<>(Collections.singletonMap("message", "grupo eliminada correctamente"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = (e.getCause() != null) ? e.getCause().toString() : e.getMessage();
            logger.error("Error al eliminar grupo con ID {}: {}", id, errorMessage, e);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put(ERROR_KEY, "Error al eliminar el grupo");
            errorResponse.put(MESSAGE_KEY, errorMessage);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
                    
    }
}
