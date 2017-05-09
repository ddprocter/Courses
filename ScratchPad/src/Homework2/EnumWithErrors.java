package Homework2;

public enum EnumWithErrors {
	
	SOCCERBALL (27.0F),
	TENNISBALL(2.25f),
	PINGPONGBALL(0.75f)
	
	public float radius;
	
	public EnumWithErrors(float r){
		radius = r;
	}
	
	public float getRadius() {
		return radius;
	}

}
