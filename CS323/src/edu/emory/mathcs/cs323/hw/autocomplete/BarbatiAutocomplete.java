package edu.emory.mathcs.cs323.hw.autocomplete;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import edu.emory.mathcs.cs323.trie.Trie;
import edu.emory.mathcs.cs323.trie.TrieNode;

/** 
 * @author Joseph Barbati ({@code jdbarba@emory.edu}) 
 */
public class BarbatiAutocomplete extends Trie<List<String>> implements IAutocomplete<List<String>>
{
	
	class NodeStringPair
	{
		TrieNode<List<String>> node;
		String form;
		
		NodeStringPair(TrieNode<List<String>> node, String form)
		{
			this.node = node;
			this.form = form;
		}
	}
	
	final int MAX = 20;
	
	List<String> list = new ArrayList<>();
	
	
	/**
	 * Gets candidates for auto-completion.
	 * @param prefix String to find candidates for
	 * @return returns list of candidates
	 */
	@Override
	public List<String> getCandidates(String prefix) 
	{	
		list.clear();
		
		// Trimming whitespace
		prefix = prefix.trim();
		
		TrieNode<List<String>> prefixNode = find(prefix);
		
		// If prefix doesn't exist, return empty list.
		if (prefixNode == null)
		{
			return list;
		}
		// If prefix exists, check if it has a list and add it to list, if so.
		else
		{
			List<String> prefixList = prefixNode.getValue();
			if (prefixList != null)
				list.addAll(prefixList);
		}

		// If list has 20 or more previously picked candidates, return list.
		if (list.size() == MAX)
		{
			return list;
		}
		else 
		{
			getRemaining(prefix, prefixNode);
		}
		return list;
	}
	
	/**
	 * Takes picked candidate and makes sure its at the top of the list next
	 * time that prefix shows up
	 * @param prefix String to search for and attach candidate to
	 * @param candidate String to add to List attached to prefix.
	 */
	@Override
	public void pickCandidate(String prefix, String candidate) 
	{
//		#######################################################################
//		Handling Prefix		
		prefix    = prefix.trim();
		candidate = candidate.trim();

		TrieNode<List<String>> prefixNode = find(prefix);
		List<String> prefixList;
		
		// If prefix is not in Trie, add it.
		if (prefixNode == null)
		{
			put(prefix, null);
			prefixNode = find(prefix);
			prefixNode.setEndState(false); // Should not be considered a word
		}
		
		prefixList = prefixNode.getValue();
				
		// If prefixList doesn't exist yet, create it
		if (prefixList == null)
		{
			prefixNode.setValue( new ArrayList<>() );
		}
				
		prefixList = prefixNode.getValue();
		
		// Add candidate to index 0 of List
		prefixList.add(0, candidate);
//		#######################################################################	
		
//		#######################################################################
//		Handling Candidate		
		TrieNode<List<String>> candNode = find(candidate);
		// If candidate isn't in Trie, add it.
		if (candNode == null)
		{
			put(candidate, null);
		}
		else
		{
			if (!candNode.isEndState())
			{
				candNode.setEndState(true);
			}
		}
//		#######################################################################
	}
	
	/**
	 * Finds remaining candidates using breadth-first search
	 * @param prefix Prefix to be checked
	 * @param node Starting node
	 */
	private void getRemaining(String prefix, TrieNode<List<String>> node)
	{
		Map<Character, TrieNode<List<String>>> map;
		List<Character> keys;
		NodeStringPair p;
		Deque<NodeStringPair> queue = new ArrayDeque<>();
		queue.add(new NodeStringPair(node, prefix));
		
		while(!queue.isEmpty())
		{
			p = queue.poll();
			
			if (p.node.isEndState() && !list.contains(p.form)) list.add(p.form);
			
			map = p.node.getChildrenMap();
			keys = new ArrayList<>(map.keySet());
			Collections.sort(keys);
			for(Character key : keys)
			{
				queue.add(new NodeStringPair(map.get(key), p.form + key));
			}
		}
	}
}























