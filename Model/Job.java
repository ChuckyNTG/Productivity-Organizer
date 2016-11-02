import java.util.Calendar;
import java.util.HashMap;
//this class is for all the tasks in the to do list
public class Job
{
	private HashMap<String, Comparable> _attributes;
	private static int idAccumulator = 0;

	public Job(String name, String description,String priorityString,Calendar date)
	{
		_attributes = new HashMap<>();
		_attributes.put("name", name);
		_attributes.put("description", description);

		int priority = 1;
		if(priorityString.equalsIgnoreCase("high"))
			priority = 3;
		if(priorityString.equalsIgnoreCase("medium"))
			priority = 2;
		_attributes.put("priority", priority);
		_attributes.put("date", date);

		int id = idAccumulator;
		idAccumulator++;
		_attributes.put("ID",id);
	}
	
	public int getID()
	{
		return (int) _attributes.get("ID"); 	
	}
	
	public void setName(String name)
	{
		_attributes.put("name", name);
	}

	public String getName()
	{
		return (String) _attributes.get("name");
	}

	
	public void setDescription(String description)
	{
		_attributes.put("description", description);
	}
	
	public String getDescription()
	{
		return (String) _attributes.get("description");
	}

	

	public void setPriority(String priorityString)
	{
		
		int priority = 1;
		if(priorityString.equalsIgnoreCase("high"))
			priority = 3;
		if(priorityString.equalsIgnoreCase("medium"))
			priority = 2;
		_attributes.put("priority", priority);
	}
	
	public int getPriority()
	{
		return (Integer) _attributes.get("priority");
	}

	public void setDate(Calendar date)
	{
		_attributes.put("date", date);
	}
	
	public Calendar getDate()
	{
		return (Calendar) _attributes.get("date");
	}

	public Comparable getAtrribute(String attribute)
    {
        return _attributes.get(attribute);
    }
	public String toString(){
		String out = "";
		for(String key : _attributes.keySet()){
			if(out.length() > 1)
				out += "|";
			if(key.equalsIgnoreCase("date"))
			{
				out += key + "~" + this.getDate().getTime();
			}	
			else
			{
				out += key + "~" + _attributes.get(key);
			}
		}
		return out;
	}
}	
	


