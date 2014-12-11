package l010_Class

/**
 * A simple GroovyBean representing a person.
 * First and last name can be modified, but ssn is forever.
 */
class GroovyPerson {
    String firstName
    String lastName
    final String ssn      // marking the field 'final' makes it read-only after construction.

    GroovyPerson(String firstName, String lastName, String ssn) {
        this.firstName = firstName
        this.lastName = lastName
        this.ssn = ssn
    }
}
