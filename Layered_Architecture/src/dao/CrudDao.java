package dao;

import java.sql.SQLException;
import java.util.ArrayList;


public interface CrudDao<T,ID> extends SuperDAO{
     ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

     boolean save(T dto) throws SQLException, ClassNotFoundException;

     boolean update(T dto) throws SQLException, ClassNotFoundException;

     T search(ID id)throws SQLException, ClassNotFoundException;

     boolean exists(ID id) throws SQLException, ClassNotFoundException;

     boolean delete(ID id) throws SQLException, ClassNotFoundException;

     String generateNewId() throws SQLException, ClassNotFoundException;


}
