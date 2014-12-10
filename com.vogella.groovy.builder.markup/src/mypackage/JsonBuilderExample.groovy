package mypackage

import groovy.json.JsonBuilder
import groovy.json.JsonOutput



class JsonBuilderExample {
	static main (args) {
		def list =[]
		for (i in 1..3) {
			list << new Task("Summary$i", "Descripton$i", new Date())
		}
		def date = new Date()
		// Use the default to String
		JsonBuilder b1 = new JsonBuilder(tasks: list)
		println JsonOutput.prettyPrint(b1.toString())

		// control the output
		JsonBuilder b2 = new JsonBuilder()
		b2.tasklist {
			tasks (
				list.collect { Task t ->
						[
						summary: t.summary,
						description: t.description,
						date: t.dueDate.format("dd/mm/yy")
						]}
			)
		}
		println JsonOutput.prettyPrint(b2.toString())
	}
}

