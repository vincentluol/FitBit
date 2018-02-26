import java.util.ArrayList;

public class FitBitMain {



	public static void main(String[] args){
		StepCount rs = new StepCount("running2.csv");
		StepCount v = new StepCount("vincent2.csv");
		System.out.println(rs.getSteps()+" vs " + v.getSteps());
		
		ArrayList<Double> a = v.getStepList();
		for (int i = 0; i < v.getSteps(); i++)
		{
			System.out.println((i+1)+": "+a.get(i));
		}
		
	}


}