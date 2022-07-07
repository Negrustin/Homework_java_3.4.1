
public class PosterManager {
    private int id;
    private int filmId;
    private String filmName;
    private String filmGenre;
    private int maxLimit;

    private PosterManager[] items = new PosterManager[0];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public PosterManager() {
        this.maxLimit = 10;
    }

    public PosterManager(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public PosterManager(int id, int filmId, String filmName, String filmGenre) {
        this.id = id;
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmGenre = filmGenre;
    }

    public void addNewPoster(PosterManager item) {
        PosterManager[] tmp = new PosterManager[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeFilmById(int id) {
        PosterManager[] tmp = new PosterManager[items.length - 1];
        int copyToIndex = 0;
        for (PosterManager item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public PosterManager[] findAllPosters() {
        return items;
    }


    public PosterManager[] findLastPosters() {
        int resultLength;
        if (items.length < maxLimit) {
            resultLength = items.length;
        } else {
            resultLength = maxLimit;
        }

        PosterManager[] tmp = new PosterManager[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = items[items.length - 1 - i];
        }
        return tmp;
    }
}



