package it.polito.tdp.artsmia.model;

public class Regole {
	
	/*MODEL    Se gli elementi che escono dal DAO possono essere nulli,
	 *         mettere gestione eccezioni del grafo.
	 *         es. if(Confini.isEmpty()){
	 *                 throw new RintimeException("non ci sono confini")
	 *                 }
	 *                 
	 *MODEL    Per ottenere il numero di componenti connesse di un grafo si usa il metodo
	 *         public int getNumero(){
	 *            ConnectivityInspector<Object,DefaultEdge> ci=new .......(this.graph);
	 *            return ci.ConnectedSets.size();
	 *            }
	 *         Se volessi prendere la componente connessa del grafo che contiene un vertice x,
	 *         e calcolare il numero di vertici che fanno parte di questa componente connessa,
	 *         uso ci.ConnectedSetsOf(Object scelto);
	 *         Questo metodo è uguale a quello dellle visite,in cui prendo il verice di partenza,
	 *         e riempio una lista di vertici visitati con DepthFirstIterator<Object,DefaultEdge>
	 *         ,passandogli this.grafo,vertice considerato, e alla fine prendo visitati.size()
	 *         
	 *MODEL    Per fare una visita si usa DephtFirstIterator o BreadthFirstItearator
	 *         GraphIterator<Object,DefaultEdge> dfv=new DepthFirstIterator<....>(this.grafo,SelectedObject)
	 *         while(dfv.hasNext(){
	 *             visited.add(dfv.next());
	 *             }
	 *           
	 *MODEL    Creare DAO e Grafo fuori dai metodi con private e poi inizializzarli 
	 *         nel costruttore 
	 * 
	 *MODEL    Se ho due punti dotati di latitudine e longitudine posso calcolare la distanza,
	 *         scegliendo l'unità di misura e usando LatLng
	 *         es.    LatLngTool.distance(new LatLng(lat1,lon1),x2,LengthUnit.KILOMETER) 
	 *         
	 *MODEL    Se ho da fare ordinamenti tra oggetti, meglio creare una nuova classe,
	 *         e mettere oggetto e elemento che serve per ordinare, + implements Comparable 
	 *         e ridefinire CompareTo.
	 *         
	 *MODEL    Per trovare i vicini di un vertice si usa graphs.neighboursListOf(this.grafo,v)
	 *
	 *MODEL    Esiste il comando YearOf(anno) che mi restituisce un oggeto year utile
	 *         per popolare una tendina
	 *         
	 *MODEL    Meglio quando possibile usare i nomi anzichè gli oggetti come vertici di un grafo
	 *
	 *MODEL    Conviene avere sempre una IdentityMap, insieme al grafo per fare ordinamente,
	 *         prendere subito gli oggetti, e passarla al dao
	 *         
	 *MODEL    Per prendere predecessori e successori di un vertice, si usano i metodi
	 *         -graphs.SuccessorListOf(this.grafo,vertice)
	 *         
	 *MODEL    prima di creare gli arche controllare che tutti gli oggetti di una classe
	 *         specifica del DB appartengano a quella generale che mi da i vertici
	 *         es. exhibition_objects che non fanno parte di objects
	 *         vengono generate delle eccezioni perchè quando prendo elementi di una coppia
	 *         per formare archi,se questi non sono vertici ci saranno problemi
	 *         chiedere prima di creare l'arco
	 *         if(grafo.vertexSet.contains(Object1)&&......(Object2) e poi posso inserirlo
	 *         
	 *MODEL/CONTR   se devo riempire una box e mi servono piu cose da far apparire per 
	 *              ogni riga, conviene creare un oggetto e mettere tutto quello che mi serve
	 *              e definire un metodo ToString();
	 *              
	 *CONTR    inizializzare la box dentro il setModel() con Box.getItems.setAll(lista)
	 *
	 *CONTR    se devo scegliere un elemento dalla box, dentro il doEvento mettere solo
	 *         il controllo 
	 *         if(ev==null){
	 *              txtResult.appendText("evento nullo");
	 *              return;
	 *              }else .....
	 *         Try e catch li uso quando devo inserire un valore e c'è il rischio che 
	 *         questo non sia valido
	 *         
	 *CONTR    Controllare che un bottone non dipenda dalla creazione di un grafo
	 *         mettere il controllo in questo caso
	 *         
	 *DAO      Se dalla select esce un solo valore nel metododao mettere if anzichè while(rs.next)
	 *
	 *DAO      per avere relazioni in cui 2 oggetti abbiano qualcosa in comune, creare 
	 *         una tabella con i due oggetti appaiati, con un attributo comune e in cui 
	 *         in ogni riga ci sia og1, og2, attributo comune....raggruppando poi con group by
	 *         posso avere og1,og2,conta volte in cui compaiono insieeme in una stessa manifestazione
	 *         
	 *DAO      collegato la punto sopra, se devo prendere due oggetti che si trovano 
	 *         in un evento e il peso rappresenta il numero di eventi in comune:
	 *         -creo una classe Coppia , con i due oggetti e la conta
	 *         - select o1,o2,conta(eventi)
	 *           from tabella eventi1,tabella eventi2
	 *           where ev1=ev2 and idoggetto1>idOggetto2(evito casi A-B e B-A)
	 *           group by o1,o2 cosi prendo le coppie uguali
	 *           
	 *SQL      in un metodo dao della query posso usare una parte di data, es. select year("data")
	 *
	 *DB      dopo il db?serverTimezone=Europe/Rome" se ci sono prima user e password &&
	 *         
	 **/
	

}
