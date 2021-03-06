package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    private final CustomerDAO dao= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    
    
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {

        
        
        return dao.getAll();
    }

    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return dao.save(dto);
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return dao.update(dto);
    }

    public boolean customerExist(String id) throws SQLException, ClassNotFoundException {
        return dao.exists(id);
    }
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }
    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
       return dao.generateNewId();
    }

}
