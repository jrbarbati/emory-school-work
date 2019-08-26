/*
 THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
 A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.  Joseph Barbati
*/

import java.util.List;
import java.util.ArrayList;
import java.io.Console;
// NOTE: No other Java libraries allowed (automatic 0)

class EMD<K extends Comparable<K>, V> implements RangeMap<K,V> {
    
    class Node {
        Node left;
        Node right;
        KVPair<K,V> kv;
    }

    private Node root;

    // Add the key and a value to your RangeMap. (For EMD, this would be the
    // name of the movie (key) and its description (value), respectively.) If
    // there is a duplicate key, the old entry should be overwritten with the
    // new value.
    public void add(K key, V value) {
        // TODO: Implement me(basic score)
        Node current = root;
        //If tree is empty
        if (root == null) {
            root = new Node();
            root.kv = new KVPair<K,V>(key, value);
            return;
        }
        while (true) {
            int compare = key.compareTo(current.kv.key);
            //If key is less than current's key, go left or add left if null
            if (compare < 0) {
                if (current.left != null) {
                    current = current.left;
                    continue;
                } else {
                    current.left = new Node();
                    current.left.kv = new KVPair<K,V>(key, value);
                    break;
                }
            //If key is greater than current.key, go right or add right if null
            } else if (compare > 0) {
                if (current.right != null) {
                    current = current.right;
                    continue;
                } else {
                    current.right = new Node();
                    current.right.kv = new KVPair<K,V>(key, value);
                    break;
                }
            //If key is equal to current.key, overwrite value
            } else {
                current.kv.value = value;
                break;
            }
        }
    }


    // Retrieve the value corresponding to key, or return null if the key is
    // not in your RangeMap. The comparison between keys should be exact.
    // (For EMD, this would correspond to the lower-case name of the movie
    // (key).)
    public V get(K key) {
        // TODO: Implement me(basic score)
        Node current = root;
        while (true) {
            //If current is null, key doesn't exist, return null
            if (current == null) {
                return null;
            }
            int compare = key.compareTo(current.kv.key);
            //If key is greater than current's key, go right
            if (compare > 0) {
                current = current.right;
                continue;
            //If key is less than current's key, go left
            } else if (compare < 0) {
                current = current.left;
            //If key is equal to current's key, return that value
            } else {
                return current.kv.value;
            }
        }
    }

    // Return the key in the RangeMap that's lexicographically next after
    // 'key', or return null otherwise. (For EMD, this would correspond to
    // the name of the movie that's next after the one specified. 
    // If key is exactly the name of a movie, next should still return
    // the following movie in the database.)
    // Note that key does not have to exist in the database.
    public K next(K key) {
        // TODO: Implement me(EC for intermediate score)
        
        Node current = root;
        //Return null for empty list
        if (current == null)
            return null;
        
        K potentialNext = null;
        
        while (true) {
            int compare = key.compareTo(current.kv.key);
            int compareNext;
            
            //Makes sure the first comparison to potentialNext sets
            //potentialNext to the first Node that could be next (instead of
            //being null)
            if (potentialNext == null)
                compareNext = 1;
            else
                compareNext = potentialNext.compareTo(current.kv.key);
            
            if (compare >= 0) {
                //if there is no right and potentialNext hasn't changed, then
                //there must be no next and return null
                if (current.right == null && potentialNext == null)
                    return null;
                //if right is null and potetnialNext has changed,
                //then potentialNext is the actual next Node, return it
                else if (current.right == null || compareNext < 0) {
                    return potentialNext;
                }
                //otherwise, move right and check again
                current = current.right;
                continue;
            } else {
                //If current's key is between key and potentialNext's key, then
                //current's key becomes potentialNext's key
                if (compare < 0 && compareNext >= 0) {
                    potentialNext = current.kv.key;
                    //If there is no right or left node, then potentialNext is
                    //actually next and return it.
                    if (current.right == null && current.left == null)
                        return potentialNext;
                    //otherwise, if left is not null, go left
                    if (current.left != null) {
                        current = current.left;
                        continue;
                    //if left is null, potentialNext is actually next
                    } else {
                        return potentialNext;
                    }
                }
            }
        }
    }
    
    // Return a list of key-value pairs in the RangeMap that are between the
    // strings start and end, both inclusive. The list should be in
    // lexicographic order. If no keys match, the method should return the empty list.
    // (For EMD, range would return an alphabetic list of movies titles that
    // are between the two parameter strings). Note that neither start nor
    // end have to exist in the database.
    public List<KVPair<K,V>> range(K start, K end) {
        // TODO: Implement me(EC for full score)
        
        ArrayList<KVPair<K,V>> list = new ArrayList<KVPair<K,V>>();
        
        //rangeHelper() recursively implements inorder traversal
        rangeHelper(start, end, root, list);
        
        return list;
    }
    
    //Implements inorder traversal and adds to list if K of Node x is between
    //start and end (inclusive)
    private void rangeHelper(K start, K end, Node x, ArrayList arrList) {
        if (x == null)
            return;
        //If <= 0, add to list
        int compareStart = start.compareTo(x.kv.key);
        //If >= 0, add to list, else return
        int compareEnd = end.compareTo(x.kv.key);
        
        //go left
        rangeHelper(start, end, x.left, arrList);
        //if between start and end, add current KVPair to list
        if (compareStart <= 0 && compareEnd >= 0) {
            arrList.add(x.kv);
        }
        //go right
        rangeHelper(start, end, x.right, arrList);
        
    }
    
    // Removes the key-value pair with key specified by the parameter from
    // the RangeMap. Does nothing if the key does not exist. 
    // Extra Credit beyond 100%
    public void remove(K key) {
        // TODO: Implement me(EC beyond full score)
        removeHelper(root, root, key);
    }
    
    //Helps the remove function
    //Takes in the current node, the previous node and the key to delete
    //This method first checks see if key is present in tree, if it is, it
    //looks for the minimum value in the right subtree to the key, then swaps
    //the information and then removes the key
    
    /* READ THIS:
     doesn't work correctly because it assumes root either has zero or 2 children
     what if root only has one child?
    */
    private void removeHelper(Node x, Node prev, K key) {
        //if x is null, either empty list or key wasn't found, so we do nothing
        if (x == null)
            return;
        int compare = key.compareTo(x.kv.key);
        //if key is less than the Node, then go left
        if (compare < 0) {
            //if x.left is null, key must not exist, return
            if(x.left == null)
                return;
            removeHelper(x.left, x, key);
        }
        //if key is greater than the Node, go right
        else if (compare > 0) {
            //if x.right is null, key must not exist, return
            if(x.right == null)
                return;
            removeHelper(x.right, x, key);
        }
        //If key is equal to Node x's key, check if there are children
        else {
            //if there are no children, just make Node x null to delete
            if (x.left == null && x.right == null) {
                //if x is root, set root to null
                if (x == root)
                    x = null;
                else if (prev.left == x)
                    prev.left = null;
                else
                    prev.right = null;
            //if there is only a right child,
            } else if (x.left == null) {
                if (x == root) {
                    //Duplicate the right child and set it to root, then remove
                    //right child
                    Node temp = x.right;
                    x.kv = temp.kv;
                    removeHelper(x.right, x, temp.kv.key);
                }
                //x is the right child of prev, then prev.right = x.right
                else if (prev.right == x)
                    prev.right = x.right;
                //x is the left child of prev, then prev.left = x.right
                else
                    prev.left = x.right;
                //set x to null to delete
                x = null;
            //if there is only a left child,
            } else if (x.right == null) {
                if (x == root) {
                    //Duplicate the left child and set it to root, then remove
                    //left child
                    Node temp = x.left;
                    x.kv = temp.kv;
                    removeHelper(x.left, x, temp.kv.key);
                }
                //x is the right child of prev, then prev.right = x.right
                else if (prev.right == x)
                    prev.right = x.left;
                //x is the left child of prev, then prev.left = x.right
                else
                    prev.left = x.left;
                //set x to null to delete
                x = null;
            //if there are two children,
            } else {
                //Find min and set it to temp
                //duplicate temp into x
                //then remove temp
                Node temp = findMinimum(x.right);
                x.kv = temp.kv;
                removeHelper(x.right, x, temp.kv.key);
            }
        }
        return;
    }
    
    private Node findMinimum(Node x) {
        while (x.left != null)
            x = x.left;
        return x;
    }

    /////////////////////////////////////////////////
    // You shouldn't have to change anything below //
    /////////////////////////////////////////////////
    public static void main(String[] args) {
        EMD<Integer, Integer> emd = new EMD<Integer, Integer>();
        emd.add(3, 5);
        System.out.println("Added 3");
        emd.remove(4);
        System.out.println("Removed 4");
        emd.add(4, 4);
        System.out.println("Added 4");
        emd.remove(3);
        System.out.println("Removed 3");
        emd.add(2, 4);
        System.out.println("Added 2");
        emd.remove(1);
        System.out.println("Removed 1");
        emd.add(5, 9);
        System.out.println("Added 5");
        emd.remove(1);
        System.out.println("Removed 1");
        emd.add(4, 8);
        System.out.println("Added 4");
        emd.remove(7);
        System.out.println("Removed 7");
        emd.remove(5);
        System.out.println("Removed 5");
        emd.remove(9);
        System.out.println("Removed 9");
        emd.add(9, 3);
        System.out.println("Added 9");
        System.out.println("Getting 3: " + emd.get(3));
        System.out.println("Getting 4: " + emd.get(4));
        System.out.println("Getting 2: " + emd.get(2));
        System.out.println("Getting 5: " + emd.get(5));
        System.out.println("Getting 7: " + emd.get(7));
        System.out.println("Getting 9: " + emd.get(9));
        System.out.println("Range 0 - 9: " + emd.range(0, 9));
        
        
//        In in;
//        In inputFile = null;
//
//        // read from a given input file instead?
//        if(args.length > 0) {
//            inputFile = new In(args[0]);
//        }
//
//        while(true) {
//            if(inputFile != null ? !inputFile.hasNextLine() : !StdIn.hasNextLine()) {
//                break;
//            }
//            String input =(inputFile != null ? inputFile.readLine() : StdIn.readLine());
//
//            // process commands from the user
//            String[] line = input.split("/");
//            switch(line[0].charAt(0)) {
//                // Open and read a file with "Movie/Information..." lines
//                case 'o':                // e.g. "open/movies.txt"
//                    in = new In(line[1]);
//                    // clean out the old movies
//                    emd = new EMD<String, String>();
//                    while(in.hasNextLine()) {
//                        String[] arr = in.readLine().split("/");
//                        // Test only lower case strings for simplicity
//                        emd.add(arr[0].toLowerCase(), arr[1]);
//                    }
//                    break;
//
//                    // Add a new movie
//                case 'a':                // e.g. "add/Shredder/Foot Clan Ninja"
//                    System.out.println("Adding '" + line[1] + "' ...");
//                    emd.add(line[1].toLowerCase(), line[2]);
//                    break;
//
//                    // Look up a movie
//                case 'g':                // e.g. "get/shredder"
//                    System.out.println("Looking up '" + line[1] + "' ...");
//                    System.out.println(emd.get(line[1].toLowerCase()));
//                    break;
//
//                    // Find next movie after a string(like auto-complete)
//                case 'n':                // e.g. "next/shred" would return "shredder"
//                    System.out.println("Looking up next movie after '" + line[1] + "' ...");
//                    System.out.println(emd.next(line[1].toLowerCase()));
//                    break;
//
//                    // Remove a movie
//                case 'r':                // e.g. "remove/Shredder"
//                    System.out.println("Removing '" + line[1] + "' ...");
//                    emd.remove(line[1].toLowerCase());
//                    break;
//
//                    // Find movies in a range
//                case 'f':                // e.g. "find/shed/shre/"
//                    // might print "sherlock" and "shrek",
//                    // but not "shredder" since it's outside
//                    // the range
//                    List<KVPair<String, String>> list;
//                    System.out.println("Searching range of '" + line[1] + "'-'" + line[2] + "' ...");
//                    list = emd.range(line[1].toLowerCase(), line[2].toLowerCase());
//                    if(list.size() == 0)
//                    {
//                        System.out.println("Not found.\n");
//                    } else {
//                        // print out all movies in this range
//                        for(KVPair<String, String>kv : list)
//                            System.out.println(kv);
//                    }
//                    break;
//                default:
//                    System.out.println("Unknown command. ");
//                    break;
//            }
//        }
    }
};
