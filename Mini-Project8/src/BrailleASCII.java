// Mini-Project 08
// 
// @author Kevin Johanson 
// Worked with Luke Walters
//
// A simple implementation of a utility funciton to use the BrailleASCIITables class 


public class BrailleASCII {
    
    public static void main(String args[]) throws Exception{

        BrailleASCIITables table = new BrailleASCIITables();
        String holder = "";
        String converter = "";

        if (args.length != 2) { //checks to make sure 2 arguments were given
            System.err.println("incorrect ammount of arguments: 2 needed");
            return ;
        } // if 

        String source = args[1];
    char[] chArr = source.toCharArray();


        if (args[0].equals("braille")) {
             // array of char of what the string to be converted is
            for (int i = 0; i < chArr.length; i++) {
               
               // holder = holder.concat(table.toBraille(chArr[i])); // not working for some dang reason
                System.out.println(table.toBraille(chArr[i])); // 
               
            } //for 
            
            //System.out.println(holder); // holder string to print out everything on one line

        } else if (args[0].equals("ascii")){
            int iterations = source.length() / 6;
            
            for (int i = 0; i < iterations; i++) {
                System.out.println(table.toASCII(source.substring(i*6, i*6 + 6))); 
            } //for

            System.out.println( holder ); // holder string to print out everything on one line

        } else if (args[0].equals("unicode")) {
           //char[] chArr = source.toCharArray(); // array of char of what the string to be converted is

             for (int i = 0; i < chArr.length; i++) {

                converter = (table.toBraille(chArr[i]));
                converter = converter.substring(0,6); // have to sub for some reason

                converter = table.toUnicode(converter);

                converter = converter.substring(0,4);  // have to sub for some reason
                converter = String.valueOf((char) Integer.parseInt(converter));

                holder = holder.concat(converter); // holder string to print out all chars at once
            } //for 

            System.out.println(holder); // formating

        } else {
            System.out.println("Not a valid command");
        }
    } //main
} //BrailleASCII
