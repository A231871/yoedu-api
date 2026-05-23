package org.example.day1.service;

import org.example.day1.domain.entity.Room;
import org.example.day1.dto.room.RoomResponse;
import org.example.day1.dto.room.RoomUpsertResponse;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomResponse> findAll();
    Optional<RoomResponse> findById(Long id);
    RoomResponse save(RoomUpsertResponse req);
    RoomResponse save(long id, RoomUpsertResponse req);
}
