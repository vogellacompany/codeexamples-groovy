package list

def list = ['Daffy', 'Bugs', 'Elmer', 'Tweety', 'Silvester', 'Yosemite']
assert 'Bugs' == list.find { it == 'Bugs' }
assert ['Daffy', 'Bugs', 'Elmer'] == list.findAll { it.size() < 6 }
assert 1 == list.findIndexOf { name -> name =~ /^B.*/ }  // Start with B.
assert 3 == list.findIndexOf(3) { it[0] > 'S' }  // Use a start index.
assert [0,3,5] == list.findIndexValues { it =~ /(y|Y)/ }  // Contains y or Y.
assert [3,5] == list.findIndexValues(2) { it =~ /(y|Y)/ }
assert 2 == list.findLastIndexOf { it.size() == 5 }
assert 5 == list.findLastIndexOf(1) { it.count('e') > 1 }
assert list.any { it =~ /a/ }
assert list.every { it.size() > 3 }
