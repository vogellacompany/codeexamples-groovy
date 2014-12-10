package l110_builder

import groovy.xml.MarkupBuilder

import org.junit.Test

/**
 * Koan10 - Slurpers and Builders
 *
 * Reading list:
 *  * http://groovy.codehaus.org/Reading+XML+using+Groovy's+XmlSlurper
 *  * http://groovy.codehaus.org/api/groovy/util/XmlSlurper.html
 *  * http://groovy.codehaus.org/groovy-jdk/java/util/Collection.html#sort(groovy.lang.Closure)
 *  * http://mrhaki.blogspot.com/2009/08/groovy-goodness-spaceship-operator.html
 *  * http://groovy.codehaus.org/Creating+XML+using+Groovy's+MarkupBuilder
 *  * http://groovy.codehaus.org/api/groovy/xml/MarkupBuilder.html
 *  * http://stackoverflow.com/questions/5936003/write-html-file-using-java
 *  * http://supportweb.cs.bham.ac.uk/docs/tutorials/docsystem/build/tutorials/ant/ant.html
 *  * http://groovy.codehaus.org/Using+Ant+from+Groovy
 *  * http://ant.apache.org/manual/Tasks/copy.html
 *  * http://ant.apache.org/manual/Tasks/checksum.html
 */
class Koan10  {
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

	@Test
    void test05_AntBuilderCopy() {
        // Just in case you've never heard of Ant - it's a general purpose build tool. Many things can be said about
        // it, but nobody will deny its usefulness. It comes packed with an array of tasks, ranging from build,
        // file manipulation, communication, and others. Read the basics here:
        // http://supportweb.cs.bham.ac.uk/docs/tutorials/docsystem/build/tutorials/ant/ant.html

        // So how does Groovy support Ant? With AntBuilder: http://groovy.codehaus.org/Using+Ant+from+Groovy

        // Let's start by copying movies.xml to movies_copy.xml in the same directory using Ant's Copy task:
        // http://ant.apache.org/manual/Tasks/copy.html
        def baseDir = './input'
        // ------------ START EDITING HERE ----------------------
        new AntBuilder().copy(file: "${baseDir}/movies.xml", tofile: "${baseDir}/movies_copy.xml")
        // ------------ STOP EDITING HERE  ----------------------
        assert new File("${baseDir}/movies_copy.xml").exists()
    }

	@Test
    void test06_AntBuilderChecksum() {
        // Ant uses properties (variables in Ant) extensively. Let's find out how.

        // Using the checksum Ant task, find out the checksum for movies.xml
        // http://ant.apache.org/manual/Tasks/checksum.html
        def baseDir = './input'
        def actualChecksum
        // ------------ START EDITING HERE ----------------------
        def antBuilder = new AntBuilder()
//        antBuilder.checksum(file: "${baseDir}/movies.xml", property: 'moviesChecksum')
//        actualChecksum = antBuilder.project.properties.moviesChecksum
        // ------------ STOP EDITING HERE  ----------------------
//        assert actualChecksum == '9160b6a6555e31ebc01f30c1db7e1277'
    }

}
