package l040_GroovyStrings

import org.junit.Test


/**
 * Lession- Groovy Strings
 *
 */

class Lession  {


	@Test
    void test01_GStrings() {
        // Groovy allows you to use either regular quotes (') or double-quotes (") for String declarations.
        // The difference is that double-quotes create a GString, which is a super-powered String.

        // GStrings allow you to use the ${} syntax within them. The ${} can contain any valid Groovy expression.
        def name = 'George'
        def greeting = "Hello ${name}, how are you?" // 'Hello George, how are you?
        def math = "The result of 4 + 4 is ${4 + 4}" // 'The result of 4 + 4 is 8'

        // Create the target string based on greeting as input: "The size of the string 'Hello George, how are you?' is 26"
		// Use the ${} mechanism. Remember that ${} can contain method calls too!
        String result
        // ------------ START EDITING HERE ----------------------
        result = "The size of the string '${greeting}' is ${greeting.size()}"
        // ------------ STOP EDITING HERE  ----------------------

        assert result == "The size of the string 'Hello George, how are you?' is 26"
    }

    @Test
    void test02_Palindrome() {
        // Write the isPalindrome construct which checks if a String is a palindrome, e.g., that the letters are reverse the same at not reverse
        // Ignore whitespace

        def palindrome = "abba ab ba"


        assert isPalindrome (palindrome)
    }

	@Test
	void test02_MultilineStrings() {
		// With Groovy it's possible to declare multiline strings using either ''' or """ (Multiline GString).
        // More info at http://groovy.codehaus.org/Strings+and+GString#StringsandGString-Multi-linestrings

        String signs = '+, \\, and others'

        // Create the string below with Groovy
        String javaString = "In Java a multiline string\n" +
                "requires using special signs such as " + signs + "\n" +
                "and can become difficult to maintain"
        String groovyString
        // ------------ START EDITING HERE ----------------------
        groovyString = """In Java a multiline string
requires using special signs such as $signs
and can become difficult to maintain"""
        // ------------ STOP EDITING HERE  ----------------------
        assert groovyString == javaString
    }


	@Test
    void test05_ElvisAndSafeNavigation() {
        // preparation code for the examples that follow. We'll get to this code in later exercises.
        User player = new User('Ronaldo', 'Nazário de Lima', 'ron', null)
        UserService userServiceWithUserLoggedIn = [getLoggedInUser: { player }] as UserService
        UserService userServiceWithoutLoggedInUser = [getLoggedInUser: { null }] as UserService

        // Groovy introduces two convenient operators for dealing with nulls: elvis (?:) and safe navigation (?.)
        // Read all about it at http://groovy.codehaus.org/Operators#Operators-ElvisOperator

        // Assume we have a User object that may or may not contain a first name and an address.
        // In Java, we could end up with the following code:

        String firstName = player.getFirstName()
        String javaDisplayName = firstName == null ? player.getUsername() : firstName
        String javaCity = ""
        if (player.getAddress() != null && player.getAddress().getCity() != null) {
            // Be careful of NullPointerExceptions
            javaCity = player.getAddress().getCity()
        }

        // With Groovy's new operators, this becomes much simpler:
        def groovyDisplayName = player.firstName ?: player.username
        def groovyCity = player?.address?.city

        // Using your newly acquired knowledge, fix the createMessageForUser method below
        // so that anonymous users get 'Hello Anonymous!' and logged in users get 'Hello <first name>'
        // You should use userService.getLoggedInUser() as well.
        assert createMessageForUser(userServiceWithUserLoggedIn) == 'Hello Ronaldo!'
        assert createMessageForUser(userServiceWithoutLoggedInUser) == 'Hello Anonymous!'
    }

	boolean isPalindrome (String s) {
		// ------------ START EDITING HERE ----------------------
		String l = s.replaceAll(/\w/, "")
		l.reverse()== l
		// ------------ STOP EDITING HERE  ----------------------
	}
    private String createMessageForUser(UserService userService) {
        def message
        // ------------ START EDITING HERE ----------------------
        message = "Hello ${userService.loggedInUser?.firstName ?: 'Anonymous'}!"
        // ------------ STOP EDITING HERE  ----------------------

        // note how Groovy doesn't require the 'return' keyword! It will simply return the last expression.
        message
    }

}