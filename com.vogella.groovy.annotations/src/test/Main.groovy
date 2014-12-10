package test

import java.lang.annotation.*

import org.codehaus.groovy.transform.GroovyASTTransformationClass
@Retention (RetentionPolicy.SOURCE)
@Target ([ElementType.METHOD])
@GroovyASTTransformationClass (classes=[test.MainTransformation])
public @interface Main { }
