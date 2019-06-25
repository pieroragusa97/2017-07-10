package it.polito.tdp.artsmia.model;

public class testmodel {
	
	public void run() {
		Model model=new Model();
		model.CreaGrafo();
		System.out.println(" connectivity :\n"+model.componenti(0));
		System.out.println("visite: \n"+model.componenteConnessa(0));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       testmodel mo=new testmodel();
       mo.run();
	}

}