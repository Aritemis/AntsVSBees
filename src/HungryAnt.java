
public class HungryAnt extends Ant 
{

	private boolean hungry;
	private int countDown;
	
	public HungryAnt()
	{
		super(1, 4);
		this.hungry = true;
		this.countDown = 0;
	}
	
	@Override
	public void act(AntColony colony) 
	{
	
		if (countDown == 1)
		{
			this.countDown = 0;
			this.hungry = true;
			System.out.println(this.toString() + "Hungry now");
		}
		else if(hungry)
		{
			Bee dinner = place.getClosestBee(0,0);
			if(dinner != null)
			{
				dinner.reduceArmor(dinner.getArmor());
				this.hungry = false;
				this.countDown = 3;
				System.out.println(this.toString() + "Has eaten. Hungry again in " + countDown);
			}
		}
		else
		{
			this.countDown--;
			System.out.println(this.toString() + "Hungry in " + countDown);
		}

	}

}
