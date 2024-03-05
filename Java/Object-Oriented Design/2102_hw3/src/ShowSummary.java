import java.util.LinkedList;

class ShowSummary {
	
	LinkedList<Show> daytime;
	LinkedList<Show> primetime;
	LinkedList<Show> latenight;
	
	ShowSummary() 
	{
		this.daytime = new LinkedList<Show>();
		this.primetime = new LinkedList<Show>();
		this.latenight = new LinkedList<Show>();
	}
	
	ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight)
	{
		this.daytime = daytime;
		this.primetime = primetime;
		this.latenight = latenight;
	}
	
	public boolean equals(Object obj) {
		ShowSummary otherShowSummary = (ShowSummary) obj;
		if(this.daytime.size() == otherShowSummary.daytime.size() &&
				this.primetime.size() == otherShowSummary.primetime.size() &&
				this.latenight.size() == otherShowSummary.latenight.size()) {
				for (int i = 0; i<this.daytime.size(); i++) {
					if(!this.daytime.get(i).title.equals(otherShowSummary.daytime.get(i).title) || 
							this.daytime.get(i).broadcastTime != otherShowSummary.daytime.get(i).broadcastTime) {
						return false;}}
				
				for(int j = 0; j<this.primetime.size(); j++) {
						if(!this.primetime.get(j).title.equals(otherShowSummary.primetime.get(j).title) || 
								this.primetime.get(j).broadcastTime != otherShowSummary.primetime.get(j).broadcastTime) {
							return false;}}
				
				for(int k = 0; k<this.latenight.size(); k++) {
							if(!this.latenight.get(k).title.equals(otherShowSummary.latenight.get(k).title) || 
									this.latenight.get(k).broadcastTime != otherShowSummary.latenight.get(k).broadcastTime) {
								return false;}} 
		return true;
		} else return false;
	}


}
