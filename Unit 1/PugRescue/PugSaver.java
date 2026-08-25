import java.util.ArrayList;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		// right now, just takes last without check
		int lastNonPugIndex = list.size() - 1;
		for (int nextIndex = 0; nextIndex < list.size(); nextIndex++) {
			// if (nextIndex >= lastNonPugIndex) {
			// 	return;
			// }
			Dog d = list.get(nextIndex);
			if (!d.getBreed().equals("Pug")) {
				continue;
			}
			// find next non pug, which starts off being a pug since swapped to there
			Dog lastNonPug = list.get(lastNonPugIndex);
			while (lastNonPug.getBreed().equals("Pug")) {
				lastNonPugIndex--;
				if (lastNonPugIndex <= nextIndex) {
					return;
				}
				lastNonPug = list.get(lastNonPugIndex);
			}
			Dog temp = d;
			list.set(nextIndex, lastNonPug);
			list.set(lastNonPugIndex, temp);
		}
	}
}
