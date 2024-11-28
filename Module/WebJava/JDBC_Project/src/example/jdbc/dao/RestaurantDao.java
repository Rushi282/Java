package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.pojo.Restaurant;
import example.jdbc.utils.JdbcUtils;

public class RestaurantDao implements DaoInterface<Restaurant, Integer> {

	@Override
	public Collection<Restaurant> retrieveAll() {
		String query = "select * from restaurant_master";
		Collection<Restaurant> restaurants = new ArrayList<>();
		try (Connection con = JdbcUtils.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				restaurants.add(new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurants;
	}

	@Override
	public Restaurant retrieveOne(Integer key) {
		Restaurant foundRestaurant = null;
		String query = "select * from restaurant_master where rest_id = ?";
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				foundRestaurant = new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundRestaurant;
	}

	@Override
	public void create(Restaurant newRest) {
		String query = "insert into restaurant_master values(?,?,?,?)";
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {
			pstmt.setInt(1, newRest.getRestId());
			pstmt.setString(2, newRest.getName());
			pstmt.setString(3, newRest.getCuisin());
			pstmt.setInt(4, newRest.getBranchCount());
			int rec = pstmt.executeUpdate();
			System.out.println(rec + " record inserted..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOne(Restaurant updatedRest) {
		String query = "update restaurant_master set rest_name = ?, rest_cuisine = ?, rest_branch_count = ? where rest_id = ?";
		try (Connection con = JdbcUtils.getConnection();
				PreparedStatement pstmt = con.prepareStatement(query);
				) {
			pstmt.setInt(4, updatedRest.getRestId());
			pstmt.setString(1, updatedRest.getName());
			pstmt.setString(2, updatedRest.getCuisin());
			pstmt.setInt(3, updatedRest.getBranchCount());
			int rec = pstmt.executeUpdate();
			System.out.println(rec + " record updated..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOne(Integer key) {
		String query = "delete from restaurant_master where rest_id = ?";
		try (Connection con = JdbcUtils.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(query);) {
			pstmt.setInt(1, key);
			int rec = pstmt.executeUpdate();
			System.out.println(rec + " record deleted..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
