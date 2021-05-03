package ua.nure.nizheholtsev.lab2.dao;

import ua.nure.nizheholtsev.lab2.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionDAO {
    List<Position> getPositions() throws SQLException;
}
