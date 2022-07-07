
public class PosterItem {
    private int id;
    private int filmId;
    private String filmName;
    private String filmGenre;
    private int maxLimit;

    private PosterItem[] items = new PosterItem[0];

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

    public PosterItem() {
        this.maxLimit = 10;
    }

    public PosterItem(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public PosterItem(int id, int filmId, String filmName, String filmGenre) {
        this.id = id;
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmGenre = filmGenre;
    }

    public void addNewPoster(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeFilmById(int id) {
        PosterItem[] tmp = new PosterItem[items.length - 1];
        int copyToIndex = 0;
        for (PosterItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public PosterItem[] findAllPosters() {
        return items;
    }


    public PosterItem[] findLastPosters() {
        int resultLength;
        if (items.length < maxLimit) {
            resultLength = items.length;
        } else {
            resultLength = maxLimit;
        }

        PosterItem[] tmp = new PosterItem[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = items[items.length - 1 - i];
        }
        return tmp;
    }
}



