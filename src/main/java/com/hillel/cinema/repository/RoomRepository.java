package com.hillel.cinema.repository;

import com.hillel.cinema.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Integer, Room> {
}
