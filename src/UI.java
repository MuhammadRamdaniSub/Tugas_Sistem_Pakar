import java.util.*;

public class UI {
    private ArrayList<String> questions;
    private int[] answers;

    public UI() {
        this.answers = new int[32];
        this.questions = new ArrayList<>();
        this.setQuestions();
    }

    // Setting pertanyaan
    private void setQuestions() {
        questions.add("Apakah Daun Berwarna Klorosis");
        questions.add("Apakah Mengalami Pertumbuhan terhambat");
        questions.add("Apakah Warna putih seperti pada permukaan atas dan bawah daun yang klorosis");
        questions.add("Apakah daun menggulung dan melintir");
        questions.add("Apakah Pembentukan tongkol terganggu Hawar daun");
        questions.add("Apakah daun tampak layu?");
        questions.add("Apakah beberapa bercak kecil menyatu membentuk bercak yang lebih besar?");
        questions.add("Apakah terdapat bercak coklat muda memanjang berbentuk gulungan atau perahu?");
        questions.add("Apakah terdapat bercak coklat berbentuk seperti elips?");
        questions.add("Apakah daun tampak kering?");
        questions.add("Apakah Pada permukaan daun terdapat bintik-bintik kecil berwarna coklat atau kuning?");
        questions.add("Apakah Pada pelepah daun terdapat bintik-bintik merah");
        questions.add("Apakah Terdapat benang-benang yang bentuknya tidak beraturan berwarna putih kemudian coklat");
        questions.add("Apakah Keluar serbuk seperti tepung berwarna coklat kekuningan");
        questions.add("Apakah Tongkol membengkak");
        questions.add("Apakah Pada biji terdapat jamur berwarna putih hingga hitam");
        questions.add("Apakah Biji membengkak");
        questions.add("Apakah Pada biji terbentuk kelenjar");
        questions.add("Apakah Kelobot terbuka dan banyak jamur berwarna putih hingga hitam");
        questions.add("Apakah Terdapat lubang kecil pada daun");
        questions.add("Apakah terdapat sobekan pada batang");
        questions.add("Apakah bunga jantan atau pangkal tongkol");
        questions.add("Apakah batang dan rumbai (bunga jantan) mudah patah");
        questions.add("Apakah tumpukan rumbai yang patah");
        questions.add("Apakah bunga jantan tidak terbentuk");
        questions.add("Apakah terdapat tepung/kotoran di sekitar kerekan");
        questions.add("Apakah daun agak menguning");
        questions.add("Apakah lubang melintang pada daun pada fase vegetatif");
        questions.add("Apakah bulu tongkol jagung terpotong/berkurang/kering");
        questions.add("Apakah ujung tongkol terdapat getaran");
        questions.add("Apakah sering terdapat larva");
    }


    public void showQuestion() {
        try (Scanner sc = new Scanner(System.in)) { // Menggunakan try-with-resources
            int i = 0;
            for (String q : this.questions) {
                System.out.println(q);
                System.out.println("0. Tidak    1. Ya");
                int a = sc.nextInt();
                while (a != 0 && a != 1) {
                    System.out.println("Jawaban tidak sesuai! Harap masukkan 0 atau 1.");
                    a = sc.nextInt();
                }
                answers[i] = a;  // Menyimpan jawaban
                i++;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid, harap masukkan angka 0 atau 1.");
        }
    }

    // Mengambil fakta berdasarkan jawaban user
    public Set<String> getFacts() {
        Set<String> facts = new HashSet<>();
        if (answers[0] == 1) facts.add("a");
        if (answers[1] == 1) facts.add("b");
        if (answers[2] == 1) facts.add("c");
        if (answers[3] == 1) facts.add("d");
        if (answers[4] == 1) facts.add("e");
        if (answers[5] == 1) facts.add("f");
        if (answers[6] == 1) facts.add("g");
        if (answers[7] == 1) facts.add("h");
        if (answers[8] == 1) facts.add("i");
        if (answers[9] == 1) facts.add("j");
        if (answers[10] == 1) facts.add("k");
        if (answers[11] == 1) facts.add("l");
        if (answers[12] == 1) facts.add("m");
        if (answers[13] == 1) facts.add("n");
        if (answers[14] == 1) facts.add("o");
        if (answers[15] == 1) facts.add("p");
        if (answers[16] == 1) facts.add("q");
        if (answers[17] == 1) facts.add("r");
        if (answers[18] == 1) facts.add("s");
        if (answers[19] == 1) facts.add("t");
        if (answers[20] == 1) facts.add("1");
        if (answers[21] == 1) facts.add("2");
        if (answers[22] == 1) facts.add("3");
        if (answers[23] == 1) facts.add("4");
        if (answers[24] == 1) facts.add("5");
        if (answers[25] == 1) facts.add("6");
        if (answers[26] == 1) facts.add("7");
        if (answers[27] == 1) facts.add("8");
        if (answers[28] == 1) facts.add("9");
        if (answers[29] == 1) facts.add("10");
        if (answers[30] == 1) facts.add("11");
        if (answers[31] == 1) facts.add("12");
        return facts;
    }

    // Menampilkan kesimpulan dan semua fakta yang dikumpulkan
    public void showConclusion(boolean p1IsTrue, boolean p2IsTrue, boolean p3IsTrue, boolean p4IsTrue, boolean p5IsTrue, boolean p6IsTrue, Set<String> facts, Set<String> inferredFacts) {
        System.out.println("\n==== Hasil Diagnosa ====");
        System.out.println("Fakta yang diperoleh dari jawaban: " + facts);
        System.out.println("Fakta yang ditarik berdasarkan inferensi: " + inferredFacts);
        System.out.println("Kesimpulan: ");

        if (p1IsTrue) {
            System.out.println("Penyakit p1 terbukti benar.");
        } else {
            System.out.println("Penyakit p1 tidak terbukti.");
        }
        if (p2IsTrue) {
            System.out.println("Penyakit p2 terbukti benar.");
        } else {
            System.out.println("Penyakit p2 tidak terbukti.");
        }
        if (p3IsTrue) {
            System.out.println("Penyakit p3 terbukti benar.");
        } else {
            System.out.println("Penyakit p3 tidak terbukti.");
        }
        if (p4IsTrue) {
            System.out.println("Penyakit p4 terbukti benar.");
        } else {
            System.out.println("Penyakit p4 tidak terbukti.");
        }
        if (p5IsTrue) {
            System.out.println("Penyakit p5 terbukti benar.");
        } else {
            System.out.println("Penyakit p5 tidak terbukti.");
        }
        if (p6IsTrue) {
            System.out.println("Penyakit p6 terbukti benar.");
        } else {
            System.out.println("Penyakit p6 tidak terbukti.");
        }
        System.out.println("========================");
    }
}
