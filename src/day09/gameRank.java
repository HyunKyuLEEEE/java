package day09;

public class gameRank {
	private String name;
	private int gameNum;
	private int rankNum;
	
	public void updateRankNum(int rankNum) {
		this.rankNum = rankNum;
	}
	
	public void updateGameNum(int gameNum) {
		this.gameNum = gameNum;
	}
	
	public void updateGameRank(int rankNum, int gameNum) {
		updateRankNum(rankNum);
		updateGameNum(gameNum);
	}

	public gameRank() {
		this("", 0, 0);
	}
	public gameRank(String name, int gameNum, int rankNum) {
		super();
		this.name = name;
		this.gameNum = gameNum;
		this.rankNum = rankNum;
	}
	
	
	
}

