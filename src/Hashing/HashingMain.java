package Hashing;

import java.util.*;

public class HashingMain {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("listen","silent", "enlist", "rat", "tar", "art"));
        System.out.println( groupAnagram2(list));

    }

    public static boolean vaildAngram(String s , String t){

        Map<Character , Integer> mp = new HashMap<>();

        for(char c : s.toCharArray()){
            mp.put(c , mp.getOrDefault(c , 0)+1);
        }

        for(char c : t.toCharArray()){
            mp.put(c , mp.getOrDefault(c , 0)-1);
            if(mp.get(c)<0){
                return false;
            }
        }
        for(char c : mp.keySet()){
            if(mp.get(c)!=0){
                return false;
            }
        }
        return true;
    }

    public static int numOfPairs(int [] arr , int k) {

        Map<Integer,Integer> map = new HashMap<>();
        int count=0;

        for(int i=0 ; i<arr.length ; i++){
            int target = k-arr[i];
            if(map.containsKey(target)){
                count+=map.get(target);
            }
           map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        return count;
    }

    public static List<List<Integer>> conver2D(int nums[]){

         List<List<Integer>> res = new ArrayList<>();
         Map<Integer,Integer> map = new HashMap<>();

         for(int c : nums){
             map.put(c , map.getOrDefault(c , 0) + 1);
         }
         boolean f = false;
         while(true){

             List<Integer> list = new ArrayList<>();
             for(int c : map.keySet()){
                 if(map.get(c)>0){
                     list.add(c);
                     map.put(c , map.get(c)-1);
                     f=true;
                 }
             }
             if(!f) {
                 break;
             }
             res.add(list);
         }
         return res;
    }


    public static List<List<String>> groubAnagram(String[] arr){

        Map<String , List<String>> map = new HashMap<>();

        for(String s : arr){

            char [] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(!map.containsKey(key)){
                map.put(key , new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static List<Integer> findMisingNumpers(int arr[] , int n){

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<arr.length ; i++){
            set.add(arr[i]);
        }
        for(int i=1 ; i<n ; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }

    public static List<List<Integer>> uniqPairs(int[] arr , int n){

        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int c : arr){
            int rem = n-c;
            if(set.contains(rem)){
                res.add(new ArrayList<>(Arrays.asList(rem , c)));
            }
            set.add(c);
        }
        return res;
    }


    public static int countCommon(int[]arr1 , int []arr2){


        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int c : arr1){
            set1.add(c);
        }
        for(int c : arr2){
            set2.add(c);
        }
        int count=0;
        for(int c : set1){
            if(set2.contains(c)){
                count++;
            }
        }
        return count;
    }

    public static List<Character> findUncommonChar(String s , String t){

        List<Character> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        for(char c : t.toCharArray()){
            set2.add(c);
        }
        for(Character c : set){
            if(!set2.contains(c)){
                res.add(c);
            }
        }
        for(Character c : set2){
            if(!set.contains(c)){
                res.add(c);
            }
        }
        return res;
    }

    public static int maxFreq(int[]arr){
        Set<Integer> set = new HashSet<>();
        for(int c : arr){
            set.add(c);
        }
        int max=0;
        int numMax=0;
        for(int c : set){
            int count=0;
            for(int i=0 ; i<arr.length ; i++){
                if(arr[i]==c){
                    count++;
                }
            }
            if(count>max){
                max=count;
                numMax=c;
            }
        }
        return numMax;
    }

    public static Map <Character,Integer> occurrences (String s){

        Set<Character> set = new HashSet<>();
        Map <Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }

        for(char c : set){
            int count=0;
            for(char i : s.toCharArray()){
                if(c==i){
                    count++;
                }
            }
            map.put(c , count);
        }
        return map;
    }

    public static List<Set<String>> groupAnagram2(List<String> list) {

        List<Set<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        //put the key in the lest(sorted string)
        for(String s : list){
         char [] ch = s.toCharArray();
         Arrays.sort(ch);
         set.add(new String(ch));
        }

        //cheak evry key
        for(String s : set){
            Set<String> temp = new HashSet<>();
            for(String t : list){
                char ch[] = t.toCharArray();
                Arrays.sort(ch);
                String newStr = new String(ch);
                if(s.equals(newStr)){
                    temp.add(t);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static List<String> removeStopWords(List<String> list) {

        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(String s : list){
           set.add(s);
        }
        for(String s : set){
            if(!s.equals("the") && !s.equals("like") && !s.equals("and") && !s.equals("a")){
                res.add(s);
            }
        }
        return res;
    }


}
