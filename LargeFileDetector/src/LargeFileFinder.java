import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LargeFileFinder {
	
	private OnLargeFileFound handler;
	private String filePath = "C:\\Users\\Tanookh\\Downloads\\Course\\";
	
	public void onLargeFileFound(OnLargeFileFound handler)
	{
		this.handler = handler;
	}
	
	public void scanComputer() throws IOException
	{
		Path path = Paths.get(filePath);
		long bytes = Files.size(path);
		final File folder = new File(filePath);
		for(final File fileEntry : folder.listFiles()) {
			path = Paths.get(filePath+fileEntry.getName());
	    	bytes = Files.size(path);
	    	if(this.handler!=null && bytes > 10000000)
	    	{
	    		//System.out.println(String.format("%,d bytes", bytes));
	    		handler.largeFileFound("Finder: Large file found: " + fileEntry.getName() + ", Size: " + String.format("%,d MB", bytes/1000000));
	    	}
//	    	else if(this.handler!=null && bytes < 10000000) {
//	    		System.out.println("Small file: " + fileEntry.getName() +", Size: " + String.format("%,d MB", bytes/1000000); 
//	    	}
		}
	}
}
