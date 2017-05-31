package guitar.FactoryImpl;

import guitar.IDaoFactory.IDaoFactory;
import guitar.dao.InventoryDao;
import guitar.dao.impl.InventoryDaoimplMySQL;
import guitar.dao.impl.InventoryDaoimplSQLServer;

public class SQLServerFactoiry  implements IDaoFactory {

	@Override
	public InventoryDao GetInventoryInstance() throws Exception {
		// TODO Auto-generated method stub
		return new InventoryDaoimplSQLServer();
	}

}
