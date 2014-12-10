package l010_Beans

import static groovy.test.GroovyAssert.shouldFail

import org.junit.Test
/**
 *
 *
 * TODO 1.) Create a Groovy bean called "GroovyPerson" with the properties "firstName", "lastName" and "ssn"
 * This should solve the compile errors in this class
 * TODO 2.) Ensure that all tests are running successfully
 */
 
class Lesson {

	@Test
	void test01_IntroToGroovyBeans() {
		// JavaBeans (or POJOs) are simple Java objects with getters (getX) and setters (setX) for its members
		JavaPerson javaPerson = new JavaPerson("Argus", "Filch", "1234")

		// Groovy introduces an easier way to create JavaBeans. They're called GroovyBeans.
		// Have a read here: http://groovy.codehaus.org/Groovy+Beans
		GroovyPerson groovyPerson = new GroovyPerson('Harry', 'Potter', '3322')

		// Explore the differences between JavaPerson and GroovyPerson and read some of the user guide above.
		// When you're done, add the necessary getters to get the respective first names
		// Hint: The reason you don't have a place to add code in Groovy is because you don't have to!
		def javaFirstName
		def groovyFirstName
		// ------------ START EDITING HERE ----------------------
		javaFirstName = javaPerson.getFirstName()
		groovyFirstName = groovyPerson.firstName
		// ------------ STOP EDITING HERE  ----------------------

		assert javaFirstName == 'Argus'
		assert groovyFirstName == 'Harry'
	}

	@Test
	void test02_ReadOnlyFieldInGroovyBean() {
		// Groovy automatically generates getters/setters for you. Mark the field ssn with 'final'
		// to prevent Groovy from doing that

		// Try to modify Ken's ssn. You should get a ReadOnlyPropertyException.
		def person = new GroovyPerson('Ken', 'Kousen', '7878')
		def failed = true
		shouldFail (ReadOnlyPropertyException) {
			// ------------ START EDITING HERE ----------------------
			person.ssn = '1234'
			// ------------ STOP EDITING HERE  ----------------------
			failed = false
		}

		assert failed

		// The code wrapping your additions verifies that the ReadOnlyProperty exception has been thrown.
		// The curly brackets ({}) represent a closure. You learn later what this means.
	}
	void test03_NamedParametersInConstructors() {
		// To enhance code clarity, Groovy allows using named arguments in methods.
		def quote = new SimpleGroovyBean(title: 'Quote object',
		data: "Never trust anything that can think for itself if you can't see where it keeps its brain")

		// If you pay close attention, you'll see that 'data' is actually untyped.
		// Practically, it's the same as specifying an 'Object' as the type.

		// Create a SimpleGroovyBean using named arguments, to represent a transaction with -30 as its data.
		def transaction
		// ------------ START EDITING HERE ----------------------
		transaction = new SimpleGroovyBean(title: 'Transaction', data: -30)
		// ------------ STOP EDITING HERE  ----------------------

		assert transaction.data == -30
	}
	@Test
	void test04_DefaultValues() {

		// Once you've learned how to use default values, modify the Greeter
		// class to set name to 'Anonymous' if no name has been specified.
		def g = new Greeter()
		assert 'Hello world!' == g.greeter()
		// right most parameter with default value is eliminated first.
		assert 'Moin world!' == g.greeter('Moin')
		assert 'Moin Hamburg' == g.greeter('Moin', ',Hamburg')
		assert nameObject.name == 'Anonymous'
	}

	@Test
	void test04_throwsNull() {
		def myString = ''
		// write a test using the shouldFail method to validate that the
		// call of methods on myString throws an NPE
		// ------------ START EDITING HERE ----------------------
		shouldFail {
			myString.toString()
		}
		// ------------ STOP EDITING HERE  ----------------------
	}

}