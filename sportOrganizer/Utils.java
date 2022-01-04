package sportOrganizer;

// PAGE OF UTILITY FUNCTIONS

class Utils {
    // FUNCTION: MAKE DATE
    // Uses three ints and makes a date with them.
    public static long makeDate (int date, int month, int year) {
        if (date > 31 || month > 12 || year > 99 || date < 0 || month < 0 || year < 0) {
            System.out.println("Invalid values for a date. Try again.");
            return 0;
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
            return -1;
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
    public static long compareDates (long date1, long date2) {
        int length1 = String.valueOf(date1).length();
        int length2 = String.valueOf(date2).length();
        long temp1 = date1; // use temp variables because I will be manipulating the arguments but want to return them the same as they were passed in.
        long temp2 = date2;

        if (length1 == 10) {
            temp1 /= 10000;
        }
        if (length2 == 10) {
            temp2 /= 10000;
        }

        // check if they are the same years.
        if ((temp1 % 100) < (temp2 % 100)) {
            return date1;
        } else if ((temp1 % 100) > (temp2 % 100)) {
            return date2;
        } 

        // check if they are the same months.
        if ((temp1 % 10000) < (temp2 % 10000)) {
            return date1;
        } else if ((temp1 % 10000) > (temp2 % 10000)) {
            return date2;
        }

        // check if they are the same days.
        if ((temp1 % 1000000) < (temp2 % 1000000)) {
            return date1;
        } else if ((temp1 % 1000000) > (temp2 % 1000000)) {
            return date2;
        }

        // check the times, if they are both 10 digits long and have a time.
        if ((length1 == 10) && (length2 == 10)) {
            // if they are on the same days, check the times.
            temp1 = date1 % 10000;
            temp2 = date2 % 10000;

            if (temp1 < temp2) {
                return date1;
            } else if (temp1 > temp2) {
                return date2;
            }
        }

        // these dates are the same time, might as well return the first one.
        return date1;
    }

    // FUNCTION: QUICKSORT DATES
    // Quicksort functions but for dates.
    public static void quickSortDates (Game arr[], int low, int high) {
        // if low >= high, it'll be 0 or 1 length, and this iteration can stop.
        if (low >= high) {
            return;
        }

        long pivot = arr[high].time; // set pivot to last array entry.
        Game temp; // temp variable for swapping.
        long retLong;
        int i = low-1; // keeps track of where the pivot will be placed at the end.

        for (int j = low; j < high; j++) {
            if ((retLong = compareDates(arr[j].time, pivot)) == arr[j].time) {
                i++; // if the current element is less than or equal to the pivot, i is incremented to reflect
                    // another variable that needs to be before the pivot.

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp; // swap arr[i] with arr[j] so arr[i] will be placed before the pivot.
            }
        }

        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp; // swap pivot with the spot where the elements before it in the array will be less than it,
                        // and the elements after it will be greater than the pivot.
        
        quickSortDates(arr, low, i); // recurisvely call on the lesser side.
        quickSortDates(arr, (i+2), high); // recursively call on the greater side.
    }
}