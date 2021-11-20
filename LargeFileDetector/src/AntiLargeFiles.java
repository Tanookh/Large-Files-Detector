import java.io.IOException;

public class AntiLargeFiles implements OnLargeFileFound{
	
	private LargeFileFinder finder = new LargeFileFinder();
	
	public void start() throws IOException
	{
		this.finder.onLargeFileFound(this);
		this.finder.scanComputer();
	}

	@Override
	public void largeFileFound(String details) {
		System.out.println("Large File: "+details);
	}
}
