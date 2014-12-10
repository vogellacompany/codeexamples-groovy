public class TestJava {
	public static void main(String[] args) {
		String user = null;
		String u = if (user!=null) ? user: new String();
		System.out.println(u);
	}
}
