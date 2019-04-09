package com.appgestion.web.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="typeclient")
public class TypeClient implements Serializable {
	
	@Id
	@GeneratedValue
	private long idTypeClient;
	private String designation;
	
	@OneToMany(mappedBy="type")
	private List<Client> clientType;
	
	public TypeClient() {
		super();
	}
	
	public long getIdTypeClient() {
		return idTypeClient;
	}
	public void setIdTypeClient(long idTypeClient) {
		this.idTypeClient = idTypeClient;
	}

	
	
	@JsonIgnore
	public List<Client> getClientType() {
		return clientType;
	}
	public void setClientType(List<Client> clientType) {
		this.clientType = clientType;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
