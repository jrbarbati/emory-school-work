/**
 * Copyright 2014, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.cs323.hw.autocomplete;

import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.cs323.trie.Trie;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class DummyAutocomplete extends Trie<List<String>> implements IAutocomplete<List<String>>
{
	@Override
	public List<String> getCandidates(String prefix)
	{
		// TODO must be modified
		List<String> list = new ArrayList<>(); //Used to store candidates that user picks
		
		list.add("These");
		list.add("are");
		list.add("dummy");
		list.add("candidates");
		
		return list;
	}

	@Override
	public void pickCandidate(String prefix, String candidate)
	{
		// TODO must be filled
	}
}