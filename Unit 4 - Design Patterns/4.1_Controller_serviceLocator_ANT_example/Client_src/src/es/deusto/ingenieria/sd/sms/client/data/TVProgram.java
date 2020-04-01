package es.deusto.ingenieria.sd.sms.client.data;

public class TVProgram
{
	private String acronym = null;
	private String description = null;

	public TVProgram(String acronym, String description)
	{
		this.acronym = acronym;
		this.description = description;
	}
	
	public String getAcronym()
	{
		return acronym;
	}

	public void setAcronym(String acronym)
	{
		this.acronym = acronym;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}