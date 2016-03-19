package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		new ConcurrentHashMapTest();
	}

	public ConcurrentHashMapTest() {
		computeIfAbsentTest();
	}
	
	public void computeIfAbsentTest(){
		
		List<String> wordList=Arrays.asList("aa","bb","aa","cc","dd");
		
		ConcurrentHashMap<String,LongAdder> map=new ConcurrentHashMap<>();
		
		for(String word:wordList){
			map.computeIfAbsent(word,w-> new LongAdder()).increment();
		}
		
		System.out.println(map);
	
		
	}
	
}
