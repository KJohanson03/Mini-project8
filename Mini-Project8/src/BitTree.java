// Mini-Project 08
// 
// @author Kevin Johanson 
// Worked with Luke Walters
//
// A simple implementation of Binary tree with bits as the nodes

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class BitTree {

    int levels; // levels in the tree

    BitTreeNode root;
    BitTreeNode curNode;

// @param int n - n levels in the tree 
// builds a tree that will store mappings from strings of n bits to strings.
BitTree(int n) {
    this.levels = n;
    this.root = new BitTreeNode(null);
    this.curNode = this.root;
} //BitTree


// @param String bits - the path through the tree 0 left 1 right
// @param String value - value to be set at the end
// follows the path through the tree given by bits (adding nodes as appropriate) and adds or replaces the value 
// at the end with value. set should throw an exception if bits is the inappropriate length or contains values other than 0 or 1
public void set(String bits, String value) {
    this.curNode = this.root;
    if (bits.length() != this.levels) { // checks that bit length is not equal to the field level
        //throw exception
    } //if

    for (int i = 0; i < bits.length(); i++) {
        if (bits.charAt(i) == '0') {
            
            if (this.curNode.left == null) {
                this.curNode.left = new BitTreeNode(null);
            } // if
            this.curNode = this.curNode.left;

        } else if (bits.charAt(i) == '1') {
            
            if (this.curNode.right == null) {
                this.curNode.right = new BitTreeNode(null);
            } //if
            this.curNode = this.curNode.right;

        } else { // runs if bits does not have a 0 or 1
            // THROW AN EXCEPTION
        }// else 
    } //for

    this.curNode.value = value; // sets value at the end of the bits path
} //set


// @param String bits - the path through the tree 0 left 1 right
// follows the path through the tree given by bits, returning the value at the end. If there is no such path, or if bits is the
// incorrect length, get should throw an exception.
public String get(String bits) throws Exception {

    this.curNode = this.root;

    if (bits.length() != this.levels) { // checks that bit length is not equal to the field level
        throw new Exception();
    } //if

    for (int i = 0; i < bits.length(); i++) {
        if (bits.charAt(i) == '0') {
            
            if (this.curNode.left == null) {
                System.err.println("null exception");
                throw new Exception();
            } //if

            this.curNode = this.curNode.left;


        } else if (bits.charAt(i) == '1') {

            if (this.curNode.right == null) {
                System.err.println("null exception");
                throw new Exception();
            } //if
            
            this.curNode = this.curNode.right;

        } else { // runs if bits does not have a 0 or 1
            System.err.println("bit map does not contain 0 or 1");
            throw new Exception();
        }// else 
    } //for
    
    // if check if value exists at end

    return this.curNode.value; // gets value at the end of the bits path
} //get


// @param PrintWriter pen - PrintWriter object
// prints out the contents of the tree in CSV format. For example, one row of our braille tree will be 101100,M
public void dump(PrintWriter pen) {
    dump(pen, root, "");
} //dump

  /**
   * Dump a portion of the tree to some output location.
   */
  void dump(PrintWriter pen, BitTreeNode node, String location) {
      if (node == null) {
        return;
      } //if

      if ((node.left != null) || (node.right != null)) { // if is not a leaf
        
        dump(pen, node.left, location.concat("0"));
        dump(pen, node.right, location.concat("1"));
      } else if(node.value != null) { // if is a leaf 
        pen.println( location + ", " + node.value);
      }  //if

  } // dump


// @param InputStream source - Input Stream object 
// reads a series of lines of the form bits,value and stores them in the tree.
public void load(InputStream source) throws IOException{
    int temp = 0;
    char ch;
    String line = "";
    String [] setCall = new String[2];

    temp = source.read();

    while ( temp != -1) { // runs through the entire input string 

        ch = ((char) temp);
        if (ch != '\n') { // checks if its not a new line 
            line = line.concat(Character.toString(ch));
        } 
        if (ch == '\n') { // if it is a new line
            setCall = line.split(",", 2); // splits the line that was given to us in CSV format
            this.set(setCall[0], setCall[1]); // calls set using the bit map and value
            line = "";
        } // else 

        // NEEEEEED TO FIX FOR SPASCE ETC LSDT ONE 
        
        temp = source.read();
    } // while

} //load


public static void main(String[] args) throws Exception{

 PrintWriter pen = new PrintWriter(System.out, true);
 BrailleASCIITables Tree = new BrailleASCIITables();

 Tree.asciiToBraille.dump(pen);

 Tree.brailleToASCII.dump(pen);

 Tree.brailleToUnicode.dump(pen);


 //System.out.println("---------" + Character.toChars( Integer.parseInt(Tree.toUnicode("000100")) ));
 
 String temp = Tree.brailleToUnicode.get("100000");
 temp = temp.substring(0,4);
 System.out.println(temp);
 
 char chara = (char) Integer.parseInt(temp);

 System.out.println(Character.toString(chara));
}//main



} //BitTree
