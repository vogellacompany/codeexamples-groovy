package com.vogella.groovy.maps

def map = [name: 'Messages from mrhaki', url: 'http://mrhaki.blogspot.com', blog: true]
def found = map.find { key, value -> key == 'name' }
assert found.key == 'name' && found.value == 'Messages from mrhaki'
found = map.find { it.value =~ /mrhaki/ }
assert found.key == 'name' && found.value == 'Messages from mrhaki'
assert [name: 'Messages from mrhaki', url: 'http://mrhaki.blogspot.com'] == map.findAll { key, value -> value =~ /mrhaki/ }
assert 1 == map.findIndexOf { it.value.endsWith('com') }
assert [1,2] == map.findIndexValues { it.key =~ /l/ }  // All keys with the letter 'l'.
assert 2 == map.findLastIndexOf { it.key =~ /l/ && it.value }
assert map.any { entry -> entry.value }
assert map.every { key, value -> key.size() >= 3 }