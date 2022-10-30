package persistenza.dao.postgress;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Piatto;
import model.Ristorante;
import persistenza.dao.PiattoDao;

public class PiattoDaoPostgress implements PiattoDao {
	
	Connection conn;
	
	//costruttore
	public PiattoDaoPostgress(Connection conn) {this.conn=conn;}

	
	@Override
	public void saveOrUpdate(Piatto piatto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Piatto> findAll() {
		
		List<Piatto> piatti=new ArrayList<Piatto>();
		String query="select * from piatto p, serve s, ristorante r "
				+ "where p.id=s.piatto and r.id=s.ristorante";
		
		try {
			//senza parametri utilizza createStatment
			java.sql.Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			
			Piatto piatto =new Piatto();
			String prec="";
			Boolean inizio=true;
			
			while(rs.next()) {
				prec=rs.getString("p.id");
				Ristorante r= new Ristorante();
				r.setNome(rs.getString("r.nome"));
				
				if(prec!=rs.getString("p.id") || inizio) {
					piatto=new Piatto();
					piatto.setId(rs.getLong("p.id"));
					piatto.setNome(rs.getString("p.nome"));
					piatto.setRistoranti(new ArrayList<Ristorante>());
					inizio=false;
				}
		
				piatto.getRistoranti().add(r);
				
				
				
				
			}
			
			
		} catch (SQLException e) {e.printStackTrace();}
		
		
		return piatti;
	}

	@Override
	public Piatto findByPrimaryKey(Long id) {
		Piatto piatto=new Piatto();
		String query="select *  from piatto p, serve s, ristorante r"
				+ "where  p.id=? and p.id=s.piatto and r.id=s.ristorante";
		
		
		
		
		try {
			
			//quando hai i parametri utilizza prepareStatment
			PreparedStatement st = conn.prepareStatement(query);
			//imposta il valore a p.id=?
			st.setLong(1, id);
			ResultSet rs= st.executeQuery();
			
			
			
			
			while(rs.next()) {
				//primo giro di while crea il piatto
				if(piatto==null) {
					piatto=new Piatto();
					piatto.setId(rs.getLong("p.id"));
					piatto.setNome(rs.getString("p.nome"));
				}
				Ristorante r= new Ristorante();
				r.setNome(rs.getString("nome"));
				piatto.getRistoranti().add(r);
				
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		
		return piatto;
	}

	@Override
	public void delete(Piatto piatto) {
		// TODO Auto-generated method stub
		
	}

}
