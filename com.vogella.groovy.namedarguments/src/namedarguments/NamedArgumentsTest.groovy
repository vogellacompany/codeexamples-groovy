package namedarguments

class Address {
    String street, city
    int number
}

class Person {
    String name
    Address address
    String phoneNumber

    def move(newAddress, newPhoneNumber) {
        address.street = newAddress.street
        address.number = newAddress.number
        address.city   = newAddress.city
        phoneNumber = newPhoneNumber
    }
}

def address = new Address(street: 'Reeperbahn', number: 1, city: 'Hamburg')
def p = new Person(name: 'testing', address: address, phoneNumber: '123456789')

p.move(street: 'Saselbeck', city: 'Hamburg', '23456789', number: 12)
// Internal Groovy translates the method invocation to the following:
// p.move([street: 'Saselbeck', number: 12, city: 'Hamburg'], '23456789')

assert 'testing' == p.name
assert 'Hamburg' == p.address.city
assert 'Saselbeck' == p.address.street
assert 12 == p.address.number
assert '23456789' == p.phoneNumber