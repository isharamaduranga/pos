package bo.custom;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.PurchaseOrderBOImpl;

public class BOFactory {
    /** Use Singleton Design Pattern  For Create BoFactory*/
    
    private static BOFactory boFactory;

    private BOFactory() {
    }
    
    public static BOFactory getBoFactory(){
        if(boFactory==null){
          return   boFactory=new BOFactory();
        }
        return boFactory;
    }
    
    public enum BOTypes{
        CUSTOMER,ITEM,PLACEORDER
    }
    
    public SuperBO getBO(BOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACEORDER:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }
}
