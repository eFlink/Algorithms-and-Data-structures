public class Patient extends PatientBase {

    public Patient(String name, String time) {
        super(name, time);
    }

    @Override
    public int compareTo(PatientBase o) {
        /* Add your code here! */
        // Separate time by hours and minutes

        String time1[] = getTime().split(":");
        int hour1 = Integer.parseInt(time1[0]);
        int min1 = Integer.parseInt(time1[1]);

        String time2[] = o.getTime().split(":");
        int hour2 = Integer.parseInt(time2[0]);
        int min2 = Integer.parseInt(time2[1]);

        // Checks if hour is greater or lower
        if (hour1 > hour2) {
            return 1;
        } else if (hour1 < hour2) {
            return -1;
        }
        // Checks if minutes is greater or lower
        if (min1 > min2) {
            return 1;
        } else if (min1 < min2) {
            return -1;
        }
        // Both are even so returns 0
        return 0;
    }
    /* Add any extra functions below */
}
