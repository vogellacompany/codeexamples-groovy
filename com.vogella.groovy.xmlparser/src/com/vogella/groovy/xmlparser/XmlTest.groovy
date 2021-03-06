package com.vogella.groovy.xmlparser

def xmldocument = '''
<persons>
	<person>
		<firstname age="3">Jim</firstname>
		<lastname>Knopf </lastname>
	</person>
	<person>
		<firstname age="4">Ernie</firstname>
		<lastname>Bernd</lastname>
	</person>
</persons>
'''
def persons = new XmlParser().parseText(xmldocument)

def allRecords = persons.person.size()

println("Number of persons in file: $allRecords")
def person = persons.person[0]

// name is the name of the XML tag
println("Name of the person tag is:" + person.name())
// text gets the text of the node firstname
println(person.firstname.text())
println("Age of the person + ${person.firstname.@age[0]}")

// Lets print out all important information
for (p in persons.person){
	println "${p.firstname.text()}  ${p.lastname.text()}"
}

