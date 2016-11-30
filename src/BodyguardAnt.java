
public class BodyguardAnt implements Containing
{

	Ant safeAnt;
	Place place;
	int remainingHealth;
	
	@Override
	public boolean addCannonFodder(Place safePlace) 
	{
		boolean success = false;
		if(!safeAnt.isHasCannonFodder() && safePlace.getAnt() != null)
		{
			safeAnt.setHasCannonFodder(true);
			this.place = safePlace;
			this.safeAnt = place.getAnt();
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
	public Ant getSafeAnt() {
		// TODO Auto-generated method stub
		return null;
	}


}
