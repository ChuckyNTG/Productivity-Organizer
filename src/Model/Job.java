package Model;

import java.util.Calendar;
import java.util.HashMap;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

//this class is for all the tasks in the to do list
public class Job
{
	private ObservableMap<String, Comparable> _attributes;
	

	public Job(String name, String description,String priorityString,String date)
	{
		_attributes = FXCollections.observableHashMap();
		_attributes.put("name", name);
		_attributes.put("description", description);

		int priority = 1;
		if(priorityString.equalsIgnoreCase("high"))
			priority = 3;
		if(priorityString.equalsIgnoreCase("medium"))
			priority = 2;
		_attributes.put("priority", priority);
		
		createDate(date);
		
	}

	public Job(Job toCopy){
		_attributes = FXCollections.observableHashMap();
		for(Map.Entry<String, Comparable> e : toCopy._attributes.entrySet()){
			_attributes.put(e.getKey(), e.getValue());
		}
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
	
	public void createDate(String date)
	{
		System.out.println("Creating date from \"" + date + "\"");
		String delim = "[-]";
		String[] tokens = date.split(delim);
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);

		month = month -1;
		Calendar calendar = new Calendar.Builder()
				.setCalendarType("gregory")
				.setDate(year,month,day)
				.build();
		
		_attributes.put("date", calendar);
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
	
	/**
	 * Generates a list of all the attribute values for this job
	 * @return values of all the attributes
	 */
    public Comparable[] allAtributes()
    {
        Set<Map.Entry<String, Comparable>> entries = _attributes.entrySet();
        Comparable[] attributes = new Comparable[entries.size()];

        int i = 0;
        for (Map.Entry<String, Comparable> e : entries) {
            attributes[i] = e.getValue();
            i++;
        }

        return attributes;
    }

}	
	


