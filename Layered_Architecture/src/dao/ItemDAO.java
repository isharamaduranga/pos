package dao;

import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDao<ItemDTO,String>{

    public ArrayList<ItemDTO> getAllItemByPrice(double  price)throws SQLException, ClassNotFoundException;

}
