package mc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mc.models.Paciente;


public class PacientesDAO {

	private Connection connection;
	
	public PacientesDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public List<Paciente> getLista(){
		List<Paciente> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from paciente");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Paciente m = new Paciente();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				m.setEmail(rs.getString("email"));
				m.setSenha(rs.getString("senha"));
				m.setCpf(rs.getString("cpf"));
				m.setTelefone(rs.getString("telefone"));

				boolean aux = rs.getBoolean("planoSaude");
				if(aux == true) {
					m.setPlanoSaude("Sim");
				}else {
					m.setPlanoSaude("Não");
				}
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				m.setDataNascimento(data);
				
				result.add(m);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	public boolean inserir(Paciente p) {

		String sql = "insert into paciente (nome, email, senha, cpf, telefone, dataNascimento, planoSaude) " 
		+ "values (?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getEmail());
			stmt.setString(3, p.getSenha());
			stmt.setString(4, p.getCpf());
			stmt.setString(5, p.getTelefone());
			stmt.setDate(6, new java.sql.Date(p.getDataNascimento().getTimeInMillis()));
			stmt.setBoolean(7, true);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public int login(Paciente p){
		
		int num = 0;
		
		try{
			
			PreparedStatement stmt = this.connection.prepareStatement("select count(*) as ct from paciente where email=? and senha=?;");
			stmt.setString(1, p.getEmail());
			stmt.setString(2, p.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				num = rs.getInt("ct");
			}
			
		}catch (Exception e) {
			
			// TODO: handle exception
		}
		
		return num;
	}
	
	public Paciente getByEmail(String email){
		Paciente p = null;
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from paciente where email = ?;");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				p = new Paciente();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setCpf(rs.getString("cpf"));
				p.setTelefone(rs.getString("telefone"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataNascimento"));
				p.setDataNascimento(cal);
				
				if(rs.getBoolean("planoSaude") == true){
					p.setPlanoSaude("Sim");
				}else{
					p.setPlanoSaude("Não");
				}
				
				rs.close();
				stmt.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return p;
	}
	
	public long getId(String email) {
		
		long idP = 0;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select id from paciente where email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				idP = rs.getLong("id");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return idP;
	}
	
	public String getCof(String email) {
		
		String rtn = null;
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select cpf from paciente where email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				rtn = rs.getString("cpf");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return rtn;
	}
}
