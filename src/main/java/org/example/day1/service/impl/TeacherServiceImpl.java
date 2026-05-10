package org.example.day1.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.day1.common.exception.NotFoundException;
import org.example.day1.domain.entity.Teacher;
import org.example.day1.dto.teacher.TeacherResponse;
import org.example.day1.dto.teacher.TeacherUpsertRequest;
import org.example.day1.repository.TeacherRepository;
import org.example.day1.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    public List<TeacherResponse> findAll() {
        return teacherRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    public Optional<TeacherResponse> findById(Long id) {
        return teacherRepository.findById(id)
                .map(this::map);
    }

    public TeacherResponse save(TeacherUpsertRequest req) {
        Teacher teacher = modelMapper.map(req, Teacher.class);
        return map(teacherRepository.save(teacher));
    }

    public TeacherResponse update(Long id, TeacherUpsertRequest req) {
        Teacher updateTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Teacher not found with id: " + id));
        updateTeacher.setTeacherCode(req.getTeacherCode());
        updateTeacher.setFullName(req.getFullName());
        updateTeacher.setPhone(req.getPhone());
        updateTeacher.setEmail(req.getEmail());
        updateTeacher.setTeacherRole(req.getTeacherRole());
        updateTeacher.setCccdImageUrl(req.getCccdImageUrl());
        updateTeacher.setIsActive(req.getIsActive());
        return map(teacherRepository.save(updateTeacher));
    }

    public void delete(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new NotFoundException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    public TeacherResponse map(Teacher teacher) {
        return modelMapper.map(teacher, TeacherResponse.class);
    }
}
