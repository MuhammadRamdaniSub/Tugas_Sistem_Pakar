import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InferenceForwardChaining {
    public static Set<String> doForwardChaining(final List<Rule> rules, final Set<String> facts) {
        // Apply forward chaining with loop detection
        Set<String> inferredFacts = new HashSet<>();
        boolean inferred;

        do {
            inferred = false;
            for (Rule rule : rules) {
                if (facts.containsAll(rule.getAntecedent()) && !inferredFacts.contains(rule.getConsequent())) {
                    facts.add(rule.getConsequent());
                    inferredFacts.add(rule.getConsequent());
                    inferred = true;

                    // Optional: Log the newly inferred fact
                    System.out.println("Fakta baru terinferensi: " + rule.getConsequent());
                    break;  // Break to restart the loop to check for more inferences
                }
            }
        } while (inferred);

        return inferredFacts;
    }
}
