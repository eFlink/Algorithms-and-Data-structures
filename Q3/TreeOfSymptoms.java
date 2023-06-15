import java.util.ArrayList;
import java.util.Objects;

class Symptom extends SymptomBase {

	public Symptom(String symptom, int severity) {
		super(symptom, severity);
	}

	@Override
	public int compareTo(SymptomBase o) {
		/* Add your code here! */
		return 0;
	}
}

public class TreeOfSymptoms extends TreeOfSymptomsBase {

	public TreeOfSymptoms(SymptomBase root) {
		super(root);
	}

	@Override
	public ArrayList<SymptomBase> inOrderTraversal() {
		/* Add your code here! */
		return null;
	}

	@Override
	public ArrayList<SymptomBase> postOrderTraversal() {
		/* Add your code here! */
		return null;
	}

	@Override
	public void restructureTree(int severity) {
		/* Add your code here! */
	}

	/* Add any extra functions below */

	public static void main(String[] args) {
		/*
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * REMOVE THE MAIN METHOD BEFORE SUBMITTING TO THE AUTOGRADER
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * The following main method is provided for simple debugging only
		 */
		var cough = new Symptom("Cough", 3);
		var fever = new Symptom("Fever", 6);
		var redEyes = new Symptom("Red Eyes", 1);

		redEyes.setLeft(cough);
		redEyes.setRight(fever);

		var tree = new TreeOfSymptoms(redEyes);
		var inOrderTraversal = tree.inOrderTraversal();
		var correctTraversal = new Symptom[] { cough, redEyes, fever };
		int i = 0;
		for (var patient : inOrderTraversal) {
			assert Objects.equals(patient, correctTraversal[i++]);
		}
		assert tree.getRoot() == redEyes;

		tree.restructureTree(2);
		inOrderTraversal = tree.inOrderTraversal();
		correctTraversal = new Symptom[] { redEyes, cough, fever};
		i = 0;
		for (var patient : inOrderTraversal) {
			assert Objects.equals(patient, correctTraversal[i++]);
		}
		assert tree.getRoot() == cough;
	}
}
