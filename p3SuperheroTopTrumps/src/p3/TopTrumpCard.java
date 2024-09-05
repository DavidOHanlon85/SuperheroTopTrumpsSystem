/**
 * 
 */
package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 
 */
public class TopTrumpCard {

	// Instance Variables

	private String name;
	private String realName;
	private String imageFileName;
	private Category category;
	private int speed;
	private int strength;
	private int agility;
	private int intelligence;
	private String bio;

	// Constructor

	/**
	 * Constructor with args
	 * 
	 * @param name
	 * @param realName
	 * @param imageFileName
	 * @param category
	 * @param speed
	 * @param strength
	 * @param agility
	 * @param intelligence
	 * @param bio
	 */
	public TopTrumpCard(String name, String realName, String imageFileName, Category category, int speed, int strength,
			int agility, int intelligence, String bio) throws IllegalArgumentException {
		this.setName(name);
		this.setRealName(realName);
		this.setImageFileName(imageFileName);
		this.setCategory(category);
		this.setSpeed(speed);
		this.setStrength(strength);
		this.setAgility(agility);
		this.setIntelligence(intelligence);
		this.setBio(bio);
	}

	// Getters and Setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name with business rules that the name must be between 1 - 30 characters
	 * (inclusive)
	 * 
	 * @param name
	 * @throws IllegalArgumentException if null or fails to comply with length rules
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("NAME IS NULL");
		}

		if (name.length() >= 1 && name.length() <= 30) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("INVALID NAME");
		}

	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * Sets real name with business rules that the name must be between 1 - 30
	 * characters (inclusive)
	 * 
	 * @param realName
	 * @throws IllegalArgumentException if null or fails to comply with length rules
	 */
	public void setRealName(String realName) throws IllegalArgumentException {
		if (realName == null) {
			throw new IllegalArgumentException("REAL NAME IS NULL");
		}

		if (realName.length() >= 1 && realName.length() <= 30) {
			this.realName = realName;
		} else {
			throw new IllegalArgumentException("INVALID REAL NAME");
		}
	}

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * Sets image file name with business rules that the name must be between 5 - 30
	 * characters (inclusive) and finish with ".jpg"
	 * 
	 * @param imageFileName
	 * @throws IllegalArgumentException
	 */
	public void setImageFileName(String imageFileName) throws IllegalArgumentException {

		if (imageFileName == null) {
			throw new IllegalArgumentException("IMAGE FILE NAME IS NULL");
		}

		if (imageFileName.length() >= 5 && imageFileName.length() <= 30
				&& imageFileName.substring(imageFileName.length() - 4).equalsIgnoreCase(".jpg")) {
			this.imageFileName = imageFileName;
		} else {
			throw new IllegalArgumentException("INVALID FILE NAME");
		}
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * 
	 * @param category
	 * @throws IllegalArgumentException if null
	 */
	public void setCategory(Category category) throws IllegalArgumentException {
		if (category == null) {
			throw new IllegalArgumentException("CATEGORY IS NULL");
		}
		this.category = category;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Sets speed to between 0 - 100 (inclusive)
	 * 
	 * @param speed
	 * @throws IllegalArgumentException if outside of range
	 */
	public void setSpeed(int speed) throws IllegalArgumentException {
		if (speed >= 0 && speed <= 100) {
			this.speed = speed;
		} else {
			throw new IllegalArgumentException("INVALID SPEED");
		}

	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Sets strength to between 0 - 100 (inclusive)
	 * 
	 * @param strength
	 * @throws IllegalArgumentException if outside of range
	 */
	public void setStrength(int strength) throws IllegalArgumentException {

		if (strength >= 0 && strength <= 100) {
			this.strength = strength;
		} else {
			throw new IllegalArgumentException("INVALID STRENGTH");
		}
	}

	/**
	 * @return the agility
	 */
	public int getAgility() {
		return agility;
	}

	/**
	 * Sets agility to between 0 - 100 (inclusive)
	 * 
	 * @param agility
	 * @throws IllegalArgumentException if outside of range
	 */
	public void setAgility(int agility) throws IllegalArgumentException {

		if (agility >= 0 && agility <= 100) {
			this.agility = agility;
		} else {
			throw new IllegalArgumentException("INVALID AGILITY");
		}
	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * Sets intelligence to between 0 - 100 (inclusive)
	 * 
	 * @param intelligence
	 * @throws IllegalArgumentException if outside of range
	 */
	public void setIntelligence(int intelligence) throws IllegalArgumentException {

		if (intelligence >= 0 && intelligence <= 100) {
			this.intelligence = intelligence;
		} else {
			throw new IllegalArgumentException("INVALID INTELLIGENCE");
		}
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Sets bio
	 * 
	 * @param bio
	 * @throws IllegalArgumentException if null
	 */
	public void setBio(String bio) throws IllegalArgumentException {
		if (bio == null) {
			throw new IllegalArgumentException("BIO IS NULL");
		} else {
			this.bio = bio;
		}

	}

	// Methods

	/**
	 * This method returns the index of the max stat value - 0 (Speed), 1
	 * (Intelligence), 2 (Strength), 3 (Intelligence)
	 * 
	 * @return
	 */

	public int getMaxStatID() {

		Integer[] statValues = { speed, strength, agility, intelligence };

		List<Integer> stats = Arrays.asList(statValues);

		int maxValue = Collections.max(stats);

		return stats.indexOf(maxValue);

	}

	/**
	 * This method returns the actual value of the highest stat in a card based on -
	 * 0 (Speed), 1 (Intelligence), 2 (Strength), 3 (Intelligence)
	 * 
	 * @param statChoice
	 * @return
	 * @throws IllegalArgumentException if input is not 0 - 3
	 */

	public int getStatScore(int statChoice) throws IllegalArgumentException {

		if (statChoice < 0 || statChoice > 3) {
			throw new IllegalArgumentException("INVALID STAT INPUT");
		}

		Integer[] statValues = { speed, strength, agility, intelligence };

		return statValues[statChoice];

	}

	/**
	 * This method displays all details from a card
	 */
	public void displayAllDetails() {
		System.out.println("name:           " + getName());
		System.out.println("realname:       " + getRealName());
		System.out.println("filename:       " + getImageFileName());
		System.out.println("category:       " + getCategory());
		System.out.println("speed:          " + getSpeed());
		System.out.println("stength:        " + getStrength());
		System.out.println("agility:        " + getAgility());
		System.out.println("intelligence:   " + getIntelligence());
		System.out.println("bio:            " + getBio());
		System.out.println();

	}
	
	public void showSummaryDetails() {
		System.out.println(name + "/" + realName + "(" + category + ")");
		System.out.printf("sp: %d | st: %d | ag: %d | in %d\n", speed, strength, agility, intelligence);
	} 
	
	public double averageOfStats() {
		
		double total = speed + strength + agility + intelligence;
		double average = total / 4;
		
		return average;
	}
	
	// Equals and Hash Methods

	@Override
	public int hashCode() {
		return Objects.hash(agility, bio, category, imageFileName, intelligence, name, realName, speed, strength);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopTrumpCard other = (TopTrumpCard) obj;
		return agility == other.agility && Objects.equals(bio, other.bio) && category == other.category
				&& Objects.equals(imageFileName, other.imageFileName) && intelligence == other.intelligence
				&& Objects.equals(name, other.name) && Objects.equals(realName, other.realName) && speed == other.speed
				&& strength == other.strength;
	}
	
	
	
}
