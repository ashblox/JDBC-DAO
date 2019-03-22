package daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {

    public abstract T findById(int id) throws SQLException;

    public abstract List<T> findAll();

    public abstract T update(T dto);

    public abstract T create(T dto);

    public abstract void delete(int i);

}
