package com.primus.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class FiniteValues {

    public static  Map<String, Map<String,String>> FVMap = new LinkedHashMap<>();

    static {
        Map FreqMap= new LinkedHashMap();
        FreqMap.put("FREQMON","Monthly");
        FreqMap.put("FREQWEEK","Weekly");
        FreqMap.put("FREQDAILY","Daily");
        FreqMap.put("FREQQUART","Quarterly");
        FVMap.put("CHITFREQ",FreqMap);

    }

    public  static Map<String,String>  getFiniteValues(String groupCode )
    {
        return FVMap.get(groupCode);
    }
}
