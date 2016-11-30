/**
 * A class representing a basic Ant
 * @author Ariana Fairbanks
 */

public abstract class Ant extends Insect
{
	protected int foodCost; //the amount of food needed to make this ant
	protected boolean visible;

	/**
	 * Creates a new Ant, with a food cost of 0.
	 * @param armor The armor of the ant.
	 */
	public Ant(int armor)
	{
		super(armor);
		this.foodCost = 0;
		this.visible = true;
	}

	public Ant(int armor, int foodCost)
	{
		super(armor);
		this.foodCost = foodCost;
		this.visible = true;
	}
	
	public Ant(boolean isCannonFodder,int armor, int foodCost)
	{
		super(armor);
		this.foodCost = foodCost;
		this.visible = true;
		this.isCannonFodder = isCannonFodder;
	}

	public Ant(int armor, int foodCost, boolean visible)
	{
		super(armor);
		this.foodCost = foodCost;
		this.visible = visible;
	}
	
	public Ant(int armor, int foodCost, boolean visible, boolean canSwim)
	{
		super(armor, canSwim);
		this.foodCost = foodCost;
		this.visible = visible;
	}


	/**
	 * Returns the ant's food cost
	 * @return the ant's good cost
	 */
	public int getFoodCost()
	{
		return foodCost;
	}
	

	public boolean getVisibility()
	{
		return this.visible;
	}

	/**
	 * Removes the ant from its current place
	 */
	public void leavePlace()
	{
		this.place.removeInsect(this);
	} 
}
