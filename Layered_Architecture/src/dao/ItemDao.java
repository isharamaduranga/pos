package dao;

import model.ItemDTO;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDao {

     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

     boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean existsItem(String code) throws SQLException, ClassNotFoundException;

     String generateNewId() throws SQLException, ClassNotFoundException;
}
