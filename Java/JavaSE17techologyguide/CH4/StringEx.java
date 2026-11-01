package CH4;

public class StringEx {
	public static void main(String[] args) {
		var name1 = "Justin";
		var name2 = "Justin";
		var name3 = new String("Justin");
		var name4 = new String("Justin");

		System.out.println(name1==name1);
		System.out.println(name1==name2);
		System.out.println(name2==name3);
		System.out.println(name3==name4);

		System.out.println(name1.equals(name1));
		System.out.println(name1.equals(name2));
		System.out.println(name2.equals(name3));
		System.out.println(name3.equals(name4));
	}
}
