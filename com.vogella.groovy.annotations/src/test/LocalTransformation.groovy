

class LocalTransformation {
	@Main
	def hello(){
		LocalTransformation o = LocalTransformation.instance
		assert o.toString() == 'Annotation(s:hello)'
	}
}
