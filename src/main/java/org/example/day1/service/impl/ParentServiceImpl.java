package org.example.day1.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.day1.common.exception.NotFoundException;
import org.example.day1.domain.entity.Parent;
import org.example.day1.dto.parent.ParentResponse;
import org.example.day1.dto.parent.ParentUpsertRequest;
import org.example.day1.repository.ParentRepository;
import org.example.day1.service.ParentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ModelMapper modelMapper;

    public List<ParentResponse> findAll() {
        return parentRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    public Optional<ParentResponse> findById(Long id) {
        return parentRepository.findById(id)
                .map(this::map);
    }

    public ParentResponse save(ParentUpsertRequest req) {
        Parent parent = modelMapper.map(req, Parent.class);
        return map(parentRepository.save(parent));
    }

    public ParentResponse update(Long id, ParentUpsertRequest req) {
        Parent updateParent = parentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Parent not found with id: " + id));
        updateParent.setFullName(req.getFullName());
        updateParent.setPhone(req.getPhone());
        updateParent.setEmail(req.getEmail());
        updateParent.setAddress(req.getAddress());
        updateParent.setRelationship(req.getRelationship());
        updateParent.setGender(req.getGender());
        return map(parentRepository.save(updateParent));
    }

    public void delete(Long id) {
        if (!parentRepository.existsById(id)) {
            throw new NotFoundException("Parent not found with id: " + id);
        }
        parentRepository.deleteById(id);
    }

    public ParentResponse map(Parent parent) {
        return modelMapper.map(parent, ParentResponse.class);
    }
}
