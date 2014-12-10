package com.vogella.groovy.first

import groovy.transform.ToString

@ToString(includePackage = false, includeNames=true)
class FirstGroovy {
	String s ="hello"

	static void main(def args){
		def mylist=[1, 2, "Lars", "4"]
		mylist.each{ println it }
		FirstGroovy o = new FirstGroovy();
		println o.toString()
	}
	void test () {
		def mylist=[1, 2, "Lars", "4"]
		mylist.each{ println it }
	}
}
