package example

int i = 1 // Short form for Integer i = new Integer(1)
int j = i +3
int k = i.plus(3) // Same as above
// Make sure this worked
assert(k==4)
println i.class
println j.class
println k.class

// Automatic type assignement
def value = 1.0F
println value.class
def value2 = 1
println value2.class
// this would be zero in Java
value2 = value2 / 2
println value2
// value was upcasted
println value2.class

10.times {println "Test"}

//multiplication, addition and substraction with BigInteger or BigDecimal results in BigInteger or BigDecimal
def product = 1.1G * 2 //BigDecimal and Integer
assert product.class.name == 'java.math.BigDecimal'

(3G*4).class.name == 'java.math.BigInteger' //BigInteger and Integer

//multiplication of two integers
assert (5*4).class.name == 'java.lang.Integer'

//multiplication with Long
assert (1L*4).class.name == 'java.lang.Long'

//dividing some numbers
(5/5).class.name == 'java.math.BigDecimal'
//if you want an integer, use the intdiv() method
(5.intdiv(5)).class.name == 'java.lang.Integer'
(1.intdiv(5)).class.name == 'java.lang.Integer' //result is 0
assert 1/2 == 0.5


1.step(4, 0.5){ print "$it "}

//some GDK methods for numbers
//think about a java for loop... you don't need it!
def numbers = []
10.times { numbers << it } //it will contain values from 0 to 9
assert numbers.join(",") == '0,1,2,3,4,5,6,7,8,9'
10.upto(12) { numbers << it}
assert numbers.join(",") == '0,1,2,3,4,5,6,7,8,9,10,11,12'
11.downto(10) { numbers << it}
assert numbers.join(",") == '0,1,2,3,4,5,6,7,8,9,10,11,12,11,10'

numbers = []
1.step(2, 0.1) { numbers << it; assert it.class.name == 'java.math.BigDecimal' }
assert numbers.join(",") == '1,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8,1.9' //notice 2 is not included

numbers = []
1.0.step(2, 0.1) { numbers << it; assert it.class.name == 'java.math.BigDecimal' }
assert numbers.join(",") == '1.0,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8,1.9' //notice how the first value changed to 1.0
