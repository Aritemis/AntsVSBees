/**
 * @author Ariana Fairbanks
 */

public class FireAnt extends Ant 
{
	private int damage;

	
	public FireAnt()
	{
		super(1, 4);
		this.damage = 3;
	}
	
	@Override
	public void act(AntColony colony) 
	{
		
	}

	@Override
	public void reduceArmor(int damage)
	{
		this.armor -= damage;
		if(this.armor <= 0)
		{
			String message = this.toString() + " exploded";
			
			Bee [] bees = this.place.getBees();
			if(bees != null)
			{
				for(int bee = 0; bee < bees.length; bee++)
				{
					Bee target = bees[bee];
					target.reduceArmor(this.damage);
					message += "\n" + this.toString() + " dealt " + this.damage + " damage to " + target.toString();
				}
			}
			System.out.println(message);
			leavePlace();
		}
	}
	
	public void setDamage(int damage) 
	{
		this.damage = damage;
	}

}
