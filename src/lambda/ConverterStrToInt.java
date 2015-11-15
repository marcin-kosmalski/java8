package lambda;
import java.util.function.Function;

public class ConverterStrToInt implements Function<String, Integer> {

	@Override
	public Integer apply(String str) {
		try {
			return Integer.valueOf(str);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		ConverterStrToInt converter=new ConverterStrToInt();
		
		System.out.println(converter.apply("8797875"));
	}
}
