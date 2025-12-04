public class Grid<T> {
    private int rows, columns;
    private Object[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Object[rows][columns];
    }

    public void set(Point p, T val) {
        this.set(p.r, p.c, val);
    }

    public void set(int r, int c, T val) {
        this.grid[r][c] = val;
    }

    public T get(Point p) {
        return this.get(p.r, p.c);
    }

    @SuppressWarnings("unchecked")
    public T get(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= columns) {
            return null;
        }

        return (T) this.grid[r][c];
    }
}
