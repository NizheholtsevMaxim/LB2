package ua.nure.nizheholtsev.lab2.service.impl;

import ua.nure.nizheholtsev.lab2.dao.PositionDAO;
import ua.nure.nizheholtsev.lab2.dao.impl.PositionDAOMySql;
import ua.nure.nizheholtsev.lab2.entity.Position;
import ua.nure.nizheholtsev.lab2.service.PositionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PositionServiceImpl implements PositionService {
    private final PositionDAO positionDAO;

    public PositionServiceImpl(Connection connection) {
        this.positionDAO = new PositionDAOMySql(connection);
    }

    @Override
    public List<Position> getPositions() throws SQLException {
        return positionDAO.getPositions();
    }

}
