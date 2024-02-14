package com.example.demo.service;

import com.example.demo.entity.Region;

import java.util.List;

public interface IRegionService{
    Region save(Region t);
    Region update(Region t);
    Region findById(Long id);
    List<Region> findAll();
    void delete(Long id);
}