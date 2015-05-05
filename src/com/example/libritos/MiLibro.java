package com.example.libritos;

public class MiLibro {
	
	private int idImag; 
	private String textoSobre; 
	private String textoAbajo; 
	  
	public MiLibro (int idImag, String textoSobre, String textoAbajo) { 
	    this.idImag = idImag; 
	    this.textoSobre = textoSobre; 
	    this.textoAbajo = textoAbajo; 
	}
	
	public String get_textoEncima() { 
	    return textoSobre; 
	}
	
	public String get_textoDebajo() { 
	    return textoAbajo; 
	}
	
	public int get_idImagen() {
	    return idImag; 
	} 


	

}
