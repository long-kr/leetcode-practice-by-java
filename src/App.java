import solution.NumberOfIslands;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(NumberOfIslands.numIslands(new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        }));

    }

}
