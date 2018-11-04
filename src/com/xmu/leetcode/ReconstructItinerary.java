package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ReconstructItinerary {

	public static List<String> findItinerary(String[][] tickets) {
		// construct graph
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		ArrayList<String> al = null;
		for (String[] ticket : tickets) {
			al = graph.get(ticket[0]);
			if (al == null) {
				al = new ArrayList<String>();
				graph.put(ticket[0], al);
			}
			al.add(ticket[1]);
		}
		for (ArrayList<String> curr : graph.values()) {
			Collections.sort(curr);
		}
		ArrayList<String> ans = new ArrayList<>();
		ans.add("JFK");
		itineraryHelper("JFK", ans, graph, tickets.length + 1);
		return ans;
	}

	// n is how many stops totally should contain
	public static boolean itineraryHelper(String curr, List<String> ans, HashMap<String, ArrayList<String>> graph,
			int n) {
		
		if (ans.size() >= n) {
			return true;
		}
		if (!graph.containsKey(curr) || graph.get(curr).isEmpty()) {
			return false;
		}
		ArrayList<String> arrivals = graph.get(curr);
		for (int i = 0; i < arrivals.size(); i++) { // iterate each arrival point
			String arrival = graph.get(curr).remove(i);
			ans.add(arrival);
			if (itineraryHelper(arrival, ans, graph, n)) {
				return true;
			}
			ans.remove(ans.size() - 1); // backtrack
			arrivals.add(i, arrival);
		}
		return false;
	}
}
