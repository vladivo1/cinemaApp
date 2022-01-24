package com.hillel.cinema.repository;

import com.hillel.cinema.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    public Room getRoomByRoomNumber(int roomNumber);
}
