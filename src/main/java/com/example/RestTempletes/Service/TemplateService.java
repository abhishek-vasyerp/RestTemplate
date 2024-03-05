package com.example.RestTempletes.Service;

import com.example.RestTempletes.Model.TemplateModel;

import java.util.List;

public interface TemplateService {


        List<TemplateModel> fetchAll();
        TemplateModel fetchById(Long id);
        void save(TemplateModel templateModel);
        void delete(Long id);
        TemplateModel update(Long id, TemplateModel model);

    }

