package com.thoughtworks.refactor;

import java.util.*;

public class Poker {
    public String compareResult(String blackHands, String whiteHands) {
        String winResult = "";
        String blackHandsCategory = getHandsCategory(blackHands);
        String whiteHandsCategory = getHandsCategory(whiteHands);
        String[] handsCategories = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
        int[] blackHandsNumbers = getHandsNumbers(blackHands);
        int[] whiteHandsNumbers = getHandsNumbers(whiteHands);
        int blackHandsCategoryRank = getHandsCategoryRank(blackHandsCategory);
        int whiteHandsCategoryRank = getHandsCategoryRank(whiteHandsCategory);
        int[] descendingBlackHandsNumbers = descendingSort(blackHandsNumbers);
        int[] descendingWhiteHandsNumbers = descendingSort(whiteHandsNumbers);
        int[] repeatBlackCardNumbers = getRepeatNumbers(blackHandsNumbers);
        int[] repeatWhiteCardNumbers = getRepeatNumbers(whiteHandsNumbers);
        int[] noRepeatBlackCardNumbers = getNoRepeatNumbers(blackHandsNumbers);
        int[] noRepeatWhiteCardNumbers = getNoRepeatNumbers(whiteHandsNumbers);
        if (blackHandsCategoryRank < whiteHandsCategoryRank) {
            winResult = "black wins - " + handsCategories[blackHandsCategoryRank];
        } else if (blackHandsCategoryRank > whiteHandsCategoryRank) {
            winResult = "white wins - " + handsCategories[whiteHandsCategoryRank];
        } else {
            if (blackHandsCategoryRank == 0) { //同花顺
                if (blackHandsNumbers[0] < whiteHandsNumbers[0]) {
                    String sig = intNumber(whiteHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackHandsNumbers[0] > whiteHandsNumbers[0]) {
                    String sig = intNumber(blackHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackHandsCategoryRank == 1) { //铁支
                if (descendingBlackHandsNumbers[0] < descendingWhiteHandsNumbers[0]) {
                    String sig = intNumber(descendingWhiteHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(descendingBlackHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsCategoryRank == 2) { //葫芦
                if (descendingBlackHandsNumbers[0] < descendingWhiteHandsNumbers[0]) {
                    String sig = intNumber(descendingWhiteHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(descendingBlackHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsCategoryRank == 3) { //同花
                for (int i = 0; i < 5; i++) {
                    if (blackHandsNumbers[i] < whiteHandsNumbers[i]) {
                        String sig = intNumber(whiteHandsNumbers[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackHandsNumbers[i] > whiteHandsNumbers[i]) {
                        String sig = intNumber(blackHandsNumbers[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackHandsCategoryRank == 4) { //顺子
                if (blackHandsNumbers[0] < whiteHandsNumbers[0]) {
                    String sig = intNumber(whiteHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackHandsNumbers[0] > whiteHandsNumbers[0]) {
                    String sig = intNumber(blackHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackHandsCategoryRank == 5) { //三条
                if (repeatBlackCardNumbers[0] < repeatWhiteCardNumbers[0]) {
                    String sig = intNumber(repeatWhiteCardNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(repeatBlackCardNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsCategoryRank == 6) { //两对
                for (int i = 0; i < 2; i++) {
                    if (repeatBlackCardNumbers[i] < repeatWhiteCardNumbers[i]) {
                        String sig = intNumber(repeatWhiteCardNumbers[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (repeatBlackCardNumbers[i] > repeatWhiteCardNumbers[i]) {
                        String sig = intNumber(repeatBlackCardNumbers[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    }
                }
                if (winResult == "") {
                    if (noRepeatBlackCardNumbers[0] < noRepeatWhiteCardNumbers[0]) {
                        String sig = intNumber(noRepeatWhiteCardNumbers[0]);
                        winResult = "white wins - high card:" + sig;
                    } else if (noRepeatBlackCardNumbers[0] > noRepeatWhiteCardNumbers[0]) {
                        String sig = intNumber(noRepeatBlackCardNumbers[0]);
                        winResult = "black wins - high card:" + sig;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackHandsCategoryRank == 7) { //对子
                if (repeatBlackCardNumbers[0] < repeatWhiteCardNumbers[0]) {
                    String sig = intNumber(repeatWhiteCardNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (repeatBlackCardNumbers[0] > repeatWhiteCardNumbers[0]) {
                    String sig = intNumber(repeatBlackCardNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (noRepeatBlackCardNumbers[i] < noRepeatWhiteCardNumbers[i]) {
                            String sig = intNumber(noRepeatWhiteCardNumbers[i]);
                            winResult = "white wins - high card:" + sig;
                            break;
                        } else if (noRepeatBlackCardNumbers[i] > noRepeatWhiteCardNumbers[i]) {
                            String sig = intNumber(noRepeatBlackCardNumbers[i]);
                            winResult = "black wins - high card:" + sig;
                            break;
                        } else {
                            winResult = "tie";
                        }
                    }
                }
            } else { //散牌
                for (int i = 0; i < 5; i++) {
                    if (blackHandsNumbers[i] < whiteHandsNumbers[i]) {
                        String sig = intNumber(whiteHandsNumbers[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackHandsNumbers[i] > whiteHandsNumbers[i]) {
                        String sig = intNumber(blackHandsNumbers[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            }
        }
        return winResult;
    }

    private int[] getNoRepeatNumbers(int[] blackCardNumbers) {
        return noOrRepeatNumber(blackCardNumbers, 1);
    }

    private int[] getRepeatNumbers(int[] blackCardNumbers) {
        return noOrRepeatNumber(blackCardNumbers, 0);
    }

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

    private int[] descendingSort(int[] number) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }
        });
        int[] arrayresult = new int[list.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            arrayresult[i] = entry.getKey();
            i++;
        }
        return arrayresult;
    }

    //先获得数组中每个元素出现的次数，然后再进行计算出现次数大于1的和出现次数等于1的
    private int[] noOrRepeatNumber(int[] number, int flag) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }
        });
        int[] repeatnumber = new int[list.size()];
        int[] norepeatnumber = new int[list.size()];
        int i = 0;
        if (flag == 0) {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    repeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() == 1) {
                    norepeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (flag == 0) {
            for (i = 0; i < repeatnumber.length; i++) {
                hashSet.add(repeatnumber[i]);
            }
        } else {
            for (i = 0; i < norepeatnumber.length; i++) {
                hashSet.add(norepeatnumber[i]);
            }
        }
        hashSet.remove(0);
        int[] result = new int[hashSet.size()];
        i = 0;
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        int[] reResult = new int[result.length];
        for (i = 0; i < result.length; i++) {
            reResult[i] = result[result.length - i - 1];
        }
        return reResult;
    }

    private int getHandsCategoryRank(String strType) {
        int index = -1;
        String[] type = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
        for (int i = 0; i < 9; i++) {
            if (type[i].equals(strType)) {
                index = i;
            }
        }
        return index;
    }

    //判断是什么牌
    private String getHandsCategory(String str) {
        String type = "";
        String[] strArray = str.split("");
        int[] number = getHandsNumbers(str);
        int i;
        String[] color = new String[5];
        for (i = 0; i < 5; i++) {
            color[i] = strArray[i * 3 + 1];
        }
        HashSet<Integer> hashSetNumber = new HashSet<Integer>();
        for (i = 0; i < 5; i++) {
            hashSetNumber.add(number[i]);
        }
        HashSet<String> hashSetType = new HashSet<String>();
        for (i = 0; i < 5; i++) {
            hashSetType.add(color[i]);
        }
        if (hashSetNumber.size() == 5) {
            if ((number[0] - number[4] == 4) && (hashSetType.size() == 1) && (hashSetNumber.size() == 5)) { //五个相邻的数字且花色一样——同花顺
                type = "StraightFlush";
            } else if (number[0] - number[4] == 4 && (hashSetNumber.size() == 5)) { //五个相邻数字——顺子
                type = "Straight";
            } else if (hashSetType.size() == 1) { //同一花色——同花
                type = "Flush";
            } else { //五个不相邻的数字——散牌
                type = "HighCard";
            }
        } else if (hashSetNumber.size() == 4) { //一对相同，其余三个数字不同——对子
            type = "OnePair";
        } else if (hashSetNumber.size() == 3) {
            if ((number[0] == number[1] && number[2] == number[3]) || (number[1] == number[2] && number[3] == number[4]) || (number[0] == number[1] && number[3] == number[4])) { //两对
                type = "TwoPair";
            } else { //三个数字相同，另外两个数字不同——三条
                type = "ThreeOfAKind";
            }
        } else {
            if (number[0] != number[1] || number[3] != number[4]) { //三个数字相同，另外两个数字相同——葫芦
                type = "FourOfAKind";
            } else { //四个数字相同——铁支
                type = "FullHouse";
            }
        }
        return type;
    }

    //数字转化并将其从大到小排序
    private int[] getHandsNumbers(String str) {
        int[] number = new int[5];
        String[] strArray = str.split("");
        int i;
        for (i = 0; i < 5; i++) {
            String c = strArray[i * 3];
            switch (c) {
                case "T":
                    number[i] = 10;
                    break;
                case "J":
                    number[i] = 11;
                    break;
                case "Q":
                    number[i] = 12;
                    break;
                case "K":
                    number[i] = 13;
                    break;
                case "A":
                    number[i] = 14;
                    break;
                default:
                    number[i] = Integer.valueOf(c);
                    break;
            }
        }

        Arrays.sort(number);
        int[] renumber = new int[number.length];
        for (i = 0; i < number.length; i++) {
            renumber[i] = number[number.length - i - 1];
        }
        return renumber;
    }
}
