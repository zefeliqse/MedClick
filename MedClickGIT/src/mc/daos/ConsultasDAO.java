package mc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mc.models.Consultas;
import mc.models.Paciente;


public class ConsultasDAO {

	private Connection connection;
	
	public ConsultasDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public Consultas getByID(long id) {
		Consultas result = null;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from consultas where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = new Consultas();
				result.setId(rs.getLong("id"));
				result.setCrm(rs.getString("crm"));
				result.setCpf(rs.getString("cpf"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataCon"));
				result.setDataConsulta(data);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}

	public boolean remarcar(Consultas c) {
		
		String sql = "update consultas set crm=?, dataCon=? where id=?";
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, c.getCrm());
			stmt.setDate(2, new java.sql.Date(c.getDataConsulta().getTimeInMillis()));
			stmt.setLong(3, c.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean cancelar(long id) {
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("delete from consultas where id = ?");
			stmt.setLong(1, id);
			
			stmt.execute();
			stmt.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean marcar(Consultas c) {
		
		String sql = "insert into consultas(crm, cpf, dataCon) values " + "(?,?,?)";
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, c.getCrm());
			stmt.setString(2, c.getCpf());
			stmt.setDate(3, new java.sql.Date(c.getDataConsulta().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		return true;
	}
	
	
	public List<Consultas> getConsultasByCpf(String cpf){
		List<Consultas> result = new ArrayList<>();
		
		try{
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from consultas where cpf = ?");
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Consultas con = new Consultas();
				con.setId(rs.getLong("id"));
				con.setCpf(rs.getString("cpf"));
				con.setCrm(rs.getString("crm"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataCon"));
				con.setDataConsulta(cal);
				
				result.add(con);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	
	
	//////////////////////////////////q
	
	public List<Consultas> getListaPasClie(long id){
		List<Consultas> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from consultas where dataCon < curdate() and id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Consultas m = new Consultas();
				m.setId(rs.getLong("id"));
				m.setCrm(rs.getString("crm"));
				m.setCpf(rs.getString("cpf"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataCon"));
				m.setDataConsulta(data);
				
				result.add(m);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}

	
	public List<Consultas> getListaDiaClie(long id){
		List<Consultas> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from consultas where dataCon = curdate() and id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Consultas m = new Consultas();
				m.setId(rs.getLong("id"));
				m.setCrm(rs.getString("crm"));
				m.setCpf(rs.getString("cpf"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataCon"));
				m.setDataConsulta(data);
				
				result.add(m);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	public List<Consultas> getListaFutClie(long id){
		List<Consultas> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from consultas where dataCon > curdate() and id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Consultas m = new Consultas();
				m.setId(rs.getLong("id"));
				m.setCrm(rs.getString("crm"));
				m.setCpf(rs.getString("cpf"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataCon"));
				m.setDataConsulta(data);
				
				result.add(m);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	public List<Consultas> getAllByID(long id) {
		List<Consultas> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from consultas where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Consultas c = new Consultas();
				c.setId(rs.getLong("id"));
				c.setCrm(rs.getString("crm"));
				c.setCpf(rs.getString("cpf"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataCon"));
				c.setDataConsulta(data);
				
				result.add(c);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	
}
