package com.vogella.groovy.typechecking

import groovy.transform.TypeChecked

@TypeChecked
class WithTestClass {
	String property1
	String property2
	List<String> list = []
	def addElement(String value) {
		list << value
	}
	def returnProperties () {
		"Property 1: $property1, Property 2: $property2 "
	}
}

@TypeChecked
def static main (args) {
	def sample = new WithTestClass()
	def result= sample.with {
		property1 = 'Input 1'
		property2 = 'This is cool'
		// The next two lines will result in a compile error
//		property3 = "compile error"
//		addElement 1
		addElement 'Android'
		addElement 'Linux'
		returnProperties()
	}
	println result
	assert 3 == sample.list.size()
	assert 'Input 1' == sample.property1
	assert 'This is cool' == sample.property2
	assert 'Linux' == sample.list[2]
}


