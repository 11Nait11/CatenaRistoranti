package persistenza.dao;

import java.util.List;

import model.Piatto;



public interface PiattoDao {
	
	
	//METODI CRUD PER INTERROGARE DB
	public void saveOrUpdate(Piatto piatto); //create-update
	public List<Piatto> findAll();//retrive
	public Piatto findByPrimaryKey(Long id);//retrive
	public void delete(Piatto piatto);//delete

}
