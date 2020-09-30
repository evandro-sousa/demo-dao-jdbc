package br.com.aplicacao;



import java.util.Date;

import br.com.modelo.entidade.Departamento;
import br.com.modelo.entidade.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Departamento obj = new Departamento(1, "Livros");
		
		Vendedor vendedor = new Vendedor(33, "Evandro", "evandro@hotmail.com"	, new Date(), 1000.00, obj);
				
		System.out.println(vendedor);

	}

}
