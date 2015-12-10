package com.vogella.groovy.mop.examples;

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.transform.TupleConstructor

@TupleConstructor
public class Task {
	long id
	String summary
	String description

	def methodMissing (String name, args){
		if (name=="toJson") {
			JsonBuilder b1 = new JsonBuilder(this)
			return JsonOutput.prettyPrint(b1.toString())
		}
	}
}