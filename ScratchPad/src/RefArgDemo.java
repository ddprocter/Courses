public class RefArgDemo{
	void modifyField(myClazz dupKey) {
		dupKey.x = 101;
		dupKey = new myClazz();
		dupKey.x=200;
	}
	
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	RefArgDemo demo = new RefArgDemo();
	//	myClazz key = new myClazz();
	//	key.x = 10;
	//	demo.modifyField(key);
	//	System.out.println("key.x = " + key.x);
	
	//}

}