/*
 * Name: Niall Curtis
 * Student number: C1623580
 */

public class Animal {

	// Private Fields
    private String animalName;

    // We don't need a field for available animals, as we have a method to calculate it using these two.
    private int totalAnimals;
    private int loanedAnimals;
	 	
	public Animal( String inName, int inTotalNumAnimals ) {

		// If less than 1 animal is entered, throw an exception, can't have 0 animals.
		if (inTotalNumAnimals < 1) {
			throw new IllegalArgumentException("Invalid Number of Animals Entered.");
		}

		this.animalName = inName;
		this.totalAnimals = inTotalNumAnimals;
		this.loanedAnimals = 0;
	}

	public String getName() {
		return animalName;
	}

	public int getTotalAnimals() {

		return totalAnimals;
	}

	// Aforementioned method to return available animals.
	public int getAvailableAnimals() {
		return totalAnimals - loanedAnimals;
	}

	// Checks if the number of available animals is greater than 1, or an exception is thrown as its impossible to return
	// an animal if none are available.
	public void loanAnimal() {

		if (getAvailableAnimals() < 1) {
			throw new IllegalStateException("No Animals Available to Loan.");
		}

		loanedAnimals++;
	}


	// Checks if the number of loaned animals is greater than 1, or an exception is thrown as its impossible to return
	// an animal if none are on loan.
	public void returnAnimal() {

		if (this.loanedAnimals < 1) {
			throw new IllegalStateException("No Animals are on Loan.");
		}

		loanedAnimals--;
	}
}


