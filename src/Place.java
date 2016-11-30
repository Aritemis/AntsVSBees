import java.util.ArrayList;

/**
 * @author Ariana Fairbanks
 */

public class Place
{
	private String name; //a name we can use for debugging
	private Place exit; //where you leave this place to
	private Place entrance; //where you enter this place from
	private ArrayList<Bee> bees; //bees currently in the place
	private Ant ant; //ant (singular) currently in the place
	private Containing cannonFodder;
	protected boolean isWater;

	/**
	 * Creates a new place with the given name and exit
	 * @param theName The place's name
	 * @param theExit The place's exit
	 */
	public Place(String theName, Place theExit, boolean isWater)
	{
		this.name = theName;
		this.exit = theExit;
		this.entrance = null;
		this.bees = new ArrayList<Bee>();
		this.ant = null;
		this.isWater = isWater;
	}

	/**
	 * Creates a new place with the given name
	 * @param theName The place's name
	 */
	public Place(String theName)
	{
		this(theName, null, false);
	}

	public Place(String theName, Place place)
	{
		this(theName, place, false);
	}
	
	public Place(String theName, boolean isWater)
	{
		this(theName, null, isWater);
	}
	
	
	/**
	 * Returns the place's ant
	 * @return the place's ant
	 */
	public Ant getAnt()
	{
		return this.ant;
	}
	
	public Containing getCannonFodder()
	{
		return this.cannonFodder;
	}

	/**
	 * Returns an array of the place's bees
	 * @return an array of the place's bees
	 */
	public Bee[] getBees()
	{
		return this.bees.toArray(new Bee[0]);
	}

	/**
	 * Returns a nearby bee, up to the maxDistance ahead. If multiple bees are the same distance, a random bee is chosen
	 * @param minDistance The minimum distance away (in Places) a bee can be. A value of -1 means no min distance
	 * @param maxDistance The maximum distance away (in Places) a Bee can be. A value of -1 means no max distance
	 * @return A random nearby bee.
	 */
	public Bee getClosestBee(int minDistance, int maxDistance)
	{
		Place p = this;
		if (maxDistance == -1)
			maxDistance = Integer.MAX_VALUE;
		for(int dist = 0; p!=null && dist <= maxDistance; dist++)
		{
			if(dist >= minDistance && p.bees.size() > 0)
				return p.bees.get((int)(Math.random()*p.bees.size())); //pick a random bee
			p = p.entrance;
		}
		return null;
	}

	/**
	 * Returns the name of the place
	 * @return the name of the place
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the exit of the place
	 * @return the exit of the place
	 */
	public Place getExit()
	{
		return exit;
	}
	
	public boolean getWater()
	{
		return this.isWater;
	}

	/**
	 * Sets the entrance to the place
	 * @param newEntrance The entrance to the place
	 */
	public void setEntrance(Place newEntrance)
	{
		this.entrance = newEntrance;
	}

	/**
	 * Returns the entrance to the place
	 * @return the entrance to the place
	 */
	public Place getEntrance()
	{
		return this.entrance;
	}

	/**
	 * Adds an ant to the place. If there is already an ant, this method has no effect
	 * @param newAnt The ant to add to the place.
	 */
	public void addInsect(Ant newAnt)
	{
		this.ant = newAnt;
		newAnt.setPlace(this);
		if(this.cannonFodder != null)
		{
			this.cannonFodder.addSafeAnt(newAnt);
		}
	}
	
	public void addInsect(Containing newFodder)
	{
		this.cannonFodder = newFodder;
		((Insect) newFodder).setPlace(this);
		if(this.ant != null)
		{
			newFodder.addSafeAnt(this.ant);
		}
	}

	/**
	 * Adds a bee to the place
	 * @param newBee The bee to add to the place.
	 */
	public void addInsect(Bee newBee)
	{
		bees.add(newBee);
		newBee.setPlace(this);
	} 

	/**
	 * Removes the ant from the place. If the given ant is not in this place, this method has no effect
	 * @param deadAnt The ant to remove from the place
	 */
	public void removeInsect(Ant deadAnt)
	{
		if(this.ant == deadAnt)
		{
			this.ant.setPlace(null);
			this.ant = null;
			if(cannonFodder != null)
			{
				this.cannonFodder.removeSafeAnt();
			}
		}
		else
		{
			System.out.println(deadAnt + " is not in "+this);
		}
	}

	public void removeInsect(Containing deadFodder)
	{
		if(this.cannonFodder == deadFodder)
		{
			this.cannonFodder.sacrifice();
			this.cannonFodder = null;
		}
		else
			System.out.println(deadFodder + " is not in "+this);
	}
	
	/**
	 * Removes the bee from the place. If the given bee is not in this place, this method has no effect
	 * @param deadBee The bee to remove from the place.
	 */
	public void removeInsect(Bee deadBee)
	{
		if(bees.contains(deadBee))
		{
			bees.remove(deadBee);
			deadBee.setPlace(null);
		}
		else
			System.out.println(deadBee + " is not in "+this);
	}

	public String toString()
	{
		return name;
	}


}
