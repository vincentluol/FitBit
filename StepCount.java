import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StepCount {
	private  ArrayList<Double>gForces = new ArrayList<Double>();
	private  ArrayList<Double>times = new ArrayList<Double>();
	private ArrayList<Double> temp = new ArrayList<Double>();

	public StepCount(String fileName){
		Scanner inputStream = null;
		try {
			String file = fileName;
			File origFile = new File(file);
			inputStream = new Scanner(origFile);
		} catch (Exception e)
		{
			System.out.println("The error was: "+e);
			e.printStackTrace();
		}

		while(inputStream.hasNext()){
			String line = inputStream.nextLine();
			if (line.startsWith("time"))
				continue;
			String[] fields = new String[5];
			fields = line.split(",");
			double time = Double.parseDouble(fields[0]);
			times.add(time);
			double gForce = Double.parseDouble(fields[4]);
			gForces.add(gForce);
		}
		inputStream.close();

		buildStepList();
	}

	private void buildStepList()
	{
		for (int i = 0; i < gForces.size(); i++){
			if (gForces.get(i)>1.3){
				temp.add(times.get(i));
				i += 90;			
			}
		}
	}

	public  int getSteps(){
		return getStepList().size();
	}

	public  ArrayList<Double> getStepList()
	{
		return temp;
	}


}
