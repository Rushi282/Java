package example.jdbc.dao;

import java.util.Collection;


public interface DaoInterface<T,K> {
	// Retrieve all records
	Collection<T> retrieveAll();
	
	// Retrieve one record
	T retrieveOne(K key);
	
	// Insert record
	void create(T t);
	
	// Update an existing record
	void updateOne(T t);
	
	// Delete record
	void deleteOne(K key);
}
