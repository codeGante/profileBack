package com.example.santander.models;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

@Document(collection="perfiles")

@JsonIgnoreProperties(value = {"fechaNac"}, allowGetters = true)
public class Perfil {
	
	@Id
	@ApiModelProperty(notes = "Provided profile id", required =true)
	private String id;
	
	@NotBlank
	@Size(max=15)
	@Indexed(unique=true)
	@ApiModelProperty(notes = "Provided profile name", required =true)
	private String nombre;
	
	private String foto;
	@NotBlank
	@Size(max=15)
	@ApiModelProperty(notes = "Provided profile lastname", required =true)
	private String appPat;
	
	@NotBlank
	@Size(max=15)
	@ApiModelProperty(notes = "Provided profile lastname", required =true)
	private String appMat;
	
	@ApiModelProperty(notes = "Provided profile birthdate", required =true)
	private Date fechaNac = new Date();
	
	@ApiModelProperty(notes = "Provided profile age", required =true)
	private Integer edad;
	
	public Perfil() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getAppPat() {
		return appPat;
	}

	public void setAppPat(String appPat) {
		this.appPat = appPat;
	}

	public String getAppMat() {
		return appMat;
	}

	public void setAppMat(String appMat) {
		this.appMat = appMat;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", appPat=" + appPat + ", appMat="
				+ appMat + ", fechaNac=" + fechaNac + ", edad=" + edad + "]";
	}
	
}
