package com.vogella.groovy.xmlparser

import groovy.transform.TupleConstructor

@TupleConstructor
class Task {
	String summary
	String description
	Date dueDate
}
