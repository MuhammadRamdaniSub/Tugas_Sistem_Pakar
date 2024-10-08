import java.util.Collections;
import java.util.List;

public class Rule {
    private final List<String> antecedent; // Menggunakan final untuk immutability
    private final String consequent;

    public Rule(List<String> antecedent, String consequent) {
        if (antecedent == null || antecedent.isEmpty()) {
            throw new IllegalArgumentException("Antecedent cannot be null or empty");
        }
        if (consequent == null) {
            throw new IllegalArgumentException("Consequent cannot be null");
        }

        this.antecedent = Collections.unmodifiableList(antecedent); // Mencegah perubahan
        this.consequent = consequent;
    }

    public List<String> getAntecedent() {
        return antecedent;
    }

    public String getConsequent() {
        return consequent;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "antecedent=" + antecedent +
                ", consequent='" + consequent + '\'' +
                '}';
    }
}
