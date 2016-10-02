package montyhallsimulation;
import java.util.Random;

public class DoOneTimeGame {
	boolean Change;
	
	public DoOneTimeGame(boolean Change){
		this.Change=Change;
	}
	
	public DoOneTimeGame(){
		this.Change=false;
	}
	
	public boolean play(){
		int PlayerChoice=0;
		int winningdoor=0;
		int montyChoise=0;
		Random rn= new Random();
		
		//当たりの景品の入ったドアをランダムに決める
		winningdoor=rn.nextInt(3);

		//プレーヤーがランダムにドアを１つ選ぶ（最初の選択）
		PlayerChoice=rn.nextInt(3);
		if(winningdoor==PlayerChoice){
			//プレーヤーが最初の選択で当たりのドアを選んだ場合（1/3の確率で起こる）
			//モンティは残ったはずれのドアの内いずれかを”ランダムに”選ぶ
			//which_door変数は、残ったはずれドア（２つ）のうちどちらかを選ぶための乱数で0または1を取る。
			int which_door=rn.nextInt(1);
			//以下それぞれ当たりのドアが0～2の時の処理
			switch (winningdoor){
			case 0:
				//モンティは、プレーヤーの最初の選択（＝当たり）以外の２つのドアから１つを”ランダムに”選ぶ
				if(which_door==0){
					montyChoise=1;
				}
				else{
					montyChoise=2;
				}
				break;
			case 1:
				which_door=rn.nextInt(1);
				if(which_door==0){
					montyChoise=0;
				}
				else{
					montyChoise=2;
				}
				break;
			case 2:
				which_door=rn.nextInt(1);
				if(which_door==0){
					montyChoise=0;
				}
				else{
					montyChoise=1;
				}
				break;
			}
			//ここで司会者はドアを変更してもよいとプレーヤーに告げる
			if(Change){
				//プレーヤーが最初の選択で当たりのドアを選んでおり、かつプレーヤーがドアを変更するケース
				switch (winningdoor){
				//当たりのドアがそれぞれ0~2だった場合のプレーヤーの選択変更後のドア
				case 0:
					//プレーヤーは最初に選択したドアから、モンティが選ばなかったドアへ選択を変更する
					if(montyChoise==1){
						PlayerChoice=2;
					}
					else{
						PlayerChoice=1;
					}
					break;
				case 1:
					//プレーヤーはまだ開かれていないドアへ選択を変更
					if(montyChoise==0){
						PlayerChoice=2;
					}
					else{
						PlayerChoice=0;
					}
					break;
				case 2:
					//プレーヤーはまだ開かれていないドアへ選択を変更
					if(montyChoise==1){
						PlayerChoice=0;
					}
					else{
						PlayerChoice=1;
					}
					break;
				}
			}
		}
		else{
			//プレーヤーが最初の選択ではずれのドアを選んだ場合（2/3の確率で起こる）
			//モンティは残ったドアのうちはずれ（ヤギのいる）のドアを選択の余地無く開ける。
			switch (winningdoor){
			//当たりのドアがそれぞれ0~1の場合の処理
			case 0:
				//モンティは残ったドアのうち、はずれのドアを必ず開ける
				//この場合、モンティが開けるドアは必然的に決定される（モンティが当たりを引いてはいけないため２つのうち当たりでないドアを開ける）
				//ここで"なんらかの決定がなされていない"（＝確率が収束していない）ということに注意
				//むろんプレーヤーと選択が重複してはいけない
				switch(PlayerChoice){
				//当たり=0の時のプレーヤーの選択別のモンティの選択
				case 1:
					//当たり＝0、最初のプレーヤーの選択＝1の時
					montyChoise=2;
					break;
				case 2:
					//当たり＝0、最初のプレーヤーの選択＝2の時
					montyChoise=1;
					break;
				}
				break;
			case 1:
				switch(PlayerChoice){
				//当たり=1の時のプレーヤーの選択別のモンティの選択
				case 0:
					//当たり＝1、最初のプレーヤーの選択＝0の時
					montyChoise=2;
					break;
				case 2:
					//当たり＝1、最初のプレーヤーの選択＝2の時
					montyChoise=0;
					break;
				}
				break;
			case 2:
				switch(PlayerChoice){
				//当たり=2の時のプレーヤーの選択別のモンティの選択
				case 0:
					//当たり＝2、最初のプレーヤーの選択＝0の時
					montyChoise=1;
					break;
				case 1:
					//当たり＝2、最初のプレーヤーの選択＝1の時
					montyChoise=0;
					break;
				}
				break;
			}
			//ここで司会者はドアを変更してもよいとプレーヤーに告げる
			if(Change){
				//プレーヤーがはずれを選んで（2/3の確率）おり、プレーヤーがドアを変更するケース
				switch (winningdoor){
				//当たりのドアがそれぞれ0~2だった場合のプレーヤーの選択変更後のドア
				//残ったドアのうちモンティが選ばなかったドアへプレーヤーが選択を変更する
				case 0:
					switch(PlayerChoice){
					//当たり=0の時において、モンティーが開いたドア別の、プレーヤーの選択変更後のドア
					case 1:
						//当たり＝0、最初のプレーヤーの選択＝1の時、モンティの選択＝2（当たり≠最初のプレーヤーの選択）
						//プレーヤーはまだ開かれていないドアへ選択を変更
						PlayerChoice=0;
						break;
					case 2:
						//当たり＝0、最初のプレーヤーの選択＝2の時、モンティの選択＝1（当たり≠最初のプレーヤーの選択）
						//プレーヤーはまだ開かれていないドアへ選択を変更
						PlayerChoice=0;
						break;
					}
					break;
				case 1:
					switch(PlayerChoice){
					//当たり=1の時におけるモンティーの選択別のプレーヤーの変更後の選択したドア
					case 0:
						//当たり＝1、最初のプレーヤーの選択＝0の時、モンティの選択は2
						//プレーヤーはまだ開かれていないドアへ選択を変更
						PlayerChoice=1;
						break;
					case 2:
						//当たり＝1、最初のプレーヤーの選択＝2の時、モンティの選択は0（当たり≠最初のプレーヤーの選択）
						//プレーヤーはまだ開かれていないドアへ選択を変更
						PlayerChoice=1;
						break;
					}
					break;
				case 2:
					switch(PlayerChoice){
					//当たり=2の時におけるモンティーの選択別のプレーヤーの変更後の選択したドア
					case 0:
						//当たり＝2、最初のプレーヤーの選択＝0の時、モンティの選択は1（当たり≠最初のプレーヤーの選択）
						//プレーヤーはまだ開かれていないドアへ選択を変更
						PlayerChoice=2;
						break;
					case 1:
						//当たり＝2、最初のプレーヤーの選択＝1の時、モンティの選択は0（当たり≠最初のプレーヤーの選択）
						//プレーヤーはまだ開かれていないドアへ選択を変更
						PlayerChoice=2;
						break;
					}
					break;
				}
			}
		}
		if(PlayerChoice==winningdoor){
			return true;
		}
		else{
			return false;
		}
	}
}
