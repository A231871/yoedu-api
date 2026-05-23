package org.example.day1.service.impl;

import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;
import org.example.day1.domain.entity.Room;
import org.example.day1.dto.room.RoomResponse;
import org.example.day1.dto.room.RoomUpsertResponse;
import org.example.day1.repository.RoomRepository;
import org.example.day1.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapper mapper;

    private RoomResponse map(Room room){
        return mapper.map(room, RoomResponse.class);
    }

    public List<RoomResponse> findAll() {
        return roomRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    public Optional<RoomResponse> findById(Long id) {
        return roomRepository.findById(id)
                .map(this::map);
    }

    public RoomResponse save(RoomUpsertResponse req) {
        Room room = mapper.map(req, Room.class);
        return map(roomRepository.save(room));
    }

    public RoomResponse save(long id, RoomUpsertResponse req) {
        Room room = mapper.map(req, Room.class);
        room.setId(id);
        return map(roomRepository.save(room));
    }
}
