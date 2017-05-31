package guitar.FactoryImpl;

import guitar.IDaoFactory.IDaoFactory;
import guitar.dao.InventoryDao;
import guitar.dao.impl.InventoryDaoimplSqlite;

public class SqliteFactoiry  implements IDaoFactory {

	@Override
	public InventoryDao GetInventoryInstance() throws Exception {
		// TODO Auto-generated method stub
		return new InventoryDaoimplSqlite();
	}

}
