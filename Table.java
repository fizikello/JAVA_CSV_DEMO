import java.util.*; 

public class Table{
	private List<Country> countries = new ArrayList<>();

	public List<Country> getCountries() {
		return countries;
	}

	public Table() {
	}

	public void add(Country c) {
		countries.add(c);
	}

	public int getSize() {
		return countries.size();
	}

	public Country get(int x) {
		return countries.get(x);
	}

	public String toString() {
		String s = new String();
		for (int i = 0; i < countries.size(); i++)
			s += countries.get(i).getName() + "\n";
		return s;
	}
	
	public String showElements(int n)
	{
		String s = new String("");
		
		if( n > 0 && n < this.countries.size()) 
		{
			for(int i = 0; i < n ; i++)
				s += countries.get(i).getName() + "\n";
		}		
		return s;
	}
	
	public void sortBy( String s ) 
	{
		if(s.compareTo("Corruption") == 0)
		Collections.sort(countries, Country.CountryCorruptionComparator);
		
		else if(s.compareTo("Freedom") == 0)
			Collections.sort(countries, Country.CountryFreedomComparator);
		
		else if(s.compareTo("Ladder") == 0)
		Collections.sort(countries, Country.CountryLadderComparator);
		
		else System.out.println("Can not sort by this quantity!");
	}

}
