package mc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mc.models.Medico;


public class MedicosDAO {

	private Connection connection;
	
	public MedicosDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public List<Medico> getLista(){
		List<Medico> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from medico");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Medico m = new Medico();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				m.setEmail(rs.getString("email"));
				m.setSenha(rs.getString("senha"));
				m.setCpf(rs.getString("cpf"));
				m.setTelefone(rs.getString("telefone"));
				m.setCrm(rs.getString("crm"));
				m.setEspecialidade(rs.getString("especialidade"));
				
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
}
