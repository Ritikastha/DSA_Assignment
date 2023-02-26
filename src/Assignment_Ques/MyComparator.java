package Assignment_Ques;


  import java.util.Comparator;

class MyComparator implements Comparator<Huffman.HuffmanNode> {
    public int compare(Huffman.HuffmanNode x, Huffman.HuffmanNode y)
    {
        //used to sort the character in the sequence of r
        return x.data - y.data;
    }
}
