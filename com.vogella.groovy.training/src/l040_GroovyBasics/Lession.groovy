package l040_GroovyBasics

import groovyjarjarantlr.collections.List

import org.junit.Test

/**
 * Lession10 - Groovy 101
 *
 */

class Lession  {

	@Test
    void test02_GStrings() {
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
    void test03_MapsInGroovy() {
        def map = [right: 'derecha', left: 'izquierda']

        // Concatenate the two values of 'right' and 'left' into result to proceed using Groovy syntax
        def result
        // ------------ START EDITING HERE ----------------------
		result = map['right'] + map['left']
		// ------------ STOP EDITING HERE  ----------------------

        assert result.toCharArray().size() == 16
    }

	@Test
    void test04_Lists() {
        // In Java, list creation can be somewhat cumbersome:
        List<String> javaList = new ArrayList<String>()
        javaList.add("King")
        javaList.add("Queen")
        javaList.add("Prince")

        // in Groovy the list creating is simplified:
        def groovyList = ['King', 'Prince']

        // Add the missing item to the Groovy list. Pay attention to the order of the items.
        // Hint: you can use either Java's add(int, String) or Groovy's plus() method.
        // ------------ START EDITING HERE ----------------------
        groovyList = groovyList.plus(1, 'Queen')
        // ------------ STOP EDITING HERE  ----------------------

        // note how Groovy allows you to compare the *content* of the lists
        assert groovyList == javaList
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

    private String createMessageForUser(UserService userService) {
        def message
        // ------------ START EDITING HERE ----------------------
        message = "Hello ${userService.loggedInUser?.firstName ?: 'Anonymous'}!"
        // ------------ STOP EDITING HERE  ----------------------

        // note how Groovy doesn't require the 'return' keyword! It will simply return the last expression.
        message
    }

}