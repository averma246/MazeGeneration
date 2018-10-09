// @author: Ana Verma

public class Set{

	//node class for the linked list in UnionFind

	LLAddOnly value; //hold onto the head of the set
	Set next; //next set in the linked list
	Set prev; //set that came before this one in the linked list

	//construct the set node
	public Set(LLAddOnly v){
		value = v;
	}
}
