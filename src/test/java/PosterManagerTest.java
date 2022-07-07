import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    PosterManager item1 = new PosterManager(1, 11, "film1", "genre1");
    PosterManager item2 = new PosterManager(2, 12, "film2", "genre2");
    PosterManager item3 = new PosterManager(3, 13, "film3", "genre3");
    PosterManager item4 = new PosterManager(4, 14, "film4", "genre3");
    PosterManager item5 = new PosterManager(5, 15, "film5", "genre2");
    PosterManager item6 = new PosterManager(6, 16, "film6", "genre2");
    PosterManager item7 = new PosterManager(7, 17, "film7", "genre3");
    PosterManager item8 = new PosterManager(8, 18, "film8", "genre4");
    PosterManager item9 = new PosterManager(9, 19, "film9", "genre3");
    PosterManager item10 = new PosterManager(10, 20, "film10", "genre5");
    PosterManager item11 = new PosterManager(11, 121, "film11", "genre1");

    @Test
    public void addNewPoser() {
        PosterManager item = new PosterManager();
        item.addNewPoster(item1);


        PosterManager[] expected = {item1};
        PosterManager[] actual = item.findAllPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notAddedPosters() {
        PosterManager item = new PosterManager();

        PosterManager[] expected = {};
        PosterManager[] actual = item.findAllPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastPosters() {
        PosterManager item = new PosterManager();
        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);

        item.findLastPosters();

        PosterManager[] expected = {item3, item2, item1};
        PosterManager[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void remoteFilmById() {
        PosterManager item = new PosterManager();

        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);

        item.removeFilmById(item2.getId());

        PosterManager[] excepted = {item1, item2};
        PosterManager[] actual = item.findAllPosters();
    }

    @Test
    public void findLastPostersAboveDefaultUpperLimit() {
        PosterManager item = new PosterManager();

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


        PosterManager[] excepted = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        PosterManager[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void smallMaxLimit() {

        PosterManager item = new PosterManager(5);

        item.addNewPoster(item1);
        item.addNewPoster(item2);
        item.addNewPoster(item3);
        item.addNewPoster(item4);
        item.addNewPoster(item5);
        item.addNewPoster(item6);

        PosterManager[] excepted = {item6, item5, item4, item3, item2};
        PosterManager[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void findLastPostersAboveUpperLimitParam() {

        PosterManager item = new PosterManager(15);

        item.addNewPoster(item1);
        item.addNewPoster(item2);

        PosterManager[] excepted = {item2, item1};
        PosterManager[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void findLastPostersCountAboveDefaultLimit() {
        PosterManager item = new PosterManager(11);

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

        PosterManager[] excepted = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        PosterManager[] actual = item.findLastPosters();

        Assertions.assertArrayEquals(excepted, actual);

    }


}
