import java.util.Iterator;
import java.util.Objects;

public class Hospital2 extends HospitalBase {

    static class Node {
        PatientBase patient;
        Node next;
    }

    static Node newNode(PatientBase patient) {
        Node node = new Node();
        node.patient = patient;
        node.next = null;
        return node;
    }

    public Node head;
    public int size;

    public Hospital2() {
        /* Add your code here! */
        size = 0;
        head = newNode(null);
    }

    @Override
    public boolean addPatient(PatientBase patient) {
        /* Add your code here! */
        if (!validPatient(patient)) {
            return false;
        }
        Node currNode = (head);

        // Create new Node
        Node temp = newNode(patient);

        // Special Case: The head of list has lesser
        // priority than new node. So insert new
        // node before head node and change head node.
        if (head.patient == null || patient.compareTo(head.patient) < 0) {
            // Insert New Node before head
            temp.next = head;
            (head) = temp;
        }
        else {

            // Traverse the list and find a
            // position to insert new node
            while (currNode.next.patient != null &&
                    currNode.next.patient.compareTo(patient) <= 0) {
                currNode = currNode.next;
            }

            // Either at the ends of the list
            // or at required position
            temp.next = currNode.next;
            currNode.next = temp;
        }
        return true;
    }

    @Override
    public Iterator<PatientBase> iterator() {
        /* Add your code here! */
        Iterator<PatientBase> it = new Iterator<PatientBase>() {
            Node currNode = head;

            @Override
            public boolean hasNext() {
                return currNode.next != null;
            }

            @Override
            public PatientBase next() {
                Node next = currNode;
                currNode = currNode.next;
                return next.patient;
            }
        };
        return it;
    }
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
        // check if null??

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

    /* Add any extra functions below */

//    public static void main(String[] args) {
//        /*
//         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//         * REMOVE THE MAIN METHOD BEFORE SUBMITTING TO THE AUTOGRADER
//         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//         * The following main method is provided for simple debugging only
//         */
//        var hospital = new Hospital2();
//        var p1 = new Patient("Max", "11:00");
//        var p2 = new Patient("Alex", "13:15");
//        var p3 = new Patient("George", "14:00");
//        var p4 = new Patient("EJax", "11:00");
//        var p5 = new Patient("Ealex", "12:15");
//        var p6 = new Patient("EGeorge", "14:00");
//        hospital.addPatient(p1);
//        hospital.addPatient(p2);
//        hospital.addPatient(p3);
//        hospital.addPatient(p4);
//        hospital.addPatient(p5);
//        hospital.addPatient(p6);
//
//        System.out.println();
//        Iterator<PatientBase> it = hospital.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        var patients = new Patient[] {p1, p2, p3};
//        int i = 0;
//        for (var patient : hospital) {
//            assert Objects.equals(patient, patients[i++]);
//        }
//    }
}
