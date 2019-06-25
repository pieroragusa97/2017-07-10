package it.polito.tdp.artsmia.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {
	private SimpleWeightedGraph<ArtObject,DefaultWeightedEdge> grafo;
	private Map<Integer,ArtObject> mappaOggetti;
	private ArtsmiaDAO dao;
	
	public Model() {
		dao=new ArtsmiaDAO();
		mappaOggetti=new HashMap<Integer,ArtObject>();
		for(ArtObject a:this.tuttiOggetti())
			mappaOggetti.put(a.getId(), a);
		grafo=new SimpleWeightedGraph<ArtObject,DefaultWeightedEdge>(DefaultWeightedEdge.class);
	}
	
	public List<ArtObject> tuttiOggetti(){
		return dao.listObjects();
	}
	
	public void CreaGrafo() {
		
		Graphs.addAllVertices(this.grafo, this.tuttiOggetti());
		List<Coppia> coppie=dao.listCoppie(this.mappaOggetti);
		
		for(Coppia c:coppie) {
			if(grafo.vertexSet().contains(c.getA1())&&grafo.vertexSet().contains(c.getA2())) {
			  Graphs.addEdge(this.grafo, c.getA1(), c.getA2(), c.getContaEsComune());
			}
		}
		
		System.out.println(grafo.edgeSet().size());
	}
	
	public int  componenteConnessa(int IdOggetto) {
		ArtObject a=mappaOggetti.get(IdOggetto);
		List<ArtObject> visitati=new LinkedList<ArtObject>();
		DepthFirstIterator<ArtObject,DefaultWeightedEdge> d=new DepthFirstIterator<ArtObject,DefaultWeightedEdge>(this.grafo,a);
	    while(d.hasNext()) {
	    	visitati.add(d.next());
	    }
	    return visitati.size();
	}
	;
	public int componenti(int IdOggetto) {
		ConnectivityInspector<ArtObject,DefaultWeightedEdge> ci=new ConnectivityInspector<ArtObject,DefaultWeightedEdge>(this.grafo);
		Set<ArtObject> visitati;
		visitati=ci.connectedSetOf(mappaOggetti.get(IdOggetto));
		return visitati.size();
	}
	
	public boolean controllanumero(int id) {
		if(mappaOggetti.containsKey(id))
			return true;
		else 
			return false;
	}
	
	public int numeroVertici() {
		return grafo.vertexSet().size();
	}

}
