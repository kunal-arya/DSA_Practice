package Medium;

import java.util.HashMap;

public class Sno_07_Count_number_of_subString {

    public static int countSubK1(String s){
        int i = -1;
        int j = -1;
        int ans = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        while (true){
            boolean f1 = false;
            boolean f2 = false;
            while (i < n - 1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch,0) + 1);

                if(hm.size() > 1){
                    removeChar(hm,ch);
                    i--;
                    break;
                }
            }

            while (j < i){
                f2 = true;
                if(hm.size() == 1){
                    ans += i - j;
                }
                j++;
                char ch = s.charAt(j);
                removeChar(hm,ch);
                if(hm.size() == 0){
                    break;
                }
            }

            if(!f1 && !f2){
                break;
            }
        }
        return ans;
    }
    public static int countSub(String s , int k){

        if(k == 1){
            return countSubK1(s);
        }

        HashMap<Character,Integer> mapB = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();

        int ans = 0;
        int iB = -1;
        int iS = -1;
        int j = -1;
        int n = s.length();
        while (true){

            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;

            while(iB < n - 1){
                f1 = true;
                iB++;
                char ch = s.charAt(iB);
                mapB.put(ch, mapB.getOrDefault(ch,0) + 1);

                if(mapB.size() > k){
                    removeChar(mapB,ch);
                    iB--;
                    break;
                }
            }

            while (iS < iB){
                f2 = true;
                iS++;
                char ch = s.charAt(iS);
                mapS.put(ch, mapS.getOrDefault(ch,0) + 1);

                if(mapS.size() > k - 1){
                    removeChar(mapS,ch);
                    iS--;
                    break;
                }
            }

            while (j < iS){
                f3 = true;
                if(mapB.size() == k && mapS.size() == k - 1){
                    ans += iB - iS;
                }

                j++;
                char ch = s.charAt(j);
                removeChar(mapB,ch);
                removeChar(mapS,ch);

                if(mapB.size() < k || mapS.size() < k - 1){
                    break;
                }
            }

            if(!f1 && !f2 && !f3){
                break;
            }
        }
        return ans;
    }

    public static void removeChar(HashMap<Character,Integer> hm, char ch){
        if(hm.get(ch) == 1){
            hm.remove(ch);
        } else {
            hm.put(ch, hm.get(ch) - 1);
        }
    }

    public static long slidingWindow(String s, int k){
        return slidingWindowk(s,k) - slidingWindowk(s,k - 1);
    }

    public static long slidingWindowk(String s, int k){
        HashMap<Character,Integer> hm = new HashMap<>();
        int j = 0;
        int i = 0;
        int n = s.length();
        long result = 0L;
        while (j < n){
            char charJ = s.charAt(j);
            hm.put(charJ, hm.getOrDefault(charJ,0) + 1);


            if(hm.size() > k){
                while (hm.size() > k) {
                    char charI = s.charAt(i);
                    hm.put(charI, hm.get(charI) - 1);

                    if (hm.get(charI) == 0) {
                        hm.remove(charI);
                    }
                    i++;
                }
            }
            result += (long) j - i + 1;
            j++;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "aba";
        int k = 2;

        String s1 = "abaaca";
        int k2 = 1;
        // output => 7

        // optimised Solution
        int optimised = countSub(s,k);
        System.out.println(optimised);

        // Optimised solution - Sliding Window Algo (( Preferred Way ))
        long result = slidingWindow(s,k);
        System.out.println(result);
    }
}
