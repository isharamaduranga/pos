package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDao<CustomerDTO,String>{
    public ArrayList<CustomerDTO> getAllCustomerByAddress(String address)throws SQLException, ClassNotFoundException;
}
