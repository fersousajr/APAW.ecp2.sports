package apaw.p2.sport.daos;

public abstract class DaoFactory {

    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public static DaoFactory getFactory(DaoFactory daoFactory){
    	if(factory == null){
    		factory = daoFactory;
    	}
    	return factory;
    }
    
    public abstract SportDao getSportDao();

    public abstract UserDao getUserDao();

}
