import java.util.Iterator;
import java.util.Objects;

public class Hospital3 extends HospitalBase {

    public int size;
    public static final int INITIAL_CAPACITY = 10;
    public PatientBase[] patients;

    public Hospital3() {
        /* Add your code here! */
        size = 0;
        patients = new PatientBase[INITIAL_CAPACITY];
    }

    @Override
    public boolean addPatient(PatientBase patient) {
        /* Add your code here! */
        if (!validPatient(patient)) {
            return false;
        }
        if (size == patients.length) {
            // double the size
            reSize();
        }
        patients[size] = patient;
        size++;
        return true;
    }
    public void reSize() {
        int newSize = size * 2;
        PatientBase[] oldArray = patients;
        patients = new PatientBase[newSize];
        for (int i = 0; i < size; i++) {
            patients[i] = oldArray[i];
        }
    }

    @Override
    public Iterator<PatientBase> iterator() {
        /* Add your code here! */
        sort(patients, 0, size - 1);
        Iterator<PatientBase> it = new Iterator<PatientBase>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && patients[currentIndex] != null;
            }

            @Override
            public PatientBase next() {
                return patients[currentIndex++];
            }
        };
        return it;
    }

    /*
     * Checks if patient is valid
     */
    public boolean validPatient(PatientBase patient) {
        String time[] = patient.getTime().split(":");
        int hour;
        int min;
        try {
            hour = Integer.parseInt(time[0]);
            min = Integer.parseInt(time[1]);
        } catch (NumberFormatException e) {
//            System.err.println(e);
            return false;
        }

        if (!(((8 <= hour) && (hour < 12)) || ((13 <= hour) && (hour < 18)))) {
//            System.out.println("invalid hour");
            return false;
        }
        if ((min < 0 || min > 59)) {
//            System.out.println("invalid min");
            return false;
        }
        return true;
    }
    void merge(PatientBase[] arr, int l, int m, int r) {
        // Left and right arrays positions
        int a1 = m - l + 1;
        int a2 = r - m;

        // temp arrays
        PatientBase L[] = new PatientBase[a1];
        PatientBase R[] = new PatientBase[a2];

        // Create left and right arrays
        for (int idx1 = 0; idx1 < a1; ++idx1)
            L[idx1] = arr[l + idx1];
        for (int idx2 = 0; idx2 < a2; ++idx2)
            R[idx2] = arr[m + 1 + idx2];

        // Merge arrays
        int idx1 = 0, idx2 = 0;

        int k = l;
        while (idx1 < a1 && idx2 < a2) {
            if (L[idx1].compareTo(R[idx2]) <= 0) {
                arr[k] = L[idx1];
                idx1++;
            } else {
                arr[k] = R[idx2];
                idx2++;
            }
            k++;
        }

        // copy remaining patients of L or R
        while (idx1 < a1) {
            arr[k] = L[idx1];
            idx1++;
            k++;
        }

        while (idx2 < a2) {
            arr[k] = R[idx2];
            idx2++;
            k++;
        }
    }

    void sort(PatientBase[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* Add any extra functions below */

//    public static void main(String[] args) {
//        /*
//         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//         * REMOVE THE MAIN METHOD BEFORE SUBMITTING TO THE AUTOGRADER
//         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//         * The following main method is provided for simple debugging only
//         */
//
//        var hospital = new Hospital3();
//        var p1 = new Patient("Max", "11:00");
//        var p2 = new Patient("Alex", "13:15");
//        var p3 = new Patient("George", "14:00");
//
//        hospital.addPatient(p1);
//        hospital.addPatient(p2);
//        hospital.addPatient(p3);
//
//
//        Iterator<PatientBase> it = hospital.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        var patients = new Patient[] {p1, p2, p3};
//        int idx1 = 0;
//        for (var patient : hospital) {
//            if (!Objects.equals(patient, patients[idx1++])) {
//                System.err.println("Wrong patient encountered, check your implementation!");
//            }
//        }
//    }
}
