package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private final ItemDAO dao= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);


    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {

        
        
        return dao.getAll();
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return dao.delete(code);
    }

    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return dao.save(dto);
    }
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return dao.update(dto);
    }

    public boolean itemExist(String code) throws SQLException, ClassNotFoundException {
        return dao.exists(code);
    }
    public String generateNewItemID() throws SQLException, ClassNotFoundException {
        return dao.generateNewId();
    }
}
