package jishnu;

public class JSExecutorRun {

	public static void main(String[] args) throws Exception {
		
		JSExecutor jsRun = new JSExecutor();
		
		jsRun.autLaunch("http://duckduckgo.com/");
		jsRun.jsExecutor();
	}

}
