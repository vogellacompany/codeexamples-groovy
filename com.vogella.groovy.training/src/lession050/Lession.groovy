package lession050

import org.junit.Test


/**
 *
 * Resource list:
 *  http://groovy.codehaus.org/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
 *  http://groovy.codehaus.org/Collections#Collections-Ranges
 *  http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#eachWithIndex(groovy.lang.Closure)
 */
class Lession {

	@Test
	void test01_IterateWithEach() {
		def products = ['GitHub', 'Confluence', 'Hipmunk', 'Outlook']

		// It's very common to iterate through lists. Can it get simpler than this?
		for (String s : products) {
			println s
		}
		// In Groovy, it can.
		products.each {
			println it
		}

		Map<String, String> idToNameMap = [333: 'Matthew', 233: 'Christopher', 133: 'Dominic']

		// Suppose we needed to extract a list of IDs+Names from this map. In Java:
		List<String> javaIdListResult = new LinkedList<String>()
		for (Map.Entry<String, String> entry : idToNameMap) {
			javaIdListResult.add(entry.getKey() + entry.getValue())
		}

		// How would you do this in Groovy?
		// http://groovy.codehaus.org/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
		def idListResult = []
		// ------------ START EDITING HERE ----------------------
		idToNameMap.each { key, value ->
			idListResult << "$key$value"
		}
		// ------------ STOP EDITING HERE  ----------------------
		assert idListResult == ['333Matthew', '233Christopher', '133Dominic']
	}

	@Test
	void test02_Ranges() {
		// Groovy allows you to create quick lists for sequential values. For example 5..10 or 'a'..'d'
		// Read at http://groovy.codehaus.org/Collections#Collections-Ranges

		// A simple example:
		def range = 5..10

		// What will range equal?
		def expectedRange = []
		// ------------ START EDITING HERE ----------------------
		expectedRange = [5, 6, 7, 8, 9, 10]
		// ------------ STOP EDITING HERE  ----------------------
		assert range == expectedRange
	}

	@Test
	void test03_IterateOnRanges() {
		// Just as you can iterate over lists, you can iterate over ranges.

		// Create a list of all odd letters (a, c, e, ... etc) using ranges
		// http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#eachWithIndex(groovy.lang.Closure)
		def rangeResult = []

		// ------------ START EDITING HERE ----------------------
		def range = 'a'..'z'
		range.eachWithIndex { value, index ->
			if (index % 2 == 0)
				rangeResult << value
		}
		// ------------ STOP EDITING HERE  ----------------------
		assert rangeResult == ['a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u', 'w', 'y']
	}


}
