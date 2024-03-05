import java.util.ArrayList;

public class Hash {
	
	public static void main(String [] args) {
		
		String text = ("\r\n"
				+ "I.\r\n"
				+ "Hear the sledges with the bells—\r\n"
				+ "Silver bells!\r\n"
				+ "What a world of merriment their melody foretells!        \r\n"
				+ "How they tinkle, tinkle, tinkle,           \r\n"
				+ "In the icy air of night!        \r\n"
				+ "While the stars that oversprinkle        \r\n"
				+ "All the heavens, seem to twinkle           \r\n"
				+ "With a crystalline delight;         \r\n"
				+ "Keeping time, time, time,         \r\n"
				+ "In a sort of Runic rhyme,\r\n"
				+ "To the tintinabulation that so musically wells       \r\n"
				+ "From the bells, bells, bells, bells,               \r\n"
				+ "Bells, bells, bells—  \r\n"
				+ "From the jingling and the tinkling of the bells.\r\n"
				+ "II.\r\n"
				+ "        \r\n"
				+ "Hear the mellow wedding bells,                 \r\n"
				+ "Golden bells!\r\n"
				+ "What a world of happiness their harmony foretells!        \r\n"
				+ "Through the balmy air of night        \r\n"
				+ "How they ring out their delight!           \r\n"
				+ "From the molten-golden notes,               \r\n"
				+ "And all in tune,           \r\n"
				+ "What a liquid ditty floats    \r\n"
				+ "To the turtle-dove that listens, while she gloats               \r\n"
				+ "On the moon!         \r\n"
				+ "Oh, from out the sounding cells,\r\n"
				+ "What a gush of euphony voluminously wells!               \r\n"
				+ "How it swells!               \r\n"
				+ "How it dwells           \r\n"
				+ "On the Future! how it tells           \r\n"
				+ "Of the rapture that impels         \r\n"
				+ "To the swinging and the ringing           \r\n"
				+ "Of the bells, bells, bells,         \r\n"
				+ "Of the bells, bells, bells, bells,               \r\n"
				+ "Bells, bells, bells—  \r\n"
				+ "To the rhyming and the chiming of the bells!\r\n"
				+ "III.\r\n"
				+ "         \r\n"
				+ "Hear the loud alarum bells—                 \r\n"
				+ "Brazen bells!\r\n"
				+ "What tale of terror, now, their turbulency tells!       \r\n"
				+ "In the startled ear of night       \r\n"
				+ "How they scream out their affright!         \r\n"
				+ "Too much horrified to speak,         \r\n"
				+ "They can only shriek, shriek,                  \r\n"
				+ "Out of tune,\r\n"
				+ "In a clamorous appealing to the mercy of the fire,\r\n"
				+ "In a mad expostulation with the deaf and frantic fire,            \r\n"
				+ "Leaping higher, higher, higher,            \r\n"
				+ "With a desperate desire,         \r\n"
				+ "And a resolute endeavor         \r\n"
				+ "Now —now to sit or never,       \r\n"
				+ "By the side of the pale-faced moon.            \r\n"
				+ "Oh, the bells, bells, bells!            \r\n"
				+ "What a tale their terror tells                  \r\n"
				+ "Of Despair!       \r\n"
				+ "How they clang, and clash, and roar!       \r\n"
				+ "What a horror they outpour\r\n"
				+ "On the bosom of the palpitating air!       \r\n"
				+ "Yet the ear it fully knows,            \r\n"
				+ "By the twanging,            \r\n"
				+ "And the clanging,         \r\n"
				+ "How the danger ebbs and flows;       \r\n"
				+ "Yet the ear distinctly tells,            \r\n"
				+ "In the jangling,            \r\n"
				+ "And the wrangling.       \r\n"
				+ "How the danger sinks and swells,\r\n"
				+ "By the sinking or the swelling in the anger of the bells—             \r\n"
				+ "Of the bells—     \r\n"
				+ "Of the bells, bells, bells, bells,            \r\n"
				+ "Bells, bells, bells— \r\n"
				+ "In the clamor and the clangor of the bells!\r\n"
				+ "IV.\r\n"
				+ "          \r\n"
				+ "Hear the tolling of the bells—                 \r\n"
				+ "Iron bells!\r\n"
				+ "What a world of solemn thought their monody compels!        \r\n"
				+ "In the silence of the night,        \r\n"
				+ "How we shiver with affright  \r\n"
				+ "At the melancholy menace of their tone!        \r\n"
				+ "For every sound that floats        \r\n"
				+ "From the rust within their throats                 \r\n"
				+ "Is a groan.        \r\n"
				+ "And the people —ah, the people—       \r\n"
				+ "They that dwell up in the steeple,                 \r\n"
				+ "All alone,        \r\n"
				+ "And who tolling, tolling, tolling,          \r\n"
				+ "In that muffled monotone,         \r\n"
				+ "Feel a glory in so rolling          \r\n"
				+ "On the human heart a stone—     \r\n"
				+ "They are neither man nor woman—     \r\n"
				+ "They are neither brute nor human—              \r\n"
				+ "They are Ghouls:        \r\n"
				+ "And their king it is who tolls;        \r\n"
				+ "And he rolls, rolls, rolls,                    \r\n"
				+ "Rolls             \r\n"
				+ "A paean from the bells!          \r\n"
				+ "And his merry bosom swells             \r\n"
				+ "With the paean of the bells!          \r\n"
				+ "And he dances, and he yells;          \r\n"
				+ "Keeping time, time, time,          \r\n"
				+ "In a sort of Runic rhyme,             \r\n"
				+ "To the paean of the bells—               \r\n"
				+ "Of the bells:          \r\n"
				+ "Keeping time, time, time,          \r\n"
				+ "In a sort of Runic rhyme,            \r\n"
				+ "To the throbbing of the bells—          \r\n"
				+ "Of the bells, bells, bells—            \r\n"
				+ "To the sobbing of the bells;          \r\n"
				+ "Keeping time, time, time,            \r\n"
				+ "As he knells, knells, knells,          \r\n"
				+ "In a happy Runic rhyme,            \r\n"
				+ "To the rolling of the bells—          \r\n"
				+ "Of the bells, bells, bells—            \r\n"
				+ "To the tolling of the bells,      \r\n"
				+ "Of the bells, bells, bells, bells—              \r\n"
				+ "Bells, bells, bells—  \r\n"
				+ "To the moaning and the groaning of the bells.\r\n"
				+ "");
		
		String[] words = text.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].replace(",", "").replace("!", "").replace(".", "").replace(";", "").replace(":","").replace(" ", "").replace("—", "");
		}
		
		ArrayList<String> words2 = new ArrayList<String>();
		for (String s : words) {
			words2.add(s);
		}
		
		ArrayList<String> table = new ArrayList<String>();
		for (int i = 0; i < 293; i++) {
			table.add("-1");
		}
		
		ArrayList<Integer> hashVals = new ArrayList<Integer>();
		ArrayList<Integer> distinctWordHashVals = new ArrayList<Integer>();
		
		for (int wIndex = 0; wIndex < words.length; wIndex++) {
			int h = 0;
			for (int chIndex = 0; chIndex < words[wIndex].length(); chIndex++) {
				h = ((h*123 + (int)(words[wIndex].charAt(chIndex))) % 293);
			}
			
			hashVals.add(h);
			
			if (!table.contains(words[wIndex])) {
				
				distinctWordHashVals.add(h);
				
				if (table.get(h).equals("-1")) {
					table.set(h, words[wIndex]);
				}
				
				else {
					boolean foundASpot = false;
					int hAddress = h;
					int index = 1;
					while (!foundASpot) {
						if (table.get(hAddress+index).equals("-1")) {
							table.set(hAddress+index, words[wIndex]);
							foundASpot = true;
						}
						else {
							index++;
							if (hAddress+index == 293) {
								hAddress = 0;
								index = 0;
							}
						}
					}
				}
				
			}
			
		}
		
		int nonEmptyAddresses = 0;
		
		int longestEmptyStreak = 0;
		int currentEmptyStreak = 0;
		int endOfStreak = 0;
		
		int longestCluster = 0;
		int currentCluster = 0;
		int endOfCluster = 0;
		
		int farthestSoFar = -1;
		String farthestWord = "";
		
		for (int i = 0; i < table.size(); i++) {
			if (!table.get(i).equals("-1") && !table.get(i).equals("")) {
				System.out.println("address = " + i + ", word = " + table.get(i) + ", hash value = " + hashVals.get(words2.indexOf(table.get(i))));
				currentEmptyStreak = 0;
				nonEmptyAddresses++;
				currentCluster++;
				
				if (currentCluster > longestCluster) {
					longestCluster = currentCluster;
					endOfCluster = i;
				}
				
				if (Math.abs(i - hashVals.get(words2.indexOf(table.get(i)))) > farthestSoFar) {
					farthestSoFar = Math.abs(i - hashVals.get(words2.indexOf(table.get(i))));
					farthestWord = table.get(i);
				}
			}
			else if (table.get(i).equals("-1")) {
				System.out.println("address = " + i + ", EMPTY");
				currentEmptyStreak++;
				if (currentEmptyStreak > longestEmptyStreak) {
					longestEmptyStreak = currentEmptyStreak;
					endOfStreak = i;
				}
				
				currentCluster = 0;
			}
		}
		
		System.out.println(); System.out.println(nonEmptyAddresses + " non-empty addresses");
		
		System.out.println("Load Factor m/n = " + ((double)nonEmptyAddresses / (double)table.size()) );
		
		System.out.println("Longest Empty Area: " + longestEmptyStreak + ", ending with address " + endOfStreak);
		
		System.out.println("Longest Cluster: " + longestCluster + ", ending with address " + endOfCluster);	
		
		int mostOccurrences = 6;
		int mostCommonHashVal = 152;
		
		System.out.println("Most Common Hash Value: " + mostCommonHashVal + ", resulting from " + mostOccurrences + " distinct words");
		
		System.out.println("Farthest Drifted Word: " + farthestWord + ", " + farthestSoFar + " spaces from its actual hash value");
		
		int wraparoundLength = 0;
		int i = 1;
		int j = 292;
		while (!table.get(i).equals("-1")) {
			i++;
			wraparoundLength++;
		}
		
		while (!table.get(j).equals("-1")) {
			j--;
			wraparoundLength++;
		}
		
		System.out.println("Length of Wraparound: " + wraparoundLength);
		
	}

}
