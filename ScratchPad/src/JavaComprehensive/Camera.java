package JavaComprehensive;

public class Camera {
	
	private int size;
	
	public Camera(){
		
	}

	public Camera(int s){
		CameraBody body = new CameraBody(s);
		
		
	}
	
	private class CameraBody{
		private CameraBody(int v){
			size = v; // directly access Camera.size even though it is private. 
			// operates on current instance automatically.  Can't use 'this', that 
			// would refer to the CameraBody instance
			
		}
		
		private void printFromCameraBodyClass(){
			System.out.println("This is from CameraBody class:" + size);
		}
		
	} // end CameraBody class
	
	public void printSize(){
		System.out.println("Size = " + size);
	}
	
	public static void main(String[] args) {
		Camera c1 = new Camera(10);
		c1.printSize();
		
		Camera c2 = new Camera(12);
		c2.printSize();
		c2.body. // body must be made a member variable before this will work! 
		

	}

}
