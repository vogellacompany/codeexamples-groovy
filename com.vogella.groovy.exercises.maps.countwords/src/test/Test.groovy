//def textCorpus = new File("./input/text.txt").text
def textCorpus = new URL("http://www.vogella.com").text
List words = textCorpus.tokenize()
def wordFrequency = [:]
words.each { word ->
	wordFrequency[word] = wordFrequency.get(word, 0) + 1
}
def list = wordFrequency.keySet().toList()
list.sort({value -> wordFrequency[value]})

list.reverse()[0..4].each {w->
	println w + ":" + wordFrequency[w]
}
