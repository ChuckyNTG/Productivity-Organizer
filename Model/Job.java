import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
//this class is for all the tasks in the to do list
public class Job
{
	private HashMap<String, Comparable> _attributes;

	public Job(String name, String description, int priority,Calendar date)
	{
		_attributes = new HashMap<>();
		_attributes.put("name", name);
		_attributes.put("description", description);
		_attributes.put("priority", priority);
		_attributes.put("date", date);

		/*Pseudo random ID for each job. Each job can be located by the ID instead of having
		to enter a parameter to search for the job by. */
		Random generator = new Random();
		//Decent range of probablity for duplicates for now
		int random = generator.nextInt(10000);
		_attributes.put("ID",random);
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

	

	public void setPriority(int priority)
	{
		_attributes.put("priority", priority);
	}
	
	public int getPriority()
	{
		return (Integer) _attributes.get("priority");
	}

	public void setDate(int year, int month, int day, int hour, int minute,int second)
	{
		Calendar date = new Calendar.Builder().setCalendarType("gregory")
				.setDate(year,month,day)
				.setTimeOfDay(hour,minute,second)
				.build();

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
			out += key + "~" + _attributes.get(key);
		}
		return out;
	}
}	
	


