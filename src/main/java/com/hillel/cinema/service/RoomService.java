package com.hillel.cinema.service;

import com.hillel.cinema.exception.EntityNotFoundException;
import com.hillel.cinema.model.Room;
import com.hillel.cinema.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    public RoomService (RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);

    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) throws EntityNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Зал с id " + id + " не найден"));
    }

    public Room getRoomByRoomNumber(int roomNumber) throws EntityNotFoundException {
        Room room = roomRepository.getRoomByRoomNumber(roomNumber);
        if (room == null)
            throw new EntityNotFoundException("Зала с таким номером не существует!");
        return room;
    }

    public Room updateRoom(Long id, Room room) throws EntityNotFoundException {
        return roomRepository.findById(id)
                .map(entity -> {

                    entity.setRoomNumber(room.getRoomNumber());
                    entity.setCapacity(room.getCapacity());
                    entity.setDescription(room.getDescription());
                    return roomRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Зал с id " + id + " не найден"));

    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
