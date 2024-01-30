package com.complemento.inventory.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResposeRest {
	
	
	private ArrayList<HashMap<String, String>> datos=new ArrayList<>();
	
	public ArrayList<HashMap<String, String>> getDatos() {
		return datos;
	}
	
	public void setDatos(String tipo, String codigo, String dato) {
		HashMap<String, String> mapa=new HashMap<String, String>();
		mapa.put("tipo", tipo);
		mapa.put("codigo", codigo);
		mapa.put("dato", dato);
		mapa.put("hola", "mundo");
		
		datos.add(mapa);
	}
  
}
