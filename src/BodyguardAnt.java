
public class BodyguardAnt extends Ant implements Containing
{
	
	private Ant safeAnt = null;
	
	
	public BodyguardAnt() 
	{
		super(true, 2, 2);
	}

	@Override
	public boolean addSafeAnt(Ant ant) 
	{
		boolean success = false;
		if(this.safeAnt == null && !ant.isCannonFodder)
		{
			this.safeAnt = ant;
			success = true;
		}
		return success;
	}

	@Override
	public boolean removeSafeAnt() 
	{
		boolean success = false;
		if(this.safeAnt != null)
		{
			place.removeInsect(safeAnt);
		}
		return success;
	}

	@Override
	public Ant getSafeAnt() 
	{
		return this.safeAnt;
	}

	@Override
	public void act(AntColony colony) 
	{

	}

	@Override
	public void sacrifice() 
	{
		this.place = null;
	}


}
