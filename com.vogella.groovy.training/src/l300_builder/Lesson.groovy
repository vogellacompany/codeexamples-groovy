package l300_builder

import groovy.xml.MarkupBuilder

import org.junit.Test

/**
 * Builders
 *
 */
class Lesson  {
	final String path = "./input/movies.xml"

	@Test
    void test03_XmlMarkupBuilder1() {
        // Groovy's MarkupBuilder allows you to create tree structures very easily.
        // Read here: http://groovy.codehaus.org/Creating+XML+using+Groovy's+MarkupBuilder
        // And here: http://groovy.codehaus.org/api/groovy/xml/MarkupBuilder.html

        // Let's try to create the following HTML in code:
        // <html>
        // <body>
        //    <h1>title</h1>
        // </body>
        // </html>

        // I'm not even going to try to do it the Java way, but it would have been something along
        // the lines of: http://stackoverflow.com/questions/5936003/write-html-file-using-java

        // Using MarkupBuilder, create the above html as String
        def html
        // ------------ START EDITING HERE ----------------------
        def writer = new StringWriter()
        def b = new MarkupBuilder(writer)
        b.html {
            body {
                h1('title')
            }
        }
        html = writer.toString()
        // ------------ STOP EDITING HERE  ----------------------
        assert formatXml(html) == formatXml("<html><body><h1>title</h1></body></html>")
    }
	@Test
    void test04_XmlMarkupBuilder2() {
        // Suppose we need to transform the movies.xml to a different format, as such:
        // <movies>
        //      <movie id='id' title='title' year='year'/>
        // </movies>

        // We could use XSLT... but MarkupBuilder makes it a breeze! Use it to
        // convert the movies.xml to the above format:

        String convertedXml
        // ------------ START EDITING HERE ----------------------
        def reader = new XmlSlurper().parse(path)
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.movies {
            reader.movie.each { movieNode ->
                movie(id: movieNode.@id.text(), title: movieNode.title.text(), year: movieNode.year.text())
            }
        }
        convertedXml = writer.toString()
        // ------------ STOP EDITING HERE  ----------------------
        def expected = """|<movies>
                            |  <movie id='6' title='Total Recall' year='1990' />
                            |  <movie id='4' title='The Terminator' year='1984' />
                            |  <movie id='5' title='The Expendables' year='2010' />
                            |  <movie id='1' title='Conan the Barbarian' year='1982' />
                            |  <movie id='3' title='Predator' year='1987' />
                            |  <movie id='2' title='True Lies' year='1994' />
                            |  <movie id='7' title='Kindergarten Cop' year='1990' />
                            |</movies>""".stripMargin()

        assert formatXml(expected) == formatXml(convertedXml)
    }

    private String formatXml(String xml) {
        def stringWriter = new StringWriter()
        def node = new XmlParser().parseText(xml.toString())
        new XmlNodePrinter(new PrintWriter(stringWriter)).print(node)
        return stringWriter.toString()
    }

}
