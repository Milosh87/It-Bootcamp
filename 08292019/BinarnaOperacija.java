package domaciIzrazi;

public abstract class BinarnaOperacija extends Izraz {
protected Izraz levi;
protected Izraz desni;
public BinarnaOperacija(Izraz levi, Izraz desni) {
	super();
	this.levi = levi;
	this.desni = desni;
}


}
