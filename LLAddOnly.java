// @author: Kristy Gardner

public class LLAddOnly {

    Cell first;
    Cell last;

    //pointer to the set in the list of sets in the UnionFind class
    //makes it easier to remove a set once it no longer has anything in it
    Set set;

    public void add(Cell x) {
      if(first == null) {
          first = x;
          last = x;
          x.head = this;
      }
      else {
          x.next = first;
          first = x;
          x.head = this;
      }
    }
}
