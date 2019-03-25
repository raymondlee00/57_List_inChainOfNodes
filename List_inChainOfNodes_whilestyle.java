/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */


    /**
      @return the number of elements in this list
     */
    public int size() {
      int length = 0;
      Node node = headReference;
      while (node != null) {
        length++;
        node = node.getReferenceToNextNode();
      }
      return length;
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
      String str = "[";
      Node node = headReference;
      while (node != null) {
        str += node.getCargoReference() + ",";
        node = node.getReferenceToNextNode();
      }
      return str + "]";
    }


    /**
      Append @value to the head of this list.
      @return true, in keeping with conventions yet to be discussed
     */
    public boolean addAsHead( Object val) {
       Node newHead = new Node(val);
       Node oldHead = this.headReference;
       newHead.setReferenceToNextNode(oldHead);
       this.headReference = newHead;
       return true;
    }
}
