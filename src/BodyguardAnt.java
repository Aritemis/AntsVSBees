
public class BodyguardAnt implements Containing
{

	private Ant safeAnt;
	private Place place;
	private int remainingHealth;
	
	@Override
	public boolean addCannonFodder(Place safePlace) 
	{
		boolean success = false;
		if(!safeAnt.isHasCannonFodder() && safePlace.getAnt() != null)
		{
			safeAnt.setHasCannonFodder(true);
			this.place = safePlace;
			this.safeAnt = place.getAnt();
			this.remainingHealth = 2;
		}
		return success;
	}

	@Override
	public boolean removeCannonFodder(Place unsafePlace) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ant getSafeAnt() 
	{
		return this.place.getAnt();
	}

	public int getRemainingHealth() 
	{
		return remainingHealth;
	}

	public void setRemainingHealth(int remainingHealth) 
	{
		this.remainingHealth = remainingHealth;
	}


}
