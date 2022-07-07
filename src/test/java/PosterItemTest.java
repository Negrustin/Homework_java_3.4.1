import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterItemTest {
    PosterItem item1 = new PosterItem(1, 11, "film1", "genre1");
    PosterItem item2 = new PosterItem(2, 12, "film2", "genre2");
    PosterItem item3 = new PosterItem(3, 13, "film3", "genre3");
    PosterItem item4 = new PosterItem(4, 14, "film4", "genre3");
    PosterItem item5 = new PosterItem(5, 15, "film5", "genre2");
    PosterItem item6 = new PosterItem(6, 16, "film6", "genre2");
    PosterItem item7 = new PosterItem(7, 17, "film7", "genre3");
    PosterItem item8 = new PosterItem(8, 18, "film8", "genre4");
    PosterItem item9 = new PosterItem(9, 19, "film9", "genre3");
    PosterItem item10 = new PosterItem(10, 20, "film10", "genre5");
    PosterItem item11 = new PosterItem(11, 121, "film11", "genre1");

    @Test
    public void addNewPoser() {
        PosterItem item = new PosterItem();
        item.addNewPoster(item1);


        PosterItem[] expected = {item1};
        PosterItem[] actual = item.findAllPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notAddedPosters() {
        PosterItem item = new PosterItem();

        PosterItem[] expected = {};
        PosterItem[] actual = item.findAllPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastPosters() {
        PosterItem item = new PosterItem();
        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);

        item.findLastPosters();

        PosterItem[] expected = {item3, item2, item1};
        PosterItem[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void remoteFilmById() {
        PosterItem item = new PosterItem();

        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);

        item.removeFilmById(item2.getId());

        PosterItem[] excepted = {item1, item2};
        PosterItem[] actual = item.findAllPosters();
    }

    @Test
    public void findLastPostersAboveDefaultUpperLimit() {
        PosterItem item = new PosterItem();

        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);
        item.addNewPoster(item4);
        item.addNewPoster(item5);
        item.addNewPoster(item6);
        item.addNewPoster(item7);
        item.addNewPoster(item8);
        item.addNewPoster(item9);
        item.addNewPoster(item10);
        item.addNewPoster(item11);


        PosterItem[] excepted = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        PosterItem[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void smallMaxLimit() {

        PosterItem item = new PosterItem(5);

        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);
        item.addNewPoster(item4);
        item.addNewPoster(item5);
        item.addNewPoster(item6);

        PosterItem[] excepted = {item6, item5, item4, item3, item2};
        PosterItem[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void findLastPostersAboveUpperLimitParam() {

        PosterItem item = new PosterItem(15);

        item.addNewPoster(item1);
        item.addNewPoster(item2);

        PosterItem[] excepted = {item2, item1};
        PosterItem[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void findLastPostersCountAboveDefaultLimit() {
        PosterItem item = new PosterItem(11);

        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);
        item.addNewPoster(item4);
        item.addNewPoster(item5);
        item.addNewPoster(item6);
        item.addNewPoster(item7);
        item.addNewPoster(item8);
        item.addNewPoster(item9);
        item.addNewPoster(item10);
        item.addNewPoster(item11);

        PosterItem[] excepted = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        PosterItem[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);

    }


}
