// PAGE OF UTILITY FUNCTIONS

// FUNCTION: MAKE DATE
// Uses three ints and makes a date with them.
public static long makeDate (int date, int month, int year) {
    if (date > 31 || month > 12 || year > 99 || date < 0 || month < 0 || year < 0) {
        System.out.println("Invalid values for a date. Try again.");
        return;
    }

    long returnDate = (long)date*10000 + (long)month*100 + (long)year;
    return returnDate;
}

// FUNCTION: MAKE TIME
// Uses four ints and makes a date and time with them.
public static long makeTime (int date, int month, int year, int time) {
    if (date > 31 || month > 12 || year > 99 || date < 0 ||
    month < 0 || year < 0 || year > 2359 || year < 0) {
        System.out.println("Invalid values for a date. Try again.");
        return;
    }

    long returnDate = (long)date*100000000 + (long)month*1000000 + (long)year*10000 + (long)time;
    return returnDate;
}


// FUNCTION: CHECK DATE MATCH TIME
// Helper function that takes a date (long without the 4 digit time on the end) and a time and checks if they are describing the same day.
public static boolean checkDateMatchTime (long day, long time) {
	if (day/10000 == time) // dividing by 10000 cuts the last 4 digits off a number.
		{ 
			return true;
		}
		return false;
}

// FUNCTION: COMPARE DATES
// Used to compare dates to see which date is chronologically earlier. Used in sorting function.

// FUNCTION: QUICKSORT DATES
// Quicksort functions but for dates.


// FUNCTION: STRING COMPARE
// Utility function to compare two strings. From GeeksForGeeks.com.
@Override
public static int stringCompare (String str1, String 2) {
	int l1 = str1.length();
    int l2 = str2.length();
    int lmin = Math.min(l1, l2);

    for (int i = 0; i < lmin; i++) {
        int str1_ch = (int)str1.charAt(i);
        int str2_ch = (int)str2.charAt(i);

        if (str1_ch != str2_ch) {
            return str1_ch - str2_ch;
        }
    }
  
        // Edge case for strings like
    if (l1 != l2) {
        return l1 - l2;
    }
  
    // If none of the above conditions is true,
    else {
       return 0;
    }
}