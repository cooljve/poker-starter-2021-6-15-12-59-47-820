package com.thoughtworks.refactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerDifferentHandsCategoryTest {

    private static final String STRAIGHT_FLUSH = "A2 K2 Q2 J2 T2";
    private static final String FOUR_OF_A_KIND = "91 92 93 94 53";
    private static final String FULL_HOUSE = "A2 A3 A4 K1 K3";
    private static final String FLUSH = "A1 K1 Q1 J1 91";
    private static final String STRAIGHT = "A1 K1 Q1 J1 T3";
    private static final String THREE_OF_A_KIND = "A1 A3 A4 K1 Q3";
    private static final String TWO_PAIR = "A1 A3 K4 K1 Q3";
    private static final String ONE_PAIR = "A1 A3 K4 Q1 J3";
    private static final String HIGH_CARD = "A1 K3 Q4 J1 83";

    @DisplayName("The one with StraightFlush (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringStraightFlushAndWorseHandsCategoryProvider")
    void test_compare_StraightFlush_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringStraightFlushAndWorseHandsCategoryProvider() {
        return Stream.of(
                Arguments.of(STRAIGHT_FLUSH, FOUR_OF_A_KIND, "black wins - StraightFlush"),
                Arguments.of(STRAIGHT_FLUSH, FULL_HOUSE, "black wins - StraightFlush"),
                Arguments.of(STRAIGHT_FLUSH, FLUSH, "black wins - StraightFlush"),
                Arguments.of(STRAIGHT_FLUSH, STRAIGHT, "black wins - StraightFlush"),
                Arguments.of(STRAIGHT_FLUSH, THREE_OF_A_KIND, "black wins - StraightFlush"),
                Arguments.of(STRAIGHT_FLUSH, TWO_PAIR, "black wins - StraightFlush"),
                Arguments.of(STRAIGHT_FLUSH, ONE_PAIR, "black wins - StraightFlush"),
                Arguments.of(STRAIGHT_FLUSH, HIGH_CARD, "black wins - StraightFlush")
        );
    }

    @DisplayName("The one with FourOfAKind (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringFourOfAKindAndWorseHandsCategoryProvider")
    void test_compare_FourOfAKind_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringFourOfAKindAndWorseHandsCategoryProvider() {
        return Stream.of(
                Arguments.of(FOUR_OF_A_KIND, FULL_HOUSE, "black wins - FourOfAKind"),
                Arguments.of(FOUR_OF_A_KIND, FLUSH, "black wins - FourOfAKind"),
                Arguments.of(FOUR_OF_A_KIND, STRAIGHT, "black wins - FourOfAKind"),
                Arguments.of(FOUR_OF_A_KIND, THREE_OF_A_KIND, "black wins - FourOfAKind"),
                Arguments.of(FOUR_OF_A_KIND, TWO_PAIR, "black wins - FourOfAKind"),
                Arguments.of(FOUR_OF_A_KIND, ONE_PAIR, "black wins - FourOfAKind"),
                Arguments.of(FOUR_OF_A_KIND, HIGH_CARD, "black wins - FourOfAKind")
        );
    }

    @DisplayName("The one with FullHouse (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringFullHouseAndWorseHandsCategoryProvider")
    void test_compare_FullHouse_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringFullHouseAndWorseHandsCategoryProvider() {
        return Stream.of(
//                Arguments.of(FULL_HOUSE, FLUSH, "black wins - FullHouse"),
//                Arguments.of(FULL_HOUSE, STRAIGHT, "black wins - FullHouse"),
//                Arguments.of(FULL_HOUSE, THREE_OF_A_KIND, "black wins - FullHouse"),
//                Arguments.of(FULL_HOUSE, TWO_PAIR, "black wins - FullHouse"),
//                Arguments.of(FULL_HOUSE, ONE_PAIR, "black wins - FullHouse"),
                Arguments.of(FULL_HOUSE, HIGH_CARD, "black wins - FullHouse")
        );
    }

    @DisplayName("The one with Flush (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringFlushAndWorseHandsCategoryProvider")
    void test_compare_Flush_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringFlushAndWorseHandsCategoryProvider() {
        return Stream.of(
                Arguments.of(FLUSH, STRAIGHT, "black wins - Flush"),
                Arguments.of(FLUSH, THREE_OF_A_KIND, "black wins - Flush"),
                Arguments.of(FLUSH, TWO_PAIR, "black wins - Flush"),
                Arguments.of(FLUSH, ONE_PAIR, "black wins - Flush"),
                Arguments.of(FLUSH, HIGH_CARD, "black wins - Flush")
        );
    }

    @DisplayName("The one with Straight (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringStraightAndWorseHandsCategoryProvider")
    void test_compare_Straight_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringStraightAndWorseHandsCategoryProvider() {
        return Stream.of(
                Arguments.of(STRAIGHT, THREE_OF_A_KIND, "black wins - Straight"),
                Arguments.of(STRAIGHT, TWO_PAIR, "black wins - Straight"),
                Arguments.of(STRAIGHT, ONE_PAIR, "black wins - Straight"),
                Arguments.of(STRAIGHT, HIGH_CARD, "black wins - Straight")
        );
    }

    @DisplayName("The one with ThreeOfAKind (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringThreeOfAKindAndWorseHandsCategoryProvider")
    void test_compare_ThreeOfAKind_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringThreeOfAKindAndWorseHandsCategoryProvider() {
        return Stream.of(
                Arguments.of(THREE_OF_A_KIND, TWO_PAIR, "black wins - ThreeOfAKind"),
                Arguments.of(THREE_OF_A_KIND, ONE_PAIR, "black wins - ThreeOfAKind"),
                Arguments.of(THREE_OF_A_KIND, HIGH_CARD, "black wins - ThreeOfAKind")
        );
    }

    @DisplayName("The one with TwoPair (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringTwoPairAndWorseHandsCategoryProvider")
    void test_compare_TwoPair_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringTwoPairAndWorseHandsCategoryProvider() {
        return Stream.of(
                Arguments.of(TWO_PAIR, ONE_PAIR, "black wins - TwoPair"),
                Arguments.of(TWO_PAIR, HIGH_CARD, "black wins - TwoPair")
        );
    }

    @DisplayName("The one with OnePair (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringOnePairAndWorseHandsCategoryProvider")
    void test_compare_OnePair_with_worse_hands_category(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringOnePairAndWorseHandsCategoryProvider() {
        return Stream.of(
                Arguments.of(ONE_PAIR, HIGH_CARD, "black wins - OnePair")
        );
    }


}
