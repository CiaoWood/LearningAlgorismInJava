package javalang;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuchao
 */
public class FindSubstringsByStartEnds implements Testable {

    @Override
    @Test
    public void test() {
        final String content = "bccbbccbakadc";
        final String start = "bc";
        final String end = "c";
        String[] subStrings = findStartEnds(content, start, end);
        Assert.assertEquals(subStrings, 8);
    }

    private String[] findStartEnds(String content, String start, String end) {
        List<Integer> startIndexes = FindIndexes(content, start);
        List<Integer> endIndexes = FindIndexes(content, end);
        List<String> substrings = genSubstringsByStartEndIndexes(content, startIndexes, endIndexes);
        return substrings.toArray(new String[substrings.size()]);
    }

    /**
     * 把序号找出来后，就是杂交打印
     *
     * @param startIndexes
     * @param endIndexes
     */
    private List<String> genSubstringsByStartEndIndexes(String content, List<Integer> startIndexes, List<Integer> endIndexes) {
        List<String> substrings = new ArrayList<>();
        startIndexes.forEach(sI -> {
            endIndexes.forEach(eI -> {
                if (sI < eI && eI < content.length()) {
                    System.out.println(content.substring(sI, eI + 1));
                    substrings.add(content.substring(sI, eI + 1));
                }
            });
        });
        return substrings;
    }

    /**
     * 查找所有序号
     *
     * @param content
     * @param found
     * @return
     */
    private List<Integer> FindIndexes(String content, String found) {
        List<Integer> foundIndexes = new ArrayList<>();
        Integer index = content.indexOf(found);
        while (index >= 0) {
            foundIndexes.add(index);
            index = content.indexOf(found, index + 1);
        }
        return foundIndexes;
    }


}
