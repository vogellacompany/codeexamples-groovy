package com.vogella.groovy.mop.examples

public class MainTest {
	public static void main(String[] args) {
		Task task = new Task(1, "Groovy", "Learning Groovy");
		println task.toJson()
	}
}