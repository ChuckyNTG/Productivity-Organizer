public class Job
{
	private String _name;
	private String _description;
	private int _priority;

	public Job(String name, String description, int priority)
	{
		_name = name;
		_description = description;
		_priority = priority;

	}
	public void setName(String name)
	{
		_name = name;
	}

	public String getName()
	{
		return _name;
	}

	
	public void setDescription(String descript)
	{
		_description = descript;
	}
	
	public String getDescription()
	{
		return _description;
	}

	

	public void setPriority(int p)
	{
		_priority = p;
	}
	
	public int getPriority()
	{
		return _priority;
	}
}	
	


