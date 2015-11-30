package exceptions;

public class StringUtils {

	public static String append(String str,
			ExceptionHandler<StringAppender, String, Exception> block)
			throws Exception {
		
		if(str==null||(str!=null&&str.length()<3)){
			throw new Exception("Source empty or shorter than 3!");
		}
		return block.accept(new StringAppender(str));
	}

}
