import java.util.Calendar;
//this class is for all the tasks in the to do list
public class Job
{
	private String _name;
	private String _description;
	private String _priority;
	private Date _dueDate;	

	public Job(String name, String description, String priority,Date date)
	{
		_name = name;
		_description = description;
		_priority = priority;
		_dueDate = date;
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

	

	public void setPriority(String p)
	{
		_priority = p;
	}
	
	public String getPriority()
	{
		return _priority;
	}

	public void setDate(int year, int month, int day, int hour, int minute,
				int second)
	{
		Calendar date = new Calendar.Builder().setCalendarType("gregory")
				.setDate(year,month,day)
				.setTimeOfDay(hour,minute,second)
				.build();

		_dueDate=date;
	}			
}	
	


