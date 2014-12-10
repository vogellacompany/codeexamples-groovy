package test

import groovy.transform.ToString

@Singleton
@ToString(includePackage = false, includeNames=true)
class Annotation {
	String s ="hello"

	static void main(def args){
		Annotation o = Annotation.instance;
		assert o.toString() == 'Annotation(s:hello)'
	}
}
