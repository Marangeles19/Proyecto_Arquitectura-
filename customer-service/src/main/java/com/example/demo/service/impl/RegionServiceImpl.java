package com.example.demo.service.impl;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;
import com.example.demo.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionRepository regionRepository;
    @Override
    public Region save(Region t) {
        return regionRepository.save(t);
    }

    @Override
    public Region update(Region t) {
        return regionRepository.save(t);
    }

    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).orElse(new Region());
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        regionRepository.deleteById(id);
    }
}
