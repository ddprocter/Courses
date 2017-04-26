package Homework1;

/**
 * @author dave
 * Country class
 *
 */
public class Country {

	private String name = "";
	private String population = "";
	private String capital = "";

	
	/**
	 * @return name - Name of the country.  I dunno, Sparta maybe. 
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param Name of the country. You know, like, Narnia.
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return population - Population of the country.  In humans.
	 */
	public String getPopulation() {
		return population;
	}



	/**
	 * @param population Population of the county. Seriously, count humans only please. 
	 */
	public void setPopulation(String population) {
		this.population = population;
	}



	/**
	 * @return capital - Place where gladhands shake bigwigs.
	 */
	public String getCapital() {
		return capital;
	}



	/**
	 * @param capital Also known as El Capital.
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}


	
}
