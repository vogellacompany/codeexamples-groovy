package com.vogella.groovy.maps

class Main {
	static main(args) {
		// create map
		def map = ["Jim":"Knopf", "Thomas":"Edison"]

		// create map without quotes for the keys
		def anotherMap = [Jim:"Knopf", Thomas:"Edison"]

		// if key should be evaluated put it into brackets
		def x ="a"
		// not true, as x is interpreted as "x"
		println ([a:1]==[x:1])
		// force Groovy to see x as expression
		println ([a:1]==[(x):1])

		// create empty map
		def emptyMap = [:]

	}


}
