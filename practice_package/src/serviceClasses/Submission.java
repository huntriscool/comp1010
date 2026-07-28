package serviceClasses;

public class Submission {
	public char name; // Name of problem
	public String team;
	public int time; //time in seconds
	public boolean acceptedSolution;

	public Submission(char name, String team, int time, boolean accepted) {
		this.name = name;
		this.team = team;
		this.time = time;
		this.acceptedSolution = accepted;
	}

	public boolean isSloution() {
		return this.acceptedSolution;
	}

	public int getTime() {
		return this.time;
	}
	
	public char getName() {
		return this.name;
	}
	
	public String getTeam() {
		return this.team;
	}
}

