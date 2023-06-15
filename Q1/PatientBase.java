import java.util.Objects;

public abstract class PatientBase implements Comparable<PatientBase> {

    private final String name;
    private final String time;

    public PatientBase(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", name, time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientBase)) return false;
        PatientBase other = (PatientBase) o;
        return Objects.equals(name, other.name) && Objects.equals(time, other.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time);
    }
}
