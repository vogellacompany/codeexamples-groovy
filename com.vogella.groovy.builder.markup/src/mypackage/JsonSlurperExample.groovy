package mypackage

import groovy.json.JsonOutput
import groovy.json.JsonSlurper



class JsonSlurperExample {
	static main (args) {
		def a = new JsonSlurper().parse(new File("./input/tasks.json"))
		JsonOutput.prettyPrint(a.toString())


	}
}

