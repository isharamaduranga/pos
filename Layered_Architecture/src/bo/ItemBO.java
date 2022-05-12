package bo;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {

     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

     boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

     boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

     boolean itemExist(String code) throws SQLException, ClassNotFoundException;

     String generateNewItemID() throws SQLException, ClassNotFoundException ;

}
