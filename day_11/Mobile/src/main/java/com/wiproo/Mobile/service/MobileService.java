package com.wiproo.Mobile.service;

import com.wiproo.Mobile.dto.*;
import com.wiproo.Mobile.entity.*;
import com.wiproo.Mobile.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MobileService {

    private final MobileRepository repo;

    public MobileService(MobileRepository repo) {
        this.repo = repo;
    }

    // create
    public Mobile create(Mobile dto) {
        MobileEntity entity = dtoToEntity(dto);
        entity.setId(null); 
        MobileEntity saved = repo.save(entity);
        return entityToDto(saved);
    }

    // list all
    public List<Mobile> findAll() {
        return repo.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    // find by id
    public Optional<Mobile> findById(Integer id) {
        return repo.findById(id).map(this::entityToDto);
    }

    // update (body must include id)
    public Optional<Mobile> update(Mobile dto) {
        Integer id = dto.getId();
        if (id == null || !repo.existsById(id)) {
            return Optional.empty();
        }
        MobileEntity e = dtoToEntity(dto);
        e.setId(id);
        MobileEntity saved = repo.save(e);
        return Optional.of(entityToDto(saved));
    }

    // delete
    public Optional<Mobile> delete(Integer id) {
        Optional<MobileEntity> found = repo.findById(id);
        found.ifPresent(e -> repo.deleteById(id));
        return found.map(this::entityToDto);
    }

    // helpers
    private MobileEntity dtoToEntity(Mobile dto) {
        return new MobileEntity(dto.getId(), dto.getMake(), dto.getModelNumber(), dto.getPrice());
    }

    private Mobile entityToDto(MobileEntity e) {
        return new Mobile(e.getId(), e.getMake(), e.getModelNumber(), e.getPrice());
    }
}
