import java.util.ArrayList;
// import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	//All non-pugs must remain in the same relative order they were in originally
	//and all pugs must also remain in the same relative order they were in originally
	public static void rescuePugs(ArrayList<Dog> list) {
		ArrayList<Dog> pugs = new ArrayList<Dog>();
		int currentIndex = 0;
		for (Dog d : list) {
			if (d.getBreed().equals("Pug")) {
				pugs.add(d);
			} else {
				list.set(currentIndex, d);
				currentIndex++;
			}
		}
		for (int i = 0; i < pugs.size(); i++) {
			list.set(currentIndex, pugs.get(i));
			currentIndex++;
		}
	}
}
