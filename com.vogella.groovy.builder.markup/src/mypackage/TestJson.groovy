import groovy.json.*

class Person {
	String name
	List addresses = []
}

class Address {
	String address
	String state
}

Person p = new Person(name:"Frank")
p.addresses << new Address(address: "123 Street", state:"MN")
p.addresses << new Address(address: "987 Ave", state:"WI")


def builder = new JsonBuilder()

def root = builder.people {
    person {
        name "${p.name}"

        addresses(
	    p.addresses.collect{
               Address a -> [addr: a.address, state:a.state]
            }
	)
    }
}

println builder.toPrettyString()