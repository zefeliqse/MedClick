package mc.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Consultas {

	private long id;
	private String crm;
	private String cpf;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataConsulta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Calendar dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

}
