import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		String COMMA_DELIMITER = ",";
		int RECORD_LENGTH = 11;
		int POLAND_LADDER = -1;

		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("D:/pobrane/happiness.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {

				String[] values = line.split(COMMA_DELIMITER, -1);
				/*
				 * System.out.print(values.length + "\t"); for( String s : values ) {
				 * System.out.print(s + " "); } System.out.println();
				 */
				if (values.length == RECORD_LENGTH)
					records.add(Arrays.asList(values));
			}
		}

		Table t = new Table();

		for (int i = 0; i < records.size(); i++) {

			Country c = new Country(records.get(i));
			t.add(c);

			if (c.getName().compareTo("Poland") == 0) {
				POLAND_LADDER = c.getLadder();
			}
		}

		t.sortBy("Ladder");

		System.out.println("-----------------------------------");
		System.out.println("List after LADDER sorting: " + t.getSize());

		for (int i = 0; i < t.getSize(); i++) {
			if (t.getCountries().get(i).getName().compareTo("Poland") != 0)
				System.out.println(t.getCountries().get(i).getName());
			else
				break;
		}

		t.sortBy("Freedom");

		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("List after FREEDOM sorting: " + t.getSize());
		System.out.println(t.showElements(5));

		t.sortBy("Corruption");

		System.out.println("-----------------------------------");
		System.out.println("List after CORRUPTION sorting: " + t.getSize());
		System.out.println(t.showElements(5));

	}
}
