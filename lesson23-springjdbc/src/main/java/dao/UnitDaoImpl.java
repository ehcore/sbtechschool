package dao;

import model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UnitDaoImpl implements UnitDao{
    private JdbcTemplate jdbcTemplate;

   // @Autowired
    public UnitDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Unit getUnitByName(String name){
        Unit unit = null;
        try {
            unit = jdbcTemplate.queryForObject(
                    "SELECT * FROM recipes.units WHERE name =?",
                    new UnitRowMapper(),
                    name);
            return unit;
        }catch (EmptyResultDataAccessException exc){
            return unit;
        }
    }

    @Override
    public List<Unit> getAllUnits(){
        List<Unit> list =
                jdbcTemplate.query(
                        "SELECT * FROM recipes.units",
                        new UnitRowMapper());
        return list;
    }

    @Override
    public boolean addUnit(String name){
        Unit unit = getUnitByName(name);
        if(unit != null){
            return false;
        }
        int i = jdbcTemplate.update(
                "INSERT INTO recipes.units(name) VALUES(?)",
                name);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUnitByName(String name){
        Unit unit = getUnitByName(name);
        if(unit == null){
            return false;
        }
        int i = jdbcTemplate.update(
                "DELETE FROM recipes.units WHERE name=?",
                name);
        if(i>0){
            return true;
        }
        return false;
    }


    private class UnitRowMapper implements RowMapper<Unit> {
        @Override
        public Unit mapRow(ResultSet resultSet, int i) throws SQLException {
            Unit unit = new Unit(resultSet.getInt("id"),resultSet.getString("name"));
            return unit;
        }
    }


}
