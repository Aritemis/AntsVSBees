/**
 * Represents a Bee
 * @author Ariana Fairbanks
 */

public class Bee extends Insect
{
	private static final int DAMAGE = 1;

	/**
	 * Creates a new bee with the given armor
	 * @param armor The bee's armor
	 */
	public Bee(int armor)
	{
		super(armor, true);
	}

	/**
	 * Deals damage to the given ant
	 * @param ant The ant to sting
	 */
	public void sting(Ant ant)
	{
		ant.reduceArmor(DAMAGE);
	}
	
	/**
	 * Deals damage to the given containing ant
	 * @param ant The ant to sting
	 */
	public void sting(Containing ant)
	{
		((Insect) ant).reduceArmor(DAMAGE);
	}

	/**
	 * Moves to the given place
	 * @param place The place to move to
	 */
	public void moveTo(Place newPlace)
	{
		this.place.removeInsect(this);
		newPlace.addInsect(this);
	}

	public void leavePlace()
	{
		this.place.removeInsect(this);
	}

	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 * @return if the bee can advance
	 */
	public boolean isBlocked()
	{
	
		if(this.place.getAnt() != null)
		{
			if(this.place.getAnt().getVisibility() == true)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if the bee is in the AntColony
	 * @return if the bee is in the AntColony
	 */
	public boolean isInColony()
	{
		return this.place != null;
	}


	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place.
	 */
	public void act(AntColony colony)
	{
		if (this.isInColony() && this.isBlocked())
		{
			if(this.place.getCannonFodder() == null)
			{
				sting(this.place.getAnt());
			}
			else
			{
				sting(this.place.getCannonFodder());
			}
		}
		else if(this.armor > 0)
		{
			this.moveTo(this.place.getExit());
		}
	}
}
