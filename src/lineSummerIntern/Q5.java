package lineSummerIntern;

public class Q5 {
	static int maxSize;
	static int order;

	public static void main(String[] args) {

	}

	public static String[] getNumber(int number, int size) {
		String[] result = new String[maxSize * 2 - 1];

		StringBuilder str;

		switch(number) {
		case 1:
			for(int i = 0; i < maxSize * 2 - 1; i++) {
				str = new StringBuilder();

				for(int j = 0; j < maxSize; j++) {
					if(j == maxSize - 1)
						str.append("#");
					else
						str.append(".");
				}

				result[i] = str.toString();
			}
			break;
		case 2:
			str = new StringBuilder();
			int[] skip = new int[] {0, (result.length + 1) / 2, result.length -1};
			for(int k : skip) {
				str = new StringBuilder();
				for(int i = 0; i < maxSize; i++)
					str.append("#");
				result[k] = str.toString();
			}

			for(int i = 1; i < (result.length + 1) / 2 - 1; i++) {
				str = new StringBuilder();

				for(int j = 0; j < maxSize; j++) {
					if(j == maxSize - 1)
						str.append("#");
					else
						str.append(".");
				}

				result[i] = str.toString();
			}
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 0:
			break;
			}

			return result;
		}
	
	
	
	}
