package hibernate1.dao;

import hibernate1.model.Unit;

import java.util.List;

public interface UnitDao {
    Unit getUnitByName(String name);

    List<Unit> getAllUnits();

    boolean addUnit(String name);

    boolean deleteUnitByName(String name);
}
