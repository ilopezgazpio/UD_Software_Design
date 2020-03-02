package server;
import client.RestClient;

public class RestServer
{
	private RestClient restClient;

	public RestServer(String hostname, String port)
	{
		restClient = new RestClient(hostname, port);
	}

	public void pullRemote(int times) throws Exception
	{
		while(times-- > 0)
		{
			Thread.sleep(2000);
			System.out.println("Starting to pull server...");
			try
			{
				this.restClient.makeGetRequest();
				this.restClient.makePostRequest("Pulling server - iteration " + times);
			}
			catch (Exception e)
			{
				System.out.println("BadAss exception received when pulling server");
				System.out.println(e.getMessage());
				throw new Exception("Basic exception handling from inner function");
			}
		}
	}

	public static void main(String[] args)
	{
		String hostname = args[0];
		String port = args[1];

		RestServer server = new RestServer(hostname, port);
		try
		{
			server.pullRemote(50);
		}
		catch(Exception e)
		{
			System.out.println("I really need to go to lectures...");
		}
	}
}
