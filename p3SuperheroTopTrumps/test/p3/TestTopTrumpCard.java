package p3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTopTrumpCard {

	String validNameLow, validNameMid, validNameHigh;
	String invalidNameLow, invalidNameHigh;

	String validImageFileNameLow, validImageFileNameMid, validImageFileNameHigh;
	String invalidImageFileNameLow, invalidImageFileNameHigh, invalidImageFileNameWrongEnding;

	Category hero, villain;

	int validSSAILow, validSSAIMid, validSSAIHigh;
	int invalidSSAILow, invalidSSAIHigh;

	String validBioLow, validBioHigh;

	TopTrumpCard c;

	@BeforeEach
	void setUp() throws Exception {

		validNameLow = "x".repeat(1);
		validNameMid = "x".repeat(15);
		validNameHigh = "x".repeat(30);

		invalidNameLow = "x".repeat(0);
		invalidNameHigh = "x".repeat(31);

		validImageFileNameLow = "i.jpg";
		validImageFileNameMid = "helloworld.jpg";
		validImageFileNameHigh = "helloworldhelloworldhelloi.jpg";

		invalidImageFileNameLow = ".jpg";
		invalidImageFileNameHigh = "helloworldhelloworldhelloip.jpg";
		invalidImageFileNameWrongEnding = "hello.ljpg";

		hero = Category.HERO;
		villain = Category.VILLAIN;

		validSSAILow = 0;
		validSSAIMid = 50;
		validSSAIHigh = 100;

		invalidSSAILow = -1;
		invalidSSAIHigh = 101;

		validBioLow = "hello";
		validBioHigh = "hello".repeat(30);

		c = new TopTrumpCard(validNameLow, validNameLow, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);

	}

	@Test
	void testTopTrumpCardConstructorWithArgs() {
		assertEquals(validNameLow, c.getName());
		assertEquals(validNameLow, c.getRealName());
		assertEquals(validImageFileNameLow, c.getImageFileName());
		assertEquals(hero, c.getCategory());
		assertEquals(validSSAILow, c.getSpeed());
		assertEquals(validSSAILow, c.getStrength());
		assertEquals(validSSAILow, c.getAgility());
		assertEquals(validSSAILow, c.getIntelligence());
		assertEquals(validBioLow, c.getBio());
	}
	
	@Test
	void testTopTrumpCardConstructorWithArgsInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(null, validNameLow, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("NAME IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(invalidNameLow, validNameLow, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(invalidNameHigh, validNameLow, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, null, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("REAL NAME IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, invalidNameLow, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID REAL NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, invalidNameHigh, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID REAL NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, null, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("IMAGE FILE NAME IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, invalidImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID FILE NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, invalidImageFileNameHigh, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID FILE NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, invalidImageFileNameWrongEnding, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID FILE NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, validImageFileNameHigh, null, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("CATEGORY IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, validImageFileNameHigh, hero, invalidSSAILow, validSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID SPEED", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, validImageFileNameHigh, hero, validSSAILow, invalidSSAILow,
				validSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID STRENGTH", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, validImageFileNameHigh, hero, validSSAILow, validSSAILow,
				invalidSSAILow, validSSAILow, validBioLow);
		});
		
		assertEquals("INVALID AGILITY", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, validImageFileNameHigh, hero, validSSAILow, validSSAILow,
				validSSAILow, invalidSSAILow, validBioLow);
		});
		
		assertEquals("INVALID INTELLIGENCE", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, validImageFileNameHigh, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, null);
		});
		
		assertEquals("BIO IS NULL", exp.getMessage());
		
	}

	@Test
	void testSetGetNameValid() {
		c.setName(validNameLow);
		assertEquals(validNameLow, c.getName());
		
		c.setName(validNameMid);
		assertEquals(validNameMid, c.getName());
		
		c.setName(validNameHigh);
		assertEquals(validNameHigh, c.getName());
	}

	@Test
	void testSetGetNameInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setName(null);
		});
		
		assertEquals("NAME IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setName(invalidNameLow);
		});
		
		assertEquals("INVALID NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setName(invalidNameHigh);
		});
		
		assertEquals("INVALID NAME", exp.getMessage());
		
	}

	@Test
	void testSetGetRealName() {
		c.setRealName(validNameLow);
		assertEquals(validNameLow, c.getRealName());
	
		c.setRealName(validNameMid);
		assertEquals(validNameMid, c.getRealName());
		
		c.setRealName(validNameHigh);
		assertEquals(validNameHigh, c.getRealName());
	}

	@Test
	void testSetGetRealNameInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setRealName(null);
		});
		
		assertEquals("REAL NAME IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setRealName(invalidNameLow);
		});
		
		assertEquals("INVALID REAL NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setRealName(invalidNameHigh);
		});
		
		assertEquals("INVALID REAL NAME", exp.getMessage());
		
	}

	@Test
	void testSetGetImageFileName() {
		c.setImageFileName(validImageFileNameLow);
		assertEquals(validImageFileNameLow, c.getImageFileName());
		
		c.setImageFileName(validImageFileNameMid);
		assertEquals(validImageFileNameMid, c.getImageFileName());
		
		c.setImageFileName(validImageFileNameHigh);
		assertEquals(validImageFileNameHigh, c.getImageFileName());
	}

	@Test
	void testSetGetImageFileNameInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setImageFileName(null);
		});
		
		assertEquals("IMAGE FILE NAME IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setImageFileName(invalidImageFileNameLow);
		});
		
		assertEquals("INVALID FILE NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setImageFileName(invalidImageFileNameHigh);
		});
		
		assertEquals("INVALID FILE NAME", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setImageFileName(invalidImageFileNameWrongEnding);
		});
		
		assertEquals("INVALID FILE NAME", exp.getMessage());
	}

	@Test
	void testSetGetCategory() {
		c.setCategory(hero);
		assertEquals(Category.HERO, c.getCategory());
		
		c.setCategory(villain);
		assertEquals(Category.VILLAIN, c.getCategory());
	}

	@Test
	void testGetSetCategoryInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			c.setCategory(null);
		});
		
		assertEquals("CATEGORY IS NULL", exp.getMessage());
	}

	@Test
	void testSetGetSpeed() {
		c.setSpeed(validSSAILow);
		assertEquals(validSSAILow, c.getSpeed());
		
		c.setSpeed(validSSAIMid);
		assertEquals(validSSAIMid, c.getSpeed());
		
		c.setSpeed(validSSAIHigh);
		assertEquals(validSSAIHigh, c.getSpeed());
	}

	@Test
	void testSetGetSpeedInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setSpeed(invalidSSAILow);
		});
		
		assertEquals("INVALID SPEED", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setSpeed(invalidSSAIHigh);
		});
		
		assertEquals("INVALID SPEED", exp.getMessage());
		
	}

	@Test
	void testSetGetStrength() {
		c.setStrength(validSSAILow);
		assertEquals(validSSAILow, c.getStrength());
		
		c.setStrength(validSSAIMid);
		assertEquals(validSSAIMid, c.getStrength());
		
		c.setStrength(validSSAIHigh);
		assertEquals(validSSAIHigh, c.getStrength());
	}

	@Test
	void testSetGetStrengthInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setStrength(invalidSSAILow);
		});
		
		assertEquals("INVALID STRENGTH", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setStrength(invalidSSAIHigh);
		});
		
		assertEquals("INVALID STRENGTH", exp.getMessage());
	}

	@Test
	void testSetGetAgility() {
		c.setAgility(validSSAILow);
		assertEquals(validSSAILow, c.getAgility());
		
		c.setAgility(validSSAIMid);
		assertEquals(validSSAIMid, c.getAgility());
		
		c.setAgility(validSSAIHigh);
		assertEquals(validSSAIHigh, c.getAgility());
	}

	@Test
	void testSetGetAgilityInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setAgility(invalidSSAILow);
		});
		
		assertEquals("INVALID AGILITY", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setAgility(invalidSSAIHigh);
		});
		
		assertEquals("INVALID AGILITY", exp.getMessage());
	}

	@Test
	void testSetGetIntelligence() {
		c.setIntelligence(validSSAILow);
		assertEquals(validSSAILow, c.getIntelligence());
		
		c.setIntelligence(validSSAIMid);
		assertEquals(validSSAIMid, c.getIntelligence());
		
		c.setIntelligence(validSSAIHigh);
		assertEquals(validSSAIHigh, c.getIntelligence());
	}

	@Test
	void testSetGetIntelligenceInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setIntelligence(invalidSSAILow);
		});
		
		assertEquals("INVALID INTELLIGENCE", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setIntelligence(invalidSSAIHigh);
		});
		
		assertEquals("INVALID INTELLIGENCE", exp.getMessage());
	}

	@Test
	void testGetBio() {
		c.setBio(validBioLow);
		assertEquals(validBioLow, c.getBio());
		
		c.setBio(validBioHigh);
		assertEquals(validBioHigh, c.getBio());
		
	}

	@Test
	void testSetGetBioInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			c = new TopTrumpCard(validNameHigh, validNameHigh, validImageFileNameHigh, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAILow, null);
		});
		
		assertEquals("BIO IS NULL", exp.getMessage());

	}

	@Test
	void testGetMaxStatIDValid() {
		c = new TopTrumpCard(validNameLow, validNameLow, validImageFileNameLow, hero, 1, 2,
				100, 1, validBioLow);
		
		assertEquals(2, c.getMaxStatID());
		
		c = new TopTrumpCard(validNameLow, validNameLow, validImageFileNameLow, hero, 3, 2,
				3, 1, validBioLow);
		
		assertEquals(0, c.getMaxStatID());
	}

	@Test
	void testGetStatScore() {
		c = new TopTrumpCard(validNameLow, validNameLow, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAILow, validSSAIHigh, validBioLow);
		
		assertEquals(100, c.getStatScore(3));
		
		c = new TopTrumpCard(validNameLow, validNameLow, validImageFileNameLow, hero, validSSAILow, validSSAILow,
				validSSAIMid, validSSAILow, validBioLow);
		
		assertEquals(50, c.getStatScore(2));
		
	}
	
	@Test
	void testGetStatScoreInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.getStatScore(5);
		});
		
		assertEquals("INVALID STAT INPUT", exp.getMessage());
		
	}


}
