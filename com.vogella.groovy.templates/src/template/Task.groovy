package template

import groovy.transform.TupleConstructor

@TupleConstructor
class Task {
	String summary
	String description
	int duration
	Date dueDate
}
