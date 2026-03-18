import java.util.Iterator;
import java.util.List;

public class SwimmersIterator implements Iterator<Swimmer> {

    private List<Swimmer> swimmers;
    private int currentIndex;
    private Swimmer nextValidSwimmer;

    public SwimmersIterator(List<Swimmer> swimmers) {
        this.swimmers = swimmers;
        this.currentIndex = 0;
        this.nextValidSwimmer = findNextValid();
    }

    private Swimmer findNextValid() {
        while (currentIndex < swimmers.size()) {
            Swimmer s = swimmers.get(currentIndex);
            currentIndex++;

            boolean hasEnoughButterfly = s.getButterfly50mTimes().size() >= 5;

            boolean hasQualifiedFreestyle = false;
            for (double time : s.getFreestyle50mTimes()) {
                if (time <= 26.17) {
                    hasQualifiedFreestyle = true;
                    break;
                }
            }

            if (hasEnoughButterfly && hasQualifiedFreestyle) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return nextValidSwimmer != null;
    }

    @Override
    public Swimmer next() {
        Swimmer result = nextValidSwimmer;
        nextValidSwimmer = findNextValid();
        return result;
    }
}