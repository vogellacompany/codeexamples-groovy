

package l800_StubsMocks

import org.junit.Test

/**
 * Koans12 - Built-in testing support in Groovy
 *
 * Reading list:
 *   * http://groovy.codehaus.org/api/groovy/util/GroovyTestCase.html
 *   * http://jetlet.blogspot.com/2010/06/shouldfail-in-groovy-testing.html
 *   * http://groovy.codehaus.org/Unit+Testing
 *   * http://groovy.codehaus.org/Mocking+Static+Methods+using+Groovy
 *   * http://groovy.codehaus.org/Groovy+Mocks
 *
 *
 */
class Lession {

	@Test
    void test01_Stubbing() {
        // Unit tests should run quickly and without external dependencies.
		// For that reason we normally create stubs
        // to fake real implementations of external dependencies.

        // Use the Expando class to stub the hard worker with a quick one by
        // adding a work() method to it
        Factory factory = new Factory([1, 2])
        long startTime = System.currentTimeMillis()
        // ------------ START EDITING HERE ----------------------
        def stub = new Expando()
        stub.work = { number -> number + 10 }
        factory.setWorker(stub)
        // ------------ STOP EDITING HERE  ----------------------
        factory.work()
        long endTime = System.currentTimeMillis()
        assert endTime - startTime < 3000


    }

}
