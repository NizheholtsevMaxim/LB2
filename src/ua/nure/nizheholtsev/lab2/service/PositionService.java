package ua.nure.nizheholtsev.lab2.service;

import ua.nure.nizheholtsev.lab2.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionService {
    List<Position> getPositions() throws SQLException;
}