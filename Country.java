import java.util.*;

public class Country implements Comparable<Country> {
	private List<String> rawData;
	private String name;
	private int ladder, sd_of_ladder, positive_affect, negative_affect, social_support, freedom, corruption, generosity,
			gdp, healthy_life_exp;

	public String getName() {
		return this.name;
	}

	public int getLadder() {
		return ladder;
	}

	public void setLadder(int ladder) {
		this.ladder = ladder;
	}

	public int getFreedom() {
		return freedom;
	}

	public void setFreedom(int freedom) {
		this.freedom = freedom;
	}

	public int getCorruption() {
		return corruption;
	}

	public void setCorruption(int corruption) {
		this.corruption = corruption;
	}

	private boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int compareTo(Country c) {

		return this.ladder - c.getLadder();

	}

	public static Comparator<Country> CountryFreedomComparator = new Comparator<Country>() {

		public int compare(Country c1, Country c2) {

			Integer a = Integer.valueOf(c1.getFreedom());
			Integer b = Integer.valueOf(c2.getFreedom());

			return a.compareTo(b);

		}
	};
	
	public static Comparator<Country> CountryCorruptionComparator = new Comparator<Country>() {

		public int compare(Country c1, Country c2) {

			Integer a = Integer.valueOf(c1.getCorruption());
			Integer b = Integer.valueOf(c2.getCorruption());

			return a - b;

		}
	};
	
	public static Comparator<Country> CountryLadderComparator = new Comparator<Country>() {

		public int compare(Country c1, Country c2) {

			Integer a = Integer.valueOf(c1.getLadder());
			Integer b = Integer.valueOf(c2.getLadder());

			return a - b;

		}
	};

	public Country(List<String> rawData) {
		// System.out.println("rawData.size() = " + rawData.size());
		this.rawData = rawData;
		
		

		if (rawData.size() == 11) {
			this.name = rawData.get(0);
			
			if (tryParseInt(rawData.get(1))) {
				this.ladder = Integer.parseInt(rawData.get(1));
				//if(this.ladder == 0) { this.ladder = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(2))) {
				this.sd_of_ladder = Integer.parseInt(rawData.get(2));
				//if(this.sd_of_ladder == 0) { this.sd_of_ladder = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(3))) {
				this.positive_affect = Integer.parseInt(rawData.get(3));
				//if(this.positive_affect == 0) { this.positive_affect = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(4))) {
				this.negative_affect = Integer.parseInt(rawData.get(4));
				//if(this.negative_affect == 0) { this.negative_affect = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(5))) {
				this.social_support = Integer.parseInt(rawData.get(5));
				//if(this.social_support == 0) { this.social_support = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(6))) {
				this.freedom = Integer.parseInt(rawData.get(6));
				//if(this.freedom == 0) { this.freedom = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(7))) {
				this.corruption = Integer.parseInt(rawData.get(7));
				//if(this.corruption == 0) { this.corruption = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(8))) {
				this.generosity = Integer.parseInt(rawData.get(8));
				//if(this.generosity == 0) { this.generosity = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(9))) {
				this.gdp = Integer.parseInt(rawData.get(9));
				//if(this.gdp == 0) { this.gdp = Integer.MAX_VALUE; }
			}
			if (tryParseInt(rawData.get(10))) {
				this.healthy_life_exp = Integer.parseInt(rawData.get(10));
				//if(this.healthy_life_exp == 0) { this.healthy_life_exp = Integer.MAX_VALUE; }
			}

		}

		else {
			System.out.println("WARNING: rawDatasize = " + rawData.size());
			System.out.println(rawData);
			this.name = "EMPTY";
		}
		
		if(this.corruption == 0) { this.corruption = Integer.MAX_VALUE; }
		if(this.freedom == 0) { this.freedom = Integer.MAX_VALUE; }
		if(this.ladder == 0) { this.ladder = Integer.MAX_VALUE; }
	}

	public String toString() {
		String s = new String();
		for (int i = 0; i < this.rawData.size(); i++)
			s += this.rawData.get(i) + " ";
		return s;
	}
}
