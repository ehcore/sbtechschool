package hibernate1.dao;

import hibernate1.model.Unit;

import java.util.List;

public interface UnitDao {
    Unit getUnitByName(String name);

    List<Unit> getAllUnits();

    void addUnit(String name);

    void deleteUnitByName(String name);
}
