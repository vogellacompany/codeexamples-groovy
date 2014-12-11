package l020_NumbersRanges

import org.junit.Test



/**
 * Lession- Groovy Numbers and Operator overload
 *
 */

class Lession  {


	@Test
    void test01_Numbers() {
		// Use the times method to calculate the sum of the numbers until 15
		// you can use "it" to get the current value of the number in the method body
		int result = 0
		// ------------ START EDITING HERE ----------------------
		15.times {result += it}
		// ------------ STOP EDITING HERE  ----------------------
		assert result == 105
    }

	@Test
	void test02_Numbers() {
		// Use the times method to calculate the sum of the numbers between 71 and 84
		// you can use "it" to get the current value of the number in the method body
		int result = 0
		// ------------ START EDITING HERE ----------------------
		71.upto(84) {result += it}
		// ------------ STOP EDITING HERE  ----------------------
		assert result == 1085
	}

	@Test
	void test03_LeftShift() {
		// Use the left-shift operator to change number to 8
		// Hint this is a byte-shift
		int number= 1
		// ------------ START EDITING HERE ----------------------
		number = number << 3
		// ------------ STOP EDITING HERE  ----------------------
		assert number == 8

		// Use the left-shift operator to append to text the String "Hello"
		// Hint this is a byte-shift
		String text= "Test"
		// ------------ START EDITING HERE ----------------------
		text = text << "Hello"
		// ------------ STOP EDITING HERE  ----------------------
		assert text == "TestHello"

		// Append 5 times hello
		String result= "Test"
		// ------------ START EDITING HERE ----------------------
//		1.upto(5) {}
		// OR
		5.times {result = result  << "Hello"}
		// ------------ STOP EDITING HERE  ----------------------
		assert result == "TestHelloHelloHelloHelloHello"


	}

	@Test
	void test04_operatorOverloading() {
		def p1 = new GroovyPerson();
		def p2 = new GroovyPerson();

		def result = p1 + p2

		assert result instanceof l020_NumbersRanges.GroovyCouple
	}

	@Test
	void test05_createSteps() {
		def numbers = []
		// Use the step method
		// ------------ START EDITING HERE ----------------------
		1.0.step(2, 0.1) { numbers << it }
		// ------------ STOP EDITING HERE  ----------------------
		assert numbers.join(",") == '1.0,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8,1.9' //notice how the first value changed to 1.0

	}


}