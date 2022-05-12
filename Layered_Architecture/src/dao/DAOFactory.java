package dao;

import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public  static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            return new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,QUERYDAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

}
