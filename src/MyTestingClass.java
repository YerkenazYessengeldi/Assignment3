public class MyTestingClass {
    int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id * 31;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MyTestingClass) {
            return this.id == ((MyTestingClass) o).id;
        }
        return false;
    }
}