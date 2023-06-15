import java.util.ArrayList;
import java.util.Objects;

abstract class SymptomBase implements Comparable<SymptomBase> {

    private final String symptom;
    private final int severity;
    private SymptomBase left;
    private SymptomBase right;

    public SymptomBase(String symptom, int severity) {
        this.symptom = symptom;
        this.severity = severity;
    }

    public String getSymptom() {
        return symptom;
    }

    public int getSeverity() {
        return severity;
    }

    public SymptomBase getLeft() {
        return left;
    }

    public SymptomBase getRight() {
        return right;
    }

    public void setLeft(SymptomBase left) {
        this.left = left;
    }

    public void setRight(SymptomBase right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", symptom, severity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SymptomBase)) return false;
        SymptomBase other = (SymptomBase) o;
        return Objects.equals(symptom, other.symptom) && severity == other.severity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symptom, severity);
    }
}

public abstract class TreeOfSymptomsBase {
	
	private SymptomBase root;

    public TreeOfSymptomsBase(SymptomBase root) {
        this.root = root;
    }

    public SymptomBase getRoot() {
        return root;
    }

    public void setRoot(SymptomBase root) {
        this.root = root;
    }

    /**
     * Performs an in-order traversal of the tree.
     * @return the list of symptoms, corresponding to the in-order traversal
     */
    public abstract ArrayList<SymptomBase> inOrderTraversal();

    /**
     * Performs a post-order traversal of the tree.
     * @return the list of symptoms, corresponding to the post-order traversal
     */
    public abstract ArrayList<SymptomBase> postOrderTraversal();

    /**
     * Restructures the tree.
     * @param severity severity
     */
    public abstract void restructureTree(int severity);
}
