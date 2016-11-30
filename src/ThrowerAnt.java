/**
 * An ant who throws leaves at bees
 * @author Ariana Fairbanks
 */

public class ThrowerAnt extends Ant
{
	private int damage;
	protected int minRange;
	protected int maxRange;
	
	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 0, Damage: 1
	 */
	public ThrowerAnt()
	{
		super(1, 4);
		this.damage = 1;
		this.minRange = 0;
		this.maxRange = 3;
	}

	public ThrowerAnt(boolean canSwim)
	{
		super(1, 4, true, true);
		this.damage = 1;
		this.minRange = 0;
		this.maxRange = 3;
	}
	
	public ThrowerAnt(int cost, int min, int max)
	{
		super(1, cost);
		this.damage = 1;
		this.minRange = min;
		this.maxRange = max;
	}
	
	/**
	 * Returns a target for this ant
	 * @return A bee to target
	 */
	public Bee getTarget()
	{
		return place.getClosestBee(this.minRange,this.maxRange);
	}

	/**
	 * Throws leaf at a bee that is attacking the colony, damaging it
	 */
	public void act(AntColony colony)
	{
		Bee target = getTarget();
		if(target != null)
		{
			target.reduceArmor(this.damage);
		}
	}
}
