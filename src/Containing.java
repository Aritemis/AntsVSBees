/**
 * @author Ariana Fairbanks
 */

public interface Containing 
{	
	public boolean addSafeAnt(Ant safeAnt);
	public boolean removeSafeAnt();
	public Ant getSafeAnt();
	public void sacrifice();
}
