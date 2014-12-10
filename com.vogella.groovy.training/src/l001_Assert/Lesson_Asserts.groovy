package l001_Assert

import static groovy.test.GroovyAssert.shouldFail

import org.junit.Test


class Lesson_Asserts {

@Test
    // TODO make this test pass
    void test01_AssertionsAndSomeSyntax() {

        // In this exercise you write your first Groovy statements leaving out the semicolon
        boolean assertion = false
        def hello = "Hola"

        // Assign our variables the required values to continue...
        // ------------ START EDITING HERE ----------------------
		hello = "Hello"
		assertion = true
        // ------------ STOP EDITING HERE  ----------------------

        assert assertion, 'Assign "true" to the "assertion" variable to proceed'
        assert hello == "Hello", 'Modify "Hola" to "Hello" to proceed'
    }

   // TODO Create a JUnit 4 test method construct an instance of JavaPerson and use the "assert" method to validate
   // that the person is not null
	@Test
	void useAssert() {
		// ------------ START EDITING HERE ----------------------

		// ------------ STOP EDITING HERE  ----------------------
	}

   // TODO Create another JUnit 4 test method, set one of the properties to null and use the shouldFail statement
   //      to valid that your receive an NPE if you use this field
	@Test
	void useshouldFail() {
		// ------------ START EDITING HERE ----------------------

		// ------------ STOP EDITING HERE  ----------------------
	}

}