package com.vogella.groovy.xmlparser

import groovy.xml.StreamingMarkupBuilder

def path = new XmlSlurper().parse(new File('input/plan.xml'))
def builder = new StreamingMarkupBuilder()
def copier = builder.bind{ mkp.yield(path) }
def result = "$copier"
println result
assert result.startsWith('<plan><week ')
assert result.endsWith('</week></plan>')
