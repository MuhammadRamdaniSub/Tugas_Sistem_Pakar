import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static List<Rule> getKnowledge() throws IOException {
        List<Rule> rules = new ArrayList<>();

        // Menambahkan aturan secara manual
        rules.add(new Rule(List.of("a","c"), "b")); // Aturan:
        rules.add(new Rule(List.of("b", "d"), "e")); // Aturan:
        rules.add(new Rule(List.of("d", "e"), "p1")); // Aturan:
        rules.add(new Rule(List.of("f"), "j")); // Aturan: f -> j
        rules.add(new Rule(List.of("g", "h"), "i")); // Aturan: g, h -> i
        rules.add(new Rule(List.of("i", "j"), "p2")); // Aturan: i, j -> p2
        rules.add(new Rule(List.of("j"), "k"));        // j -> k
        rules.add(new Rule(List.of("k"), "m"));        // k -> m
        rules.add(new Rule(List.of("m", "n"), "l"));    // m, n -> l
        rules.add(new Rule(List.of("l"), "p3"));       // l -> p3
        rules.add(new Rule(List.of("o"), "q"));        // o -> q
        rules.add(new Rule(List.of("p"), "r"));        // p -> r
        rules.add(new Rule(List.of("q"), "s"));        // q -> s
        rules.add(new Rule(List.of("r", "s"), "p4"));  // r, s -> p4
        rules.add(new Rule(List.of("1"), "2"));        // 1 -> 2
        rules.add(new Rule(List.of("3", "4"), "5"));   // 3, 4 -> 5
        rules.add(new Rule(List.of("5"), "6"));        // 5 -> 6
        rules.add(new Rule(List.of("7"), "8"));        // 7 -> 8
        rules.add(new Rule(List.of("8"), "p5"));       // 8 -> p5
        rules.add(new Rule(List.of("9"), "10"));       // 9 -> 10
        rules.add(new Rule(List.of("10", "11"), "12"));// 10, 11 -> 12
        rules.add(new Rule(List.of("12", "10"), "p6"));// 12, 10 -> p6


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\usert\\IdeaProjects\\Tugas_Pakar\\src\\Knowlage_Base.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("-");
                    List<String> facts = List.of(parts[0].split(","));
                    String conclusion = parts[1].trim();
                    rules.add(new Rule(facts, conclusion));
                }
            }
        }


        return rules;
    }

    public static void main(String[] args) throws IOException {
        UI tampilan = new UI();
        tampilan.showQuestion();

        // Mengambil fakta dari jawaban pengguna
        Set<String> facts = tampilan.getFacts();

        // Mendapatkan basis pengetahuan
        List<Rule> rules = getKnowledge();

        // Menerapkan inferensi forward chaining
        Set<String> inferredFacts = InferenceForwardChaining.doForwardChaining(rules, facts);
        boolean p1IsTrue = inferredFacts.contains("p1");
        boolean p2IsTrue = inferredFacts.contains("p2");
        boolean p3IsTrue = inferredFacts.contains("p3");
        boolean p4IsTrue = inferredFacts.contains("p4");
        boolean p5IsTrue = inferredFacts.contains("p5");
        boolean p6IsTrue = inferredFacts.contains("p6");
        // Menampilkan kesimpulan
        tampilan.showConclusion(p1IsTrue, p2IsTrue, p3IsTrue, p4IsTrue, p5IsTrue, p6IsTrue, facts, inferredFacts);

    }
}
