package iniciante;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
* URI Online Judge | 1009
*/
public class SalarioComBonus {
	public static void main (String... args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String output = "TOTAL = R$ ";
		while((line = br.readLine())!=null){//skip name
			Double income =  Double.valueOf(br.readLine());
			income = income + (Double.valueOf(br.readLine()) * 0.15);
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println(output.concat(df.format(income.doubleValue())));
		}
	}
}