/**
 * 
 * <b>Responsabilità: </b>Gestisce la strategia di gioco di un bot.
 * 
 */

import java.util.Random;

/**
 * @author Riccardo Rossi Mori
 *
 */
public class RandomPlayer implements Player {
	Random random;
	public RandomPlayer(int seed){
		random= new Random(seed);
	}
	public RandomPlayer(){
		random=new Random();
	}

	/**
	 * 
	 * Implementa la strategia di gioco di un bot che posiziona <code>Pawn</code> a caso
	 * nella <code>Checkerbox</code> in uso.
	 * @return 
	 * 
	 */
	@Override
	public int strategy() {

		// TODO Auto-generated method stub
		return random.nextInt(1)*10;
	}

	@Override
	public String stampa() {
		return "RandomPlayer";
	}

}
