package es.deusto.ingenieria.sd.sms.server.data.dto;

import java.io.Serializable;

public class TVProgramDTO implements Serializable
{
	private String acronym;
	private String description;

	public TVProgramDTO(String acronym, String description) 
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

	public void setDescription(String description) 
	{
		this.description = description;
	}
}