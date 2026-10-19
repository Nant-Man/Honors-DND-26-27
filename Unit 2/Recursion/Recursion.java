import java.util.ArrayList;

public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		// base case is at end, where print just tail value
		if (head.getNext() == null) {
			System.out.print(head.getValue());
			return;
		}
		printListInReverse(head.getNext());
		System.out.print(head.getValue());
	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		// call infect for the surroundings if they can be infected
		// end is when none of the surroundings can be infected

		if (!(r + 1 < grid.length)) {
			return;
		}
		if (!(0 <= r - 1)) {
			return;
		}
		if (!(c + 1 < grid[0].length)) {
			return;
		}
		if (!(0 <= c - 1)) {
			return;
		}
		String currentValue = grid[r][c];
		if (currentValue.equals("vaccinated") || currentValue.equals("infected")) {
			return;
		}
		grid[r][c] = "infected";
		infect(grid, r + 1, c);
		infect(grid, r - 1, c);
		infect(grid, r, c + 1);
		infect(grid, r, c - 1);
	}

	// Subset: a smaller group or collection whose items or elements
	//		are all completely contained within a larger set.
	//
	// How many subsets are there of the numbers 1...n that contain NO consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4}, {1, 3}, {1, 4}, {2, 4}
	// So 8 non-consecutive subsets!
	//
	// Subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		// get all subsets of a smaller length?
		// the subsets from 1...n-1 don't include the n still dont have consec

		// for n, it's the subsets from 1...n-1 (don't include n)
		// plus subsets from 1...n-1 that are nonconsec when n is added / that don't include n-1
		// so with n and without n

		// how many nonconsec subsets in 1...n-1 don't include n-1?
		// that's just nonconsec 1...n-2

		// 1 -> 2 ({} {1})
		// 2 -> 3 ({} {1} {2})
		// 3 -> 5 ({} {1} {2} {3} {1, 3})
		// 4 -> 8 ({} {1} {2} {3} {1, 3} {4} {1, 4} {2, 4})
		
		if (n == 1) {
			return 2;
		}
		if (n == 2) {
			return 3;
		}
		return countNonConsecutiveSubsets(n - 1) + countNonConsecutiveSubsets(n - 2);
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		// add ways if subtract 1, 2, 3 for stairs taken for the last time
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			// 1-1, 2
			return 2;
		}
		if (n == 3) {
			// 1-1-1, 1-2, 2-1, 3
			return 4;
		}
		return countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n - 2) + countWaysToJumpUpStairs(n - 3);
	}

	// --------------------------------------------------------------------
	// NOTE:
	// Everything above the line does NOT require a recursive helper method
	// Everything below the line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) include the role of each parameter in the helper method


	// Prints all the subsets of str on separate lines
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice
	// Precondition: String str has NO repeated characters
	public static void printSubsets(String str) {
		// each char in str is either there or not
		// print current and subset of all one smaller?
		// this method won't work since duplicates of smaller ones eventually

		// somehow need 2*len substrings for each char there/not
		// a method that takes the string, and outputs the specified subset?
		// so then need to somehow recursively find all indices
		// then go "with" and "without"
		// so here, starting with smallest and moving up?

		getNewIndexLists(new int[0], str);
	}

	public static void getNewIndexLists(int[] indexList, String str) {
		printSubsetByIndexList(indexList, str);
		if (indexList.length == 0) {
			for (int i = 0; i < str.length(); i++) {
				int[] newIndexList = {i};
				getNewIndexLists(newIndexList, str);
			}
			return;
		}
		if (indexList[indexList.length - 1] == str.length() - 1) {
			return;
		}
		for (int i = indexList[indexList.length - 1] + 1; i < str.length(); i++) {
			int[] newIndexList = new int[indexList.length + 1];
			for (int j = 0; j < indexList.length; j++) {
				newIndexList[j] = indexList[j];
			}
			newIndexList[newIndexList.length - 1] = i;
			getNewIndexLists(newIndexList, str);
		}
	}

	public static void printSubsetByIndexList(int[] indices, String str) {
		StringBuilder subset = new StringBuilder();
		for (int i : indices) {
			subset.append(str.charAt(i));
		}
		System.out.println(subset);
	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	// Precondition: 	String str has no repeated characters
	public static void printPermutations(String str) {
		// permute a list of indices 0...str.length()-1?

		createPermIndexLists(new int[0], str);
	}

	// what does: recursively builds up int[] of all possible arrangement of int indices to str
	// input: int[] of indices that have built up so far
	// output: int[] of size one greater than input, prints permutation if int[] is of final str length
	private static void createPermIndexLists(int[] indices, String str) {
		if (indices.length == str.length()) {
			printPermByIndexList(indices, str);
			return;
		}
		int[] unusedIndices = new int[str.length() - indices.length];
		int unusedIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			boolean isUsed = false;
			for (int j = 0; j < indices.length; j++) {
				if (i == indices[j]) {
					isUsed = true;
					break;
				}
			}
			if (!isUsed) {
				unusedIndices[unusedIndex] = i;
				unusedIndex++;
			}
		}
		int[] newIndexList = new int[indices.length + 1];
		for (int i = 0; i < indices.length; i++) {
			newIndexList[i] = indices[i];
		}
		for (int i : unusedIndices) {
			newIndexList[newIndexList.length - 1] = i;
			createPermIndexLists(newIndexList, str);
		}
	}

	// what does: print out permutation specified by list/order of indices
	// in: int[] of indices that specify order of chars in String str
	// out: nothing, prints the specified perm
	private static void printPermByIndexList(int[] indices, String str) {
		StringBuilder perm = new StringBuilder();
		for (int i : indices) {
			perm.append(str.charAt(i));
		}
		System.out.println(perm);
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: There are NO duplicates!!!
	public static void mergeSort(int[] ints) {
		// split list until sorted len=1, then combine sorted lists
		// combine(sort(first), sort(second))
		// want a method that takes in a list and combines the two mergesorted halves
		int[] sortedList = mergeSortSection(ints);
		for (int i = 0; i < ints.length; i++) {
			ints[i] = sortedList[i];
		}
	}

	// need a method that can RETURN a mergesorted list
	// takes in a list, splits it, then recombines the mergesorted halves, then returns it
	private static int[] mergeSortSection(int[] l) {
		if (l.length == 1) {
			return l;
		}
		int[] firstHalf = new int[l.length / 2];
		int[] secondHalf = new int[l.length - l.length / 2];
		for (int i = 0; i < l.length; i++) {
			if (i < l.length / 2) {
				firstHalf[i] = l[i];
			} else {
				secondHalf[i - l.length / 2] = l[i];
			}
		}
		return recombineLists(mergeSortSection(firstHalf), mergeSortSection(secondHalf));
	}

	// recombines two sorted input lists into big sorted list
	private static int[] recombineLists(int[] l1, int[] l2) {
		int[] newList = new int[l1.length + l2.length];
		int indexL1 = 0;
		int indexL2 = 0;
		for (int i = 0; i < newList.length; i++) {
			if (indexL1 >= l1.length) {
				newList[i] = l2[indexL2];
				indexL2++;
				continue;
			}
			if (indexL2 >= l2.length) {
				newList[i] = l1[indexL1];
				indexL1++;
				continue;
			}
			if (l1[indexL1] < l2[indexL2]) {
				newList[i] = l1[indexL1];
				indexL1++;
			} else {
				newList[i] = l2[indexL2];
				indexL2++;
			}
		}
		return newList;
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: There are NO duplicates!!!
	// honestly forgot about ArrayList, makes this one easier to do
	public static void quickSort(int[] ints) {
		// pivot divide recombine
		
	}

	private static ArrayList<Integer> quickSortSection(ArrayList<Integer> ints) {
		if (ints.size() <= 1) {
			return ints;
		}

	}

	// Prints a sequence of moves (one on each line) to complete a Towers of Hanoi problem:
	// The towers are number 0, 1, 2, and each move should be printed in the form "1 -> 2",
	// meaning "take the top disk of tower 1 and put it on tower 2" etc.
	// All disks must end on tower 2.
	// Precondition: All disks start on tower 0
	public static void solveHanoi(int startingDisks) {
		// sD = 1: 0->2
			// move bottom of 0 to 2: 0->2 (base?)
		// sD = 2: 0->1, 0->2, 1->2
			// to move bottom of 0->2: move pyramid above to 1, then free to move 0->2
			// then after, pyramid on 1 to 2
		// sD = 3: 0->2, 0->1, 2->1, 0->2, 1->0, 1->2, 0->2
			// first 3 move 2-py to 1, 0->2 is bottom->2, rest is 2-py to 
		// need method move pyramid with n disks from min size to n to target tower
		movePyramid(0, 2, startingDisks);
	}

	// what does: moves a pyramid from a tower to another
	// moves tower of size numDisks (whose top is smallest) located on fromTower to toTower
	// in: int fromTower where pyramid is located, int toTower where to move it, int numDisks for size of pyramid
	// out: print steps to move that pyramid
	private static void movePyramid(int fromTower, int toTower, int numDisks) {
		int unusedTower = 0 + 1 + 2 - fromTower - toTower;
		if (numDisks == 1) {
			System.out.println(fromTower + " -> " + toTower);
			return;
		}
		movePyramid(fromTower, unusedTower, numDisks - 1);
		System.out.println(fromTower + " -> " + toTower);
		movePyramid(unusedTower, toTower, numDisks - 1);
	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret instrument to find many of the most valuable
	// items, but they only appear at VERY SPECIFIC TIMES.
	// You have two arrays
	// 		times[] - Lists at which MINUTE an item becomes available.
	// Precondition: Times is sorted in ascending order.
	//    points[] - Points you score in the ScavHunt for the associated item
	// Precondition: Same length as times[]
	//
	// Problem is: Once you use the device to get an item, no other item will
	// appear for 5 minutes.  So if there is an item, for example, available at
	// time 23 and another at time 27, it's just not possible for you to take both.
	// You'll have to choose!
	// Note: You can take an item at time 23 and another at time 28
	// Write a method that returns the maximum POINTS you can get.
	//
	// Example: if times = [3, 7, 9] and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9 for a total of 20 points, so it would return 20.

	// didn't need helper stuff?
	public static int scavHunt(int[] times, int[] points) {
		if (times.length == 0) {
			return 0;
		}
		if (times.length == 1) {
			return points[0];
		}

		// two cases: take or not take first one, then remove those in 5 min for take
		// take: take remaining valid times and points
		// no take: see rest of list
		// additional if take, not including taken
		int numToSkip = 0;
		for (int i = 1; i < times.length; i++) {
			if (times[i] < 5 + times[0]) {
				numToSkip++;
			} else {
				break;
			}
		}
		int[] takeTimes = new int[times.length - 1 - numToSkip];
		int[] takePoints = new int[times.length - 1 - numToSkip];
		int[] noTakeTimes = new int[times.length - 1];
		int[] noTakePoints = new int[times.length - 1];
		for (int i = 0; i < noTakeTimes.length; i++) {
			noTakeTimes[i] = times[i + 1];
			noTakePoints[i] = points[i + 1];
			if (i < takeTimes.length) {
				takeTimes[i] = times[i + 1 + numToSkip];
				takePoints[i] = points[i + 1 + numToSkip];
			}
		}
		return Math.max(points[0] + scavHunt(takeTimes, takePoints), scavHunt(noTakeTimes, noTakePoints));
	}

}
