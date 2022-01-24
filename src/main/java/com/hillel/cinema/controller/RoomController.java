package com.hillel.cinema.controller;

import com.hillel.cinema.exception.EntityNotFoundException;
import com.hillel.cinema.model.Room;
import com.hillel.cinema.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;
    public RoomController (RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public Room saveRoom (@RequestBody Room room) {
        return roomService.saveRoom(room);

    }

    @GetMapping("/rooms/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room getRoomById(@PathVariable Long id) throws EntityNotFoundException {
        return roomService.getRoomById(id);

    }

    @GetMapping("/rooms/{room_number}")
    @ResponseStatus(HttpStatus.OK)
    public Room getRoomByRoomNumber(@PathVariable int room_number) throws EntityNotFoundException {
        return roomService.getRoomByRoomNumber(room_number);
    }

    @GetMapping("/rooms")
    @ResponseStatus(HttpStatus.OK)
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();

    }

    @PutMapping("/rooms/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room updateRoomById(@PathVariable("id") Long id, @RequestBody Room room) throws EntityNotFoundException {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/rooms/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteRoomById(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok("зал с id" + id + " удален!");
    }
}
