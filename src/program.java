import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class program {

	public static void main(String[] args) throws NumberFormatException, IOException{

		int pacientesFibre=0;
		ArbolBinario arbolBinario= new ArbolBinario(100);
		BufferedReader bf;
		bf = new BufferedReader(new FileReader("datos.txt"));
		int tamaño = Integer.parseInt(bf.readLine());
		String[]datos;
		for (int i=0; i<tamaño; i++) {
			datos=bf.readLine().split(",");
		String nombre=datos[1];
		int id=Integer.parseInt (datos[0]);
		
			if(arbolBinario.Buscar (id) == null) {
				int cantSintomas=Integer.parseInt (datos[2]);
				String[] sintomas= new String [cantSintomas];
					datos=bf.readLine().split(",");
				for (int j=0; j<cantSintomas; j++) {
					sintomas[j]=datos[j];
					if(datos[j].equals("fiebre")) {
					 pacientesFibre ++;
					 
					 
					}
					
				}
				Paciente paciente= new Paciente(id,nombre,sintomas);
				arbolBinario.Agregar(paciente);
				
				System.out.println("Se ha agregado el paciente " + paciente.nombre);
			}
			else {
				System.out.println("el paciente " + nombre + " ya existe en el sistema");
			}
		}
		
		
		Paciente buscar= arbolBinario.Buscar (10537834);
		if (buscar!= null) {
			System.out.println("el paciente " + buscar.nombre + "presenta los siguientes sintomas: ");
			
			for(int i=0; i<buscar.sintomas.length; i++) {
				System.out.println(buscar.sintomas[i]);
			}
		}
		
		else {
			System.out.println("el paciente " + buscar.nombre + " No se encuentra resgistrado en el sistema ");
		}
		
		
		
		System.out.println("el sistema registro "+ pacientesFibre + " pacientes con fiebre");
		arbolBinario.listar();
		
		
		Paciente mayor= arbolBinario.mayorPago();
		System.out.println("el paciente que pago un mayor valor por su tratamiento es " + mayor.nombre + " por un valor de: "+ mayor.valorTratamiento);
	}

}
