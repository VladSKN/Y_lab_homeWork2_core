package homeWork_task3;

import org.junit.Assert;
import org.junit.Test;


public class FuzzySearchTest {


    @Test
    public void fuzzySearchTest() {

        Assert.assertTrue(FuzzySearch.fuzzySearch("car", "ca6$$#_rtwheel"));

        Assert.assertTrue(FuzzySearch.fuzzySearch("cwhl", "cartwheel"));

        Assert.assertTrue(FuzzySearch.fuzzySearch("cwhee", "cartwheel"));

        Assert.assertTrue(FuzzySearch.fuzzySearch("cartwheel", "cartwheel"));

        Assert.assertFalse(FuzzySearch.fuzzySearch("lw", "cartwheel"));

        Assert.assertFalse(FuzzySearch.fuzzySearch("cwheeel", "cartwheel"));
    }
}