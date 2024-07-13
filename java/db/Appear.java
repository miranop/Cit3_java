package db;

import java.sql.Date;
import java.sql.Time;

public class Appear {

	private int id;
	private int number;
	private String name;
	private String ken;
	private String shi;
	private Date date;
	private Time time;
	private String type;

	//コンストラクタ
	public Appear(int id, int number, String name, String type, String ken,
			String shi, Date date, Time time) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.number = number;
		this.ken = ken;
		this.shi = shi;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getnumber() {
		return number;
	}

	public String getken() {
		return ken;
	}

	public String getshi() {
		return shi;
	}

	public Date getdate() {
		return date;
	}

	public Time gettime() {
		return time;
	}

	public String gettype() {
		return type;
	}

}
