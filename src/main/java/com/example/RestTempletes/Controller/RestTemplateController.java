package com.example.RestTempletes.Controller;


import com.example.RestTempletes.Model.TemplateModel;
import com.example.RestTempletes.Service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/template")
public class RestTemplateController {

    @Autowired
    TemplateService templateService;

    @GetMapping("")
    public ResponseEntity<List<TemplateModel>> getAll() {
        return ResponseEntity.ok(templateService.fetchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(templateService.fetchById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody TemplateModel templateModel) {
        templateService.save(templateModel);
        return ResponseEntity.ok("Template Added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        templateService.delete(id);
        return ResponseEntity.ok("Todo Delete");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateData(@PathVariable Long id, @RequestBody TemplateModel data) {
        // Update the stored data with the new data
        TemplateModel update = templateService.update(id, data);
        return ResponseEntity.ok(update);
    }
}
