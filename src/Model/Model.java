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
	public static final Comparator<Object> SMALLESTFIRST = new Comparator<Object>() {

		@Override
		public int compare(Object o, Object t1) {
			return ((Comparable) o).compareTo(t1);
		}
	};


	public static final Comparator<Object> LARGESTFIRST = new Comparator<Object>() {

		@Override
		public int compare(Object o, Object t1) {
			return ((Comparable) t1).compareTo(o);
		}
	};

	//Sorting and displaying jobs
	private ObservableList<Job> list;
	//Accessing jobs
	private ObservableMap<Integer,Job> _jobs;
	public static Model backup;
	private static int idAccumulator = 0;
	
	public Model()
	{
		list = FXCollections.observableArrayList();
		_jobs = FXCollections.observableHashMap();
	}

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

	public Model(Model toCopy){
		this();
		for(Job job : toCopy.getList())
			list.add((job));
		for(Map.Entry<Integer, Job> e : toCopy._jobs.entrySet())
			_jobs.put(e.getKey(), new Job(e.getValue()));
	}

	public Model(ArrayList<Job> jobs){
		this();
		for(Job j : jobs) {
			list.add(j);
			_jobs.put(j.getID(), j);
		}
	}

	public void add(Job j){
		_jobs.put(j.getID(), j);
		list.add(j);
	}
	
	public ObservableList<Job> getList()
	{
		return list;
	}
	
	public Job add(String name,String description,String priorityString,String date)
	{
		Job job = new Job(name,description,priorityString,date);
		job.setID(idAccumulator);
		list.add(idAccumulator, job);
		_jobs.put(idAccumulator, job);
		job = list.get(idAccumulator);

		System.out.println(_jobs.size());
		idAccumulator++;
		
		return job;
	}

	public void remove(Job job) 
	{
		list.remove(job);
		_jobs.remove(job.getID());
	}
	
	public Job getJob(int id)
	{
		return _jobs.get(id);
	}
	
	
	//clear all jobs and reset id
	public void clear()
	{
		list.clear();
		idAccumulator = 0;
	}
	
	public void change(int id,String newName,String newDes,String newPriority,String newDate)
	{
		Job changed = getJob(id);
		changed.setName(newName);
		changed.setDescription(newDes);
		changed.setPriority(newPriority);
		changed.createDate(newDate);
	}


	public void sort(String attribute)
	{
		System.out.println("Jobs:" + _jobs.size() + "List:" + list.size());
		list.sort(new Comparator<Job>() {
			@Override
			public int compare(Job job, Job t1) {
				return job.getAtrribute(attribute).compareTo(t1.getAtrribute(attribute));
			}
		});

		_jobs.clear();


		for(Job job: list)
		{
			_jobs.put(job.getID(), job);
		}
	}

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
		System.out.println(list.size() + " to filter");
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

	public void printList()
	{
		System.out.println("The details of the list:");
	
		for(Job job:list)
		{
			System.out.println(job.toString());				
		}
	}
	
	public int getId()
	{
		return idAccumulator;
	}

	@Override
	public String toString(){
		String out = "";
		for(Job job : list){
			if(out.length() >= 1)
				out += '\n';
			out += job.toString();
		}
		return out;
	}
}
