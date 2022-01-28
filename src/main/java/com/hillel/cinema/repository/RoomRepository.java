package com.hillel.cinema.repository;

import com.hillel.cinema.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room getRoomByRoomNumber(String roomNumber);
}
