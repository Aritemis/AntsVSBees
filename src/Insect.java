/**
 * @author Ariana Fairbanks
 */

public abstract class Insect
{
	protected int armor; 
	protected Place place; 
	protected boolean canSwim;
	protected boolean isCannonFodder;  //A body guard, in other words

	/**
	 * Creates a new Insect with the given armor in the given location
	 * @param theArmor The insect's armor
	 * @param thePlace The insect's location
	 */
	public Insect(int theArmor, Place thePlace)
	{
		if(theArmor <= 0)
			throw new IllegalArgumentException("Cannot create an insect with armor of 0");
		this.armor = theArmor;
		this.place = thePlace;
		this.canSwim = false;
		this.isCannonFodder = false;
	}

	/**
	 * Creates an Insect with the given armor. The insect's location is null
	 * @param theArmor The insect's armor
	 */
	public Insect(int theArmor)
	{
		this(theArmor, null);
		this.canSwim = false;
		this.isCannonFodder = false;
	}
	
	public Insect(int armor, boolean canSwim)
	{
		this(armor, null);
		this.canSwim = canSwim;
		this.isCannonFodder = false;
	}

	public Insect(int armor, Place place, boolean canSwim)
	{
		this.armor = armor;
		this.place = place;
		this.canSwim = canSwim;
		this.isCannonFodder = false;
	}
	
	/**
	 * Set's the insect's current location
	 * @param thePlace The insect's current location
	 */
	public void setPlace(Place thePlace)
	{
		this.place = thePlace;
	}

	/**
	 * Return's the insect's current location
	 * @return the insect's current location
	 */
	public Place getPlace()
	{
		return this.place;
	}

	/**
	 * Has the insect move out of its current location. Abstract in case the insect takes action when it leaves
	 */
	public abstract void leavePlace();

	/**
	 * Returns the insect's current armor
	 * @return the insect's current armor
	 */
	public int getArmor()
	{
		return this.armor;
	}

	public boolean canItSwim()
	{
		return this.canSwim;
	}
	
	/**
	 * Reduces the insect's current armor (e.g., through damage)
	 * @param damage The amount to decrease the armor by
	 */
	public void reduceArmor(int damage)
	{
		this.armor -= damage;
		
		if(this instanceof Containing == true)
		{
			if(this.armor <= 0)
			{
				System.out.println(this + " gave its life to protect " + this.place.getAnt());
				this.leavePlace();
				place.removeInsect(place.getCannonFodder());
			}
		}
		else
		{
			if(this.armor <= 0)
			{
				System.out.println(this+" ran out of armor and expired");
				leavePlace();
			}
		}
	}

	/**
	 * The insect takes an action on its turn
	 * @param colony The colony in which this action takes place (to support wide-spread effects)
	 */
	public abstract void act(AntColony colony);

	public String toString()
	{
		return this.getClass().getName()+"["+armor+", "+place+"]"; 
	}
}
