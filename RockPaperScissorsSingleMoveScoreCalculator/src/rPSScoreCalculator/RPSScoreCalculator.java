package rPSScoreCalculator;

public class RPSScoreCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String G = "RRRSPPPSSS";
		solution(G);

	}

	public static void solution(String G) throws IllegalArgumentException {
		// Instantiates the choices available to the player
		char[] choices = { 'R', 'S', 'P' };

		// Instantiates the highest score variable and corresponding best gesture. Assigns a placeholder value of N as the highest scoring gesture

		int highestScore = 0;
		char highestScoringGesture = 'N';

		// Loops through the list of possible choices.

		for (int j = 0; j < choices.length; j++) {

			// Instantiated inside the loop, the score is reset to 0 for each new gesture
			int score = 0;

			// Loops through the provided list of the opponent's moves
			for (int i = 0; i < G.length(); i++) {

				// Checks that the list of opponents moves only contains legal characters and
				// throws an exception if not
				if (G.charAt(i) != 'R' && G.charAt(i) != 'S' && G.charAt(i) != 'P') {
					throw new IllegalArgumentException("Must only include RPS");

				} else if (G.charAt(i) == choices[j]) {

					// Increments the score by 1 in a draw.
					score++;
				} else if (choices[j] == 'R') {
					if (G.charAt(i) == 'S') {

						// Increments the score by 2 in a win
						score += 2;
					} else if (G.charAt(i) == 'P') {

						// Does not change the score in a loss
						continue;
					}
				} else if (choices[j] == 'S') {
					if (G.charAt(i) == 'P') {
						score += 2;
					} else if (G.charAt(i) == 'R') {
						continue;
					}
				} else if (choices[j] == 'P') {
					if (G.charAt(i) == 'R') {
						score += 2;
					} else if (G.charAt(i) == 'S') {
						continue;
					}
				}
			}

			// Checks if there is a new highest score and corresponding gesture, and
			// reassigns those variables if true
			if (score > highestScore) {
				highestScore = score;
				highestScoringGesture = choices[j];
			}
		}

		// Prints the highest scoring gesture and corresponding score to screen
		System.out.println("Used exclusively, the highest scoring gesture is " + highestScoringGesture
				+ ", which will score " + highestScore + " points given the opponent's choices.");
	}
}

