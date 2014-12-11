package com.vogella.groovy.ducktyping

class Duck
{
	def walk() { println "I'm a Duck, I can walk..." }
	def swim() { println "I'm a Duck, I can swim..." }
	def quack() { println "I'm a Duck, I can quack" }
}

class Person
{
	def walk() { println "I'm a Person, I can walk..." }
	def swim() { println "I'm a Person, I can swim..." }
	def talk() { println "I'm a Person, I can talk..." }
}


def d = new Duck()
def p = new Person()

d.walk()	// Ok, duck has walk() method
d.swim()	// Ok, duck has swim() method
d.quack()	// Ok, duck has quack() method

p.walk()	// Ok, person has walk() method
p.swim()	// Ok, person has swim() method
//p.quack()	// Runtime error, no quack() method

callMethod(d)
callMethod(p)

static callMethod(e){
	e.walk()
}