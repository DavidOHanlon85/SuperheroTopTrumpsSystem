package p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * PUT YOUR NAME HERE AND YOUR STUDENT NUMBER
 * 
 *
 */
public class StartApp {

	/**
	 * Entry point of program - no need to modify this method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		showMenu();
	}

	// TODO modify readData method to populate List appropriately - method partially
	// completed already
	// TODO add static methods to this class as required to achieve tasks outlined
	// in menu
	// TODO modify showMenu method to add calls to new methods you write to
	// accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user
	 * choices Partially implemented already requires updating to add calls to other
	 * methods written to achieve the tasks described in tasks 3-10
	 */
	public static void showMenu() {
		List<TopTrumpCard> mainDeck = readData();

		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hero Card Processing");
		do {
			System.out.println("1. (Re)read Data From File (use to restore removed card for example)");
			System.out.println("2. Play Demo Game with Current Deck");
			System.out.println("3. Display the number of Cards in the Current Deck");
			System.out.println("4. Display full details for all cards in the current Deck");
			System.out.println("5. Display summary details of the top 5 strongest Heroes in the Deck");
			System.out.println(
					"6. Display summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
			System.out.println("7. Display the card name and bio of the card/cards with the longest bio in the Deck");
			System.out.println(
					"8. Find Swapsies: Identify and display summary details of any duplicate cards in the Deck");
			System.out.println("9. Remove any duplicate cards from the Deck.");
			System.out.println(
					"10. Sort the deck from highest to lowest determined by average of the 4 main stats. \n\tDisplay summary details of all cards and include the average as part of the summary.");
			System.out.println("11. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();
			System.out.println();
			switch (option) {

			case 1:
				mainDeck = readData();
				break;
			case 2:
				System.out.println("Option currently disabled...");
				/*
				 * TODO Uncomment method call to enable this option (requires TopTrumpCard class
				 * to match expectations of Game Method to compile successfully) deliberately
				 * commented out initially to allow attempting other tasks
				 */
				CardGame.playDemo(mainDeck);
				break;
			case 3:
				System.out.println("Number of cards in current Deck: " + mainDeck.size());
				break;
			case 4:
				displayAllCardDetailsInDeckToScreen(mainDeck);
				break;
			case 5:
				List<TopTrumpCard> results = FindXStrongest(filterByCategory(mainDeck, Category.HERO), 5);
				displayAllSummaries(results);
				break;
			case 6:
				List<TopTrumpCard> results2 = filterbyAgilityRating(filterByCategory(mainDeck, Category.VILLAIN), 75);
				displayAllSummaries(results2);
				break;
			case 7:
				Collections.sort(mainDeck, new CompareByBio().reversed());
				displayNameAndBioToConsole(mainDeck);
				break;
			case 8:
				displayAllSummariesInSet(removeDuplicates(findDuplicates(mainDeck)));
				break;
			case 9:
				removeDuplicatesFromMainDeck(mainDeck);
				break;
			case 10:
				displayAllSummariesPlusAverages(mainDeck);
				break;
			case 11:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 11);
		scanner.close();
	}

	/**
	 * This method displays all summaries and averages to the console
	 * 
	 * @param results
	 */
	public static void displayAllSummariesPlusAverages(List<TopTrumpCard> results) {
		
		Collections.sort(results, new CompareByAverage().reversed());
		
		int counter = 1;

		for (TopTrumpCard c : results) {
			System.out.println(counter + ")");
			c.showSummaryDetails();
			System.out.println("Average Stat:" + c.averageOfStats());
			System.out.println();
			counter++;
		}
	}
	
	
	/**
	 * This method removes duplicates from the main deck
	 * @param mainDeck
	 */
	public static void removeDuplicatesFromMainDeck(List<TopTrumpCard> mainDeck) {

		Set<TopTrumpCard> removeDuplicates = new HashSet<TopTrumpCard>(mainDeck);
		
		mainDeck.clear();
		mainDeck.addAll(removeDuplicates);
		
	}

	/**
	 * This method displays all summaries in the set to the console
	 * @param removeDuplicates
	 */
	private static void displayAllSummariesInSet(Set<TopTrumpCard> removeDuplicates) {
		
		int counter = 1;

		for (TopTrumpCard c : removeDuplicates) {
			System.out.println(counter + ")");
			c.showSummaryDetails();
			counter++;
		}
	}

	/**
	 * This method removed duplicates from a set
	 * @param findDuplicates
	 * @return
	 */
	public static Set<TopTrumpCard> removeDuplicates(List<TopTrumpCard> findDuplicates) {
		Set<TopTrumpCard> duplicatesRemoved = new HashSet<TopTrumpCard>(findDuplicates);
		
		return duplicatesRemoved;
		
	}

	/**
	 * This method detects any duplicates, stores and returns them in a Linked List
	 * @param mainDeck
	 * @return 
	 */
	
	public static List<TopTrumpCard> findDuplicates(List<TopTrumpCard> mainDeck) {
		
		List<TopTrumpCard> results = new LinkedList<TopTrumpCard>();
		
		for (TopTrumpCard c : mainDeck) {
			int n = Collections.frequency(mainDeck, c);
			if (n > 1) {
			results.add(c);
			}
		}
		return results;
	}

	/**
	 * This method prints the name and bio of characters to console
	 * 
	 * @param mainDeck
	 */
	public static void displayNameAndBioToConsole(List<TopTrumpCard> mainDeck) {
		for (int i = 0; i < 1; i++) {
			System.out.println(mainDeck.get(i).getName() + " - " + mainDeck.get(i).getBio());
		}
	}

	private static List<TopTrumpCard> filterbyAgilityRating(List<TopTrumpCard> inputList, int boundary) {

		List<TopTrumpCard> results = new LinkedList<TopTrumpCard>();

		for (TopTrumpCard c : inputList) {
			if (c.getAgility() >= 75) {
				results.add(c);
			}
		}

		return results;

	}

	/**
	 * This method displays all summaries to the console
	 * 
	 * @param results
	 */
	public static void displayAllSummaries(List<TopTrumpCard> results) {
		int counter = 1;

		for (TopTrumpCard c : results) {
			System.out.println(counter + ")");
			c.showSummaryDetails();
			counter++;
		}
	}

	/**
	 * This method sorts the list in terms of strength (highest to lowest) and
	 * returns the target number of characters from the top of the list
	 * 
	 * @param inputList
	 * @param target
	 * @return
	 */
	private static List<TopTrumpCard> FindXStrongest(List<TopTrumpCard> inputList, int target) {

		List<TopTrumpCard> results = new LinkedList<TopTrumpCard>();

		Collections.sort(inputList, new CompareByStrength().reversed());

		for (int i = 0; i < target; i++) {
			results.add(inputList.get(i));
		}

		return results;
	}

	/**
	 * This method filters the card list by category
	 * 
	 * @param mainDeck
	 * @param category
	 * @return
	 */
	public static List<TopTrumpCard> filterByCategory(List<TopTrumpCard> mainDeck, Category category) {

		List<TopTrumpCard> localList = new LinkedList<TopTrumpCard>();

		for (TopTrumpCard c : mainDeck) {
			if (c.getCategory().equals(category)) {
				localList.add(c);
			}
		}

		return localList;

	}

	/**
	 * Displays all details of all cards in the deck to console
	 * 
	 * @param mainDeck
	 */
	public static void displayAllCardDetailsInDeckToScreen(List<TopTrumpCard> mainDeck) {
		if (mainDeck == null || mainDeck.isEmpty()) {
			throw new IllegalArgumentException("DECK NULL/ EMPTY");
		} else {
			for (TopTrumpCard c : mainDeck) {
				c.displayAllDetails();
			}
		}
	}

	/**
	 * Reads in the data from the provided csv and returns a list of TopTrumpCard
	 * objects for further processing - requires updating for full functionality
	 */
	public static List<TopTrumpCard> readData() {

		List<TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();

		File file = new File("toptrumpscards.csv"); // hard coded to specific file

		// try with resources - auto closes reader resources when finished/exception
		// occurs
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {

			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line

			while (line != null) {

				try {
					String[] splitDetails = line.split(",");
					TopTrumpCard c = createNewCard(splitDetails);
					listFromFile.add(c);
				} catch (Exception e) {
					// TODO: handle exception
				}
				line = reader.readLine();// attempt to read next line and loop again
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(listFromFile.size() + " lines read successfully");
			System.out.println(e.getMessage());
		}
		System.out.println(listFromFile.size() + " lines read successfully");
		return listFromFile;
	}

	/**
	 * This method creates a new card for each line read in from the CSV
	 * 
	 * @param splitDetails
	 * @return
	 */
	public static TopTrumpCard createNewCard(String[] splitDetails) {
		TopTrumpCard c = new TopTrumpCard(splitDetails[0], splitDetails[1], splitDetails[2],
				Category.valueOf(splitDetails[3].toUpperCase()), Integer.parseInt(splitDetails[4]),
				Integer.parseInt(splitDetails[5]), Integer.parseInt(splitDetails[6]), Integer.parseInt(splitDetails[7]),
				splitDetails[8]);
		return c;
	}

}
