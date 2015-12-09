package com.vogella.groovy.eclipsebugzilla
def milesstones
def inputFile ="https://bugs.eclipse.org/bugs/buglist.cgi?classification=Eclipse&component=Runtime&component=IDE&component=User%20Assistance&component=UI&component=Text&order=bug_status&list_id=5935738&product=Platform&query_format=advanced&target_milestone=4.6%20M1&query_based_on=&columnlist=bug_id%2Ctarget_milestone%2Cassigned_to%2Cbug_status%2Cresolution%2Cshort_desc%2Cbug_severity%2Ccomponent&ctype=csv".toURL().text
String[] lines = inputFile.split('\n')
List<String[]> rows = lines.collect {it.split(',')}

rows[1..rows.size()-1].each {println "${it[0]} || ${it[1]} || ${it[2]} || ${it[3]} || ${it[4]} || ${it[5].length()<40?:it[5].substring(0,40).trim()}||"}
