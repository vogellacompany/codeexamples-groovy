package closures

class ControlStructure {
	static void doUnless(boolean value, Closure c) {
		if (!value) c()
	}

	public static  main(args) {
		doUnless (4 < 6) { println "less"}
	}
}
