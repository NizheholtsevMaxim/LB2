package ua.nure.nizheholtsev.lab2.dao.impl;

import ua.nure.nizheholtsev.lab2.dao.PositionDAO;
import ua.nure.nizheholtsev.lab2.entity.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAOMySql implements PositionDAO {

    private static final String SQL_SELECT_POSITIONS = "SELECT * FROM positions";
    private final Connection connection;
    public PositionDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Position> getPositions() throws SQLException {
        PreparedStatement prStatement = connection.prepareStatement(SQL_SELECT_POSITIONS);
        ResultSet rs = prStatement.executeQuery();
        List<Position> position = getPositionFromResultSet(rs);
        prStatement.close();
        return position;
    }
    private List<Position> getPositionFromResultSet(ResultSet rs) throws SQLException {
        List<Position> position = new ArrayList<>();
        while (rs.next()) {
            position.add(getPosition(rs));
        }
        return position;
    }

    private Position getPosition(ResultSet rs) throws SQLException {
        Position position = new Position();
        position.setId(rs.getInt("ID"));
        position.setName(rs.getString("Name"));
        position.setSalary(rs.getInt("Salary"));
        return position;
    }
}
