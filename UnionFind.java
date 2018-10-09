// @author: Ana Verma

public class UnionFind{

	//linked list which holds onto all the sets in the unionfind 
	Set setList = new Set(null);


	//---- makeSet ----------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------
	public void makeSet(Cell cell){

		//create the new header that will point to the cells within the set
		LLAddOnly newHead = new LLAddOnly();
		newHead.add(cell);

		//create a new set node and insert it into the list of sets 
		Set newSet = new Set(newHead);
		newSet.next = setList.next;
		newSet.prev = setList;
		setList.next = newSet;

		//have the LLAddOnly newHead point to its own set within the list
		newHead.set = newSet;

		if(newSet.next != null){
			newSet.next.prev = newSet;
		}
	}



	//---- find ----------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	public LLAddOnly find(Cell cell){
		//return the set the cell is contained within 
		return cell.head;
	}


	//---- union ---------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	public void union(Cell one, Cell two){

		LLAddOnly head1 = one.head;
		LLAddOnly head2 = two.head;

		//if the heads are equal, that means the cells are already within the same set
		if(head1 == head2){
			System.out.println("Cells are already within the same set.");
			return;
		}

		//if a head is null, that means the cell is not contained within a set 
		else if (head1 == null || head2 == null){
			System.out.println("At least one of the cells is not contained within a set. Please make a new set with the cell before performing this operation.");
			return;
		}

		//make all the cells in head2 point to head1, and change tail pointer of head1, and the next pointer of the last 
		//element in head1 set
		else{
			head1.last.next = head2.first;
			head1.last = head2.last;

			Cell cellToChange = head2.first;
			while(cellToChange != null){
				cellToChange.head = head1;
				cellToChange = cellToChange.next;
			}

			//remove head2 since that set no longer contains anything
			Set head2Set = head2.set;
			Set prev = head2Set.prev;
			Set next = head2Set.next;

			prev.next = next;
			if (next != null) next.prev = prev;
		}
	}
	

}
