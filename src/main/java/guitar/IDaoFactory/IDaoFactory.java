package guitar.IDaoFactory;

import guitar.dao.InventoryDao;
import guitar.domain.Guitar;

public interface IDaoFactory {
public  InventoryDao GetInventoryInstance() throws Exception;
}
	