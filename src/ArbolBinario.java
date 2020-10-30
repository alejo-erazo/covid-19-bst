
public class ArbolBinario {
	
	Nodo root;
	float valorXsintoma;

 public ArbolBinario(float valorXsintoma) {
		
		this.valorXsintoma = valorXsintoma;
	}
public void Agregar (Paciente paciente) {
	
	paciente.valorTratamiento= paciente.sintomas.length * valorXsintoma;
	 Nodo nodo= new Nodo(paciente);
	 
	if (root==null) {
		root= nodo;
	}
	else {
		
		Agregar(root, paciente);
	}
	
	
}
private void Agregar(Nodo root, Paciente paciente) {
	if (root == null) {
		return;
	}
	 Nodo nodo= new Nodo(paciente);
	 if(paciente.id>root.paciente.id) {
		 if(root.derecho==null) {
			 root.derecho= nodo;
		 }
		 else {
			 Agregar(root.derecho, paciente );
		 }
	 }
	 else {
		 if(root.izquierdo==null) {
			 root.izquierdo= nodo;
		 }
		 else {
			 Agregar(root.izquierdo, paciente );
		 }
	 }
	 
}

public Paciente Buscar(int id) {
	
	return Buscar(id, root);
}

private Paciente Buscar(int id, Nodo root) {
	if (root == null) {
		return null;
	}
	
	else {
	if(root.paciente.id== id) {
		return root.paciente;
	}
	if (id>root.paciente.id) {
		return Buscar(id, root.derecho);
				}
	else {
		return Buscar(id, root.izquierdo);
	}
	}
}
public void listar () {
	listar(root);
}
private void listar(Nodo root) {
	if (root!= null) {
		System.out.println(root.paciente.nombre + " tiene " + root.paciente.sintomas.length + "sintomas, su tratamiento tiene un costo de  " + root.paciente.valorTratamiento);
	
		listar(root.izquierdo);
		listar(root.derecho);
	}
	
}

public Paciente mayorPago () {
return 	mayorPago(root.paciente, root);
	

}

private Paciente mayorPago (Paciente mayor, Nodo root) {
	if (root!= null) {
		if (mayor.valorTratamiento<root.paciente.valorTratamiento) {
			mayor=root.paciente;
		}
		 mayorPago(mayor, root.izquierdo);
		 mayorPago(mayor, root.derecho);
		
	}
	return mayor;
	
}
}
