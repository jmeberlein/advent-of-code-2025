import java.util.List;

public class Code4A extends CodeBase {
    static Point[] ADJACENCIES = {
        Point.UP, Point.UP.add(Point.LEFT), Point.UP.add(Point.RIGHT),
        Point.LEFT, Point.RIGHT,
        Point.DOWN, Point.DOWN.add(Point.LEFT), Point.DOWN.add(Point.RIGHT)
    };

    public static void main(String[] args) {
        List<String> file = load(args[0]);
        Grid<Boolean> grid = new Grid<>(file.size(), file.get(0).length());

        for (int r = 0; r < file.size(); r++) {
            String line = file.get(r);
            for (int c = 0; c < line.length(); c++) {
                grid.set(r, c, line.charAt(c) == '@');
            }
        }

        long res = 0;
        for (int r = 0; r < file.size(); r++) {
            String line = file.get(r);
            for (int c = 0; c < line.length(); c++) {
                Point p = new Point(r, c);
                if (!grid.get(p)) {
                    System.out.print('.');
                } else if (countAdjacencies(grid, p) < 4) {
                    System.out.print('x');
                    res++;
                } else {
                    System.out.print('@');
                }
            }
            System.out.println();
        }
        System.out.println(res);
    }

    public static int countAdjacencies(Grid<Boolean> grid, Point p) {
        int adj = 0;
        for (Point offset : ADJACENCIES) {
            Point p2 = p.add(offset);
            if (grid.get(p2) != null && grid.get(p2)) {
                adj++;
            }
        }
        return adj;
    }
}
