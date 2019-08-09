
public class Driver {
    public static void main(String[] args) {
        String input_file = "", output_file = "";

        for (int i = 0; i < 5; i++) {
            if (args[i].equals("-i"))
                input_file = args[i+1];
            if (args[i].equals("-o"))
                output_file = args[i+1];
        }

        Image img = new Image(input_file);
        QuadTree qt = new QuadTree(img);

        // takes threshold as parameter
        qt.divide(5);

        String output_file_name = "";

        for (int i = 0; i < 5; i++) {
            if (args[i].equals("-c")) {

                // j values can be changed willingly
                // 0 is image itself, 1 appears 4 squares (node depths 1)
                // so on. 
                for (int j = 1; j < 9; j++) {
                    output_file_name = output_file + "-" + j + ".ppm";
                    // takes time
                    System.out.println("Processing... Please wait");
                    qt.compress(j, output_file_name);
                    System.out.println("Process finished succesfully.");
                }
            }
            if (args[i].equals("-e")) {
                System.out.println("Processing... Please wait");
                img.edge_detection(output_file + ".ppm");
                System.out.println("Process finished succesfully.");
            }
        }
    }
}
