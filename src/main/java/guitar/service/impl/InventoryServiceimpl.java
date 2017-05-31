package guitar.service.impl;

import java.util.List;

import guitar.FactoryImpl.SqliteFactoiry;
import guitar.dao.InventoryDao;
import guitar.domain.Guitar;
import guitar.service.InventoryService;

public class InventoryServiceimpl implements InventoryService {

	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		try {
			//切换数据库
			InventoryDao InventoryDao = (new SqliteFactoiry()).GetInventoryInstance();
			return InventoryDao.Search(searchGuitar);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Guitar guitar) {
		// TODO Auto-generated method stub
		try {
			InventoryDao InventoryDao = (new SqliteFactoiry()).GetInventoryInstance();
			return InventoryDao.addGuitar(guitar);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean del(String serialNumber) {
		// TODO Auto-generated method stub
		try {
			InventoryDao InventoryDao = (new SqliteFactoiry()).GetInventoryInstance();
			return InventoryDao.deleteGuitar(serialNumber);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
