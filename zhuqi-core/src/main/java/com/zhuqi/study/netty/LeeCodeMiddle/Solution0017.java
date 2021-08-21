package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuqi at 2021/3/8
 */
public class Solution0017 {

    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Character, String[]> maps = new HashMap<>();
        maps.put('2', new String[]{"a","b","c"});
        maps.put('3', new String[]{"d","e","f"});
        maps.put('4', new String[]{"g","h","i"});
        maps.put('5', new String[]{"j","k","l"});
        maps.put('6', new String[]{"m","n","o"});
        maps.put('7', new String[]{"p","q","r","s"});
        maps.put('8', new String[]{"t","u","v"});
        maps.put('9', new String[]{"w","x","y","z"});
        dfs(maps, new StringBuilder(), digits, 0);

        return res;

    }

    private void dfs(Map<Character, String[]> maps, StringBuilder tempRes, String s, int index){
        if(index == s.length()){
            res.add(tempRes.toString());
        }else{
            String[] sss = maps.get(s.charAt(index));
            for(String ss: sss){
                System.out.println("ss = " + ss);

                tempRes.append(ss);
                dfs(maps, tempRes, s, index+1);
                tempRes.deleteCharAt(index-1);
            }
        }
    }
}
