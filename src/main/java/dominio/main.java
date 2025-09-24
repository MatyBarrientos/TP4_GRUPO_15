package dominio;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		DaoSeguro daoS= new DaoSeguro();
		ArrayList<Seguro> Lista = daoS.obtenerSeguros();
		/*for(Seguro s:Lista) {
		System.out.println(s);
		}*/
		
		
			
		
	    System.out.println("\nmuestra: "+daoS.obtenerUltimoIdSeguro());
		Lista = daoS.obtenerSegurosID(3);
		for(Seguro s:Lista) {
		System.out.println(s);
		}
	    

	}

}
