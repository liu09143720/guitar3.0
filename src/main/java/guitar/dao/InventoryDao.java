package guitar.dao;

import java.util.List;

import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;

public interface InventoryDao {
	List<Guitar> Search(Guitar searchGuitar);	
	public boolean addGuitar(Guitar guitar);
	public boolean deleteGuitar(String serialNumber);
}
