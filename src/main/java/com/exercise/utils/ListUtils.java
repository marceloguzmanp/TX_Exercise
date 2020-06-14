package com.exercise.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilities to handle Lists.
 */
public class ListUtils {

  /**
   * Removes empty values from a list.
   *
   * @param list list value.
   * @return a list of strings without empty values.
   */
  public static List<String> removeListEmptyValues(List<String> list) {
    return list.stream().filter(row -> !row.isEmpty()).collect(Collectors.toList());
  }

  /**
   * Removes empty values from a list of lists.
   *
   * @param listOfLists list of lists value.
   * @return the list of lists without empty values.
   */
  public static List<List<String>> removeListOfListsEmptyValues(List<List<String>> listOfLists) {
    List<List<String>> newList = new ArrayList<>();
    for (List<String> valuesRows : listOfLists) {
      newList.add(removeListEmptyValues(valuesRows));
    }
    return newList;
  }

  /**
   * Replaces a value from a list.
   *
   * @param list          the list value.
   * @param textToReplace the text to be replaced.
   * @return list with the replaced values.
   */
  public static List<String> removeTextInList(final List<String> list, final String textToReplace) {
    list.replaceAll(listValue -> {
      int textPosition = listValue.indexOf(textToReplace);
      listValue = (textPosition != -1) ? listValue.substring(0, textPosition) : listValue;
      return listValue;
    });
    return list;
  }

  /**
   * Removes a value from a list of lists.
   *
   * @param listOfLists  the list of lists value.
   * @param replaceValue the value to be replaced in the list of lists.
   * @return list of lists with the replaced values.
   */
  public static List<List<String>> removeTextListOfList(List<List<String>> listOfLists,
      final String replaceValue) {
    List<List<String>> newList = new ArrayList<>();
    for (List<String> valuesRows : listOfLists) {
      newList.add(removeTextInList(valuesRows, replaceValue));
    }
    return newList;
  }

  /**
   * Verifies a subList exists within another list.
   *
   * @param list    the list value.
   * @param subList the sublist value.
   * @return true if list contains the sub list on it, otherwise false.
   */
  public static boolean containsSubList(List<List<String>> list, List<List<String>> subList) {
    final int subListSize = subList.size();
    if (subListSize == 0) {
      return false;
    }
    int count = (int) list.stream().filter(expectedList -> subList.stream()
        .anyMatch(currentList -> currentList.containsAll(expectedList))).count();
    return count == subListSize;
  }
}
