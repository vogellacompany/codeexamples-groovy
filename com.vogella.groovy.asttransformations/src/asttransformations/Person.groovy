package asttransformations


@Pojo
class Person {
	String firstName
	String lastName
}

// you can also override properties
@Pojo(includeNames=false)
class Person2 {
	String firstName
	String lastName
}


