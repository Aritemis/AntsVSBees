/**
 * An Ant that harvests food
 * @author Ariana Fairbanks
 */

public class HarvesterAnt extends Ant
{
	/**
	 * Creates a new Harvester Ant
	 */
	public HarvesterAnt()
	{
		super(1, 2);
	}

	public void act(AntColony colony)
	{
		colony.increaseFood(1); 
	} 
}
