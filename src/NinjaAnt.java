/**
 * @author Ariana Fairbanks
 */

public class NinjaAnt extends Ant
{

	private int damage;
	
	public NinjaAnt()
	{
		super(1, 6, false);
		this.damage = 1;
	}

	@Override
	public void act(AntColony colony) 
	{
		Bee [] bees = this.place.getBees();
		if(bees != null)
		{
			for(int bee = 0; bee < bees.length; bee++)
			{
				Bee target = bees[bee];
				target.reduceArmor(this.damage);
				System.out.println(this.toString() + "dealt " + this.damage 
								 + " point/s of damage to " + target.toString());
			}
		}
	}
	
}
