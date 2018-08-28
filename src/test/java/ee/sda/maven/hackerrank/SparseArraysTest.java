package ee.sda.maven.hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SparseArraysTest {

  @Test
  public void matchingStrings_ReturnsCorrectResult_IfQueryHasNulls() {
    // given
    String[] strings = {"ab", "ab", "abc"};
    String[] queries = {"ab", "abc", null};

    // when
    int[] result = new SparseArrays().matchingStrings(strings, queries);

    // then
    assertEquals(queries.length, result.length);
    assertArrayEquals(new int[]{2, 1, 0}, result);
  }

  @Test
  public void matchingStrings_ReturnsCorrectResult_IfStringsHaveNullAndQueryHasNulls() {
    // given
    String[] strings = {"ab", "ab", "abc", null};
    String[] queries = {"ab", "abc", null};

    // when
    int[] result = new SparseArrays().matchingStrings(strings, queries);

    // then
    assertEquals(queries.length, result.length);
    assertArrayEquals(new int[]{2, 1, 1}, result);
  }

  @Test
  public void matchingStrings_ReturnsCorrectResult_IfLenghtAreEqual() {
    // given
    String[] strings = {"ab", "ab", "abc"};
    String[] queries = {"ab", "abc", "bc"};

    // when
    int[] result = new SparseArrays().matchingStrings(strings, queries);

    // then
    assertEquals(queries.length, result.length);
    assertArrayEquals(new int[]{2, 1, 0}, result);
  }

  @Test
  public void matchingStrings_ReturnsCorrectResult_IfLenghtAreEqualAndDiffBySpace() {
    // given
    String[] strings = {"ab", "ab", "abc"};
    String[] queries = {"ab ", "abc", "bc"};

    // when
    int[] result = new SparseArrays().matchingStrings(strings, queries);

    // then
    assertArrayEquals(new int[]{0, 1, 0}, result);
  }

  @Test
  public void matchingStrings_ReturnsCorrectResult_IfStringsHasLargerLength() {
    // given
    String[] strings = {
        "ab", "ab", "abc",
        "ab", "ab", "abc",
        "xyz", "yz", "z",
        "ab", "ab", "abc",
    };
    String[] queries = {"ab", "abc", "bc"};

    // when
    int[] result = new SparseArrays().matchingStrings(strings, queries);

    // then
    assertArrayEquals(new int[]{6, 3, 0}, result);
  }

  @Test
  public void matchingStrings_ReturnsCorrectResult_IfStringsHasSmallerLength() {
    // given
    String[] strings = {
        "ab", "ab", "abc", "xyz"
    };
    String[] queries = {"ab", "abc", "bc", "xyz", "ab", "qwe", "whatever"};

    // when
    int[] result = new SparseArrays().matchingStrings(strings, queries);

    // then
    assertArrayEquals(new int[]{2, 1, 0, 1, 2, 0, 0}, result);
  }

}