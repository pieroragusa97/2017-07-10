package it.polito.tdp.artsmia.model;

public class Coppia {
	private ArtObject a1;
	private ArtObject a2;
	private int contaEsComune;
	
	public Coppia(ArtObject a1, ArtObject a2, int contaEsComune) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.contaEsComune = contaEsComune;
	}

	public ArtObject getA1() {
		return a1;
	}

	public void setA1(ArtObject a1) {
		this.a1 = a1;
	}

	public ArtObject getA2() {
		return a2;
	}

	public void setA2(ArtObject a2) {
		this.a2 = a2;
	}

	public int getContaEsComune() {
		return contaEsComune;
	}

	public void setContaEsComune(int contaEsComune) {
		this.contaEsComune = contaEsComune;
	}
	
	

}
