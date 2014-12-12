package l200_slurper

import org.junit.Test

/**
 * Slurpers
 */

class Lession  {
	final String path = "./input/movies.xml"

	@Test
    void test01_XmlSlurpersReader() {
        // using the reference at http://groovy.codehaus.org/Reading+XML+using+Groovy's+XmlSlurper and
        // http://groovy.codehaus.org/api/groovy/util/XmlSlurper.html, read the content of movies.xml
        // and find out how many movies are listed.
        def movieCount
        // ------------ START EDITING HERE ----------------------
        def xml = new XmlSlurper().parse(path)
        movieCount = xml.movie.size()
        // ------------ STOP EDITING HERE  ----------------------
        assert movieCount == 7

        // return all the movie names that contain the word 'the' (case-insensitive)
        // Hint: pay attention to the type of objects you're getting.
        List<String> moviesWithThe = []
        // ------------ START EDITING HERE ----------------------
        def xml2 = new XmlSlurper().parse(path)
        def filteredNodeChildren = xml2.movie.title.findAll {
            it.text().toLowerCase().contains('the')
        }
        moviesWithThe = filteredNodeChildren.collect() { it.text() }
        // ------------ STOP EDITING HERE  ----------------------
        assert moviesWithThe.containsAll(['Conan the Barbarian', 'The Expendables', 'The Terminator'])

        // How many movie ids have a value greater than 5?
        def movieIdsGreaterThan5
        // ------------ START EDITING HERE ----------------------
        def xml3 = new XmlSlurper().parse(path)
        movieIdsGreaterThan5 = xml3.movie.findAll { it.@id.text().toInteger() > 5 }.size()
        // ------------ STOP EDITING HERE  ----------------------
        assert movieIdsGreaterThan5 == 2
    }

}
