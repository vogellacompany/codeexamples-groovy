package l020_NumbersRanges

/**
 * A simple GroovyBean representing a person.
 * First and last name can be modified, but ssn is forever.
 */
class GroovyPerson {
	String firstName
	String lastName

	GroovyCouple plus(GroovyPerson p) {
		new GroovyCouple(p1:this, p2:p)
	}
}
