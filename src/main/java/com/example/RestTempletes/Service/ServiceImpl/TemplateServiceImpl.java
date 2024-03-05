package com.example.RestTempletes.Service.ServiceImpl;


import com.example.RestTempletes.Model.TemplateModel;
import com.example.RestTempletes.Service.TemplateService;
import com.example.RestTempletes.repository.TemplateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateRepo templateRepo;


    @Override
    public List<TemplateModel> fetchAll() {
        return templateRepo.findAll();
    }

    @Override
    public TemplateModel fetchById(Long id) {
        return templateRepo.findById(id).get();
    }

    @Override
    public void save(TemplateModel templateModel) {
        templateRepo.save(templateModel);
    }

    @Override
    public void delete(Long id) {
        templateRepo.deleteById(id);
    }

    @Override
    public TemplateModel update( Long id,TemplateModel model ) {
        TemplateModel edit = templateRepo.findById(id).get();

        if (model.getStatus() != null) {
            edit.setStatus(model.getStatus());
        }
        if (model.getTitle() != null) {
            edit.setTitle(model.getTitle());
        }
        TemplateModel save = templateRepo.save(edit);

        return save;
    }

}
