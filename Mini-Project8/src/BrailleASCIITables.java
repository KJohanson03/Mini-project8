// Mini-Project 08
// 
// @author Kevin Johanson
// Worked with Luke Walters
//
// simple implementation of Multiple BitTrees used for braille,unicode, and ascii conversion purposes


import java.io.IOException;

public class BrailleASCIITables {
    

    BitTree brailleToASCII; // bit Tree with bit map location being braille and Ascii being the value at the node 

    BitTree brailleToUnicode;// bit Tree with bit map location being braille and Unicode being the value at the node 

    BitTree asciiToBraille;// bit Tree with bit map location being ASCII and Braille being the value at the node 


    //constructor
    public BrailleASCIITables() throws IOException {
        
    /*File file = new File("src/BrailleToASCII.txt");

    getClass().getResourceAsStream("BrailleToASCII.txt");
    
    FileInputStream input = new FileInputStream(file);          // creates brailleToASCII tree
    */
        this.brailleToASCII = new BitTree(6);
        this.brailleToASCII.load(getClass().getResourceAsStream("BrailleToASCII.txt"));
    // ------------
    /* 
    file = new File("src/BrailleToUnicode.txt");
    input = new FileInputStream(file);
    */
                                                            
        this.brailleToUnicode = new BitTree(6);                 // creates brailleToUnicode tree
        this.brailleToUnicode.load(getClass().getResourceAsStream("BrailleToUnicode.txt"));  
    // ------------
    /* 
    file = new File("src/ASCIIToBraille.txt");
    input = new FileInputStream(file);
    */
    
        this.asciiToBraille = new BitTree(8);                   // creates brailleToUnicode tree
        this.asciiToBraille.load(getClass().getResourceAsStream("ASCIIToBraille.txt"));


        //input.close(); // closes stream
    } //BrailleASCIITables



    // @param letter - Ascii character to be converted
    // 
    // converts an ASCII character to a string of bits representing the corresponding braille character..
    public String toBraille(char letter) throws Exception {
        String temp = "0";
        temp = temp.concat(Integer.toBinaryString(letter));
        return this.asciiToBraille.get(temp);
    } // toBraille



    // @param bits - string of bits representing a braille char
    //
    // converts a string of bits representing a braille character to the corresponding ASCII character.
    public String toASCII(String bits) throws Exception {
        return this.brailleToASCII.get(bits);
    } //toASCII


    // @param bits - string of bits representing a braille char
    //
    // converts a string of bits representing a braille character to the corresponding Unicode braille character for those bits. 
    // You need only support six-bit braille characters.
    public String toUnicode(String bits) throws Exception {
        return this.brailleToUnicode.get(bits);
    } //toUnicode



}//BrailleASCIITables
