/**
 * @author Ariana Fairbanks
 */

public class AntsVsSomeBees
{
	public static void main(String[] args)
	{
		AntColony colony = new AntColony(5, 8, 3, 2);
		Hive hive = Hive.makeFullHive(); //specify the attackers (the hive)
		new AntGame(colony,hive); //launch the game
	}
}
