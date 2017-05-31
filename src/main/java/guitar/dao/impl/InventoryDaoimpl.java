package guitar.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import guitar.dao.InventoryDao;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;
import util.DataConnection;

public abstract class InventoryDaoimpl implements InventoryDao {

	protected List<Guitar> guitars;
	protected String sql;
	protected PreparedStatement pstmt;
	protected String type = null;

	public void setType(String type) {
		this.type = type;
	}

	public InventoryDaoimpl() {
		guitars = new LinkedList<Guitar>();
	}

	@Override
	public boolean addGuitar(Guitar guitar) {
		sql = "insert into guitar values(?,?,?,?,?,?,?,?);";
		try {
			try {
				pstmt = DataConnection.getConnection(type).prepareStatement(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt.setString(1, guitar.getSerialNumber());
			pstmt.setDouble(2, guitar.getPrice());
			pstmt.setString(3, guitar.getSpec().getBuilder());
			pstmt.setString(4, guitar.getSpec().getModel());
			pstmt.setInt(5, guitar.getSpec().getNumStrings());
			pstmt.setString(6, guitar.getSpec().getType());
			pstmt.setString(7, guitar.getSpec().getBackWood());
			pstmt.setString(8, guitar.getSpec().getTopWood());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteGuitar(String serialNumber) {
		sql = "DELETE FROM guitar where serialNumber=?;";
		try {
			try {
				pstmt = DataConnection.getConnection(type).prepareStatement(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt.setString(1, serialNumber);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Guitar> getGuitarLinkedList() {
		sql = "select * from guitar;";
		try {
			try {
				pstmt = DataConnection.getConnection(type).prepareStatement(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String serialNumber = rs.getString("serialNumber");
				Double price = rs.getDouble("price");
				String builder = rs.getString("builder");
				String model = rs.getString("model");
				String type = rs.getString("type");
				int numStrings = rs.getInt("numStrings");
				String backWood = rs.getString("backWood");
				String topWood = rs.getString("topWood");
				Guitar guitar = new Guitar(serialNumber, price,
						new GuitarSpec(builder, model, type, numStrings, backWood, topWood));
				guitars.add(guitar);
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guitars;

	}

	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		guitars = getGuitarLinkedList();
		List<Guitar> matchingGuitars = new LinkedList<Guitar>();
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSpec().matches(searchGuitar.getSpec()))
				matchingGuitars.add(guitar);
		}
		return matchingGuitars;

	}

}
