package Model;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Model
{
	/**
	 * _tasks stores user created tasks in the organizer
	 * _filteredTasks stores the tasks the user desires to filter out of _tasks
	 */
	private ObservableList<Job> _tasks;
	private ObservableList<Job> _filteredTasks;

	/**
	 * Initializes the two array lists used for storage of tasks
	 */
	public Model()
	{
		_tasks = FXCollections.observableArrayList();
		_filteredTasks = FXCollections.observableArrayList();
	}
	
	/**
	 * Sorts attributes by smallest value first
	 */
	public static final Comparator<Object> SMALLESTFIRST = new Comparator<Object>() {

		@Override
		public int compare(Object o, Object t1) {
			return ((Comparable) o).compareTo(t1);
		}
	};

	/**
	 * Sorts attributes by largest value first
	 */
	public static final Comparator<Object> LARGESTFIRST = new Comparator<Object>() {

		@Override
		public int compare(Object o, Object t1) {
			return ((Comparable) t1).compareTo(o);
		}
	};
	
	public ObservableList<Job> getTasks()
	{
		return _tasks;
	}

	public void add(Job j)
	{
		_tasks.add(j);
		_filteredTasks.add(j);
	}
	
	
	public Job add(String name,String description,String priorityString,String date)
	{
		Job job = new Job(name,description,priorityString,date);
		this.add(job);

		System.out.println(_tasks.size());
		
		return job;
	}

	public void remove(Job job) 
	{
		_tasks.remove(job);
		_filteredTasks.remove(job);
	}
	
	public Job getJob(Job j)
	{
		int index = _tasks.indexOf(j);
		return _tasks.get(index);
	}
	
	/**
	 * Clear the lists of all jobs
	 */
	public void clear()
	{
		_tasks.clear();
		_filteredTasks.clear();
	}
	
	
	/**
	 * Change a parameter for the task
	 * @param newName sets the new name for the task
	 * @param newDes sets the new description for the task
	 * @param newPriority sets the new priority for the task
	 * @param newDate sets the new date for the task
	 */
	public void change(Job j, String newName,String newDes,String newPriority,String newDate)
	{
		Job modify = getJob(j);
		modify.setName(newName);
		modify.setDescription(newDes);
		modify.setPriority(newPriority);
		modify.createDate(newDate);
	}

	/**
	 * Sorts by predefined attribute
	 * @param attribute to sort by
	 */
	public void sort(String attribute)
	{
		_tasks.sort(new Comparator<Job>() {
			@Override
			public int compare(Job job, Job t1) {
				return job.getAtrribute(attribute).compareTo(t1.getAtrribute(attribute));
			}
		});

		_filteredTasks.clear();


		for(Job job: _tasks)
		{
			_filteredTasks.add(job);
		}
	}
	
	
	
	public void printList()
	{
		System.out.println("The details of the list:");
	
		for(Job job:_tasks)
		{
			System.out.println(job.toString());				
		}
	}

	@Override
	public String toString(){
		String out = "";
		for(Job job : _tasks){
			if(out.length() >= 1)
				out += '\n';
			out += job.toString();
		}
		return out;
	}
	
	/**
	 * Sorts by attribute using array of filters
	 * @param attribute
	 * @param filters
	 * @return
	 
	public ArrayList<Job> sort(String attribute, Filter[] filters)
	{
		Filter combined = new Filter()
		{
			@Override
			public boolean satisfies(Job job)
			{
				for (Filter f : filters)
					if (!f.satisfies(job))
						return false;
				return true;
			}
		};
		return sort(attribute, combined);
	}

	public ArrayList<Job> sort(String attribute, Filter filter)
	{
		return sort(attribute, filter, SMALLESTFIRST);
	}

	public ArrayList<Job> sort(String attribute, Filter filter, Comparator comparator){
		System.out.println(list.size() + " to filt er");
		ArrayList<Job> postFilter = new ArrayList<>();
		for(Job job : list)
		{
			if(filter.satisfies(job))
				postFilter.add(job);

		}
		if(attribute != null) {
			postFilter.sort(new Comparator<Job>() {
				@Override
				public int compare(Job o1, Job o2) {
					Comparable a1 = o1.getAtrribute(attribute);
					Comparable a2 = o2.getAtrribute(attribute);
					if (a1 instanceof String && a2 instanceof String) {
						a1 = ((String) a1).toUpperCase();
						a2 = ((String) a2).toUpperCase();
					}
					return comparator.compare(a1, a2);
				}
			});
		}
		return postFilter;
	}
	*/
	
	/**
	 * Loads file filled with jobs
	 * @param file is the file to read the jobs from
	public void loadFile(File file){
		try {
			Files.lines(file.toPath()).forEach(e ->{
				String[] parts = e.split("\\|");
				add(parts[0], parts[1],parts[3],parts[2]);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/

	
}
