package dao.custom;

import java.sql.SQLException;

public interface QueryDAO {
    public void searchOrderByOrderID(String  id)throws SQLException, ClassNotFoundException;
}
