import java.util.List;

/**
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface Checkerboard {

	public List<Pawn> pawnNeighbor(Pawn p);
	public void putPawn(int p, Pawn disco);
	int freeRow(int column);
}
