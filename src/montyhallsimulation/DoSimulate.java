package montyhallsimulation;

public class DoSimulate {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int number_of_trials=100000;
		int win1=0;
		int win2=0;
		DoOneTimeGame DoOneTimeGameWhithChange = new DoOneTimeGame(true);
		DoOneTimeGame DoOneTimeGameWhithOutChange = new DoOneTimeGame(false);
		for(int i=0;i<=number_of_trials;i++){
			if(DoOneTimeGameWhithChange.play()){
				System.out.println("試行回数" + i + "回目。結果＝景品の入ったドアを開けた（当たり）");
				win1++;
			}
			else{
				System.out.println("試行回数" + i + "回目。結果＝開いたドアはヤギだった（はずれ）");
			}
		}
		for(int i=0;i<=number_of_trials;i++){
			if(DoOneTimeGameWhithOutChange.play()){
				System.out.println("試行回数" + i + "回目。結果＝景品の入ったドアを開けた（当たり）");
				win2++;
			}
			else{
				System.out.println("試行回数" + i + "回目。結果＝開いたドアはヤギだった（はずれ）");
			}
		}
		System.out.println("選択を変えてドアを選びプレイヤーが景品の入ったドアを開けた回数=" + win1 + "回");
		System.out.println("選択を変えずにドアを選びプレイヤーが景品の入ったドアを開けた回数=" + win2 + "回");
		double winwithchange=(double)win1;
		double winwithoutchange=(double)win2;
		System.out.println("選択を変えてドアを選びプレイヤーが景品の入ったドアを開けた率=" + (double)(winwithchange/number_of_trials)*100 + "%");
		System.out.println("選択を変えずにドアを選びプレイヤーが景品の入ったドアを開けた率=" + (double)(winwithoutchange/number_of_trials)*100 + "%");
	}
}
