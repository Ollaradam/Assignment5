
public class WordPriorityQueue implements WordPriorityQueueInterface
{
	
	private Node head;
	
    public WordPriorityQueue(){

        head=new Node(new Word("*", 0, 0));

    }

    @Override
    public void enqueue(Word newEntry) {

        Node temp = head;
        while(temp!=null && temp.next!=null)
        {
        	if(temp.word.getValue().equals(newEntry.getValue()))
        	{
        		temp.word.setCount(temp.word.getCount()+1);
        		return;
        	}
        	temp=temp.next;
        }
        temp = head;
        	while(temp!=null && temp.next!=null && newEntry.priority<=temp.next.word.priority)
        	{
        		temp=temp.next;
        	}

        Node newNode = new Node(newEntry);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    @Override
	public Word dequeue() {
		Word front = null;
		
		if(!isEmpty())
		{
			front = head.word;
			head = head.next;
		}
		return front;
	}

	@Override
	public Word getAtIndex(int index) {
		Node current = head.next;
        for (int i = 0; i < index && current.next != null; i++) {
            current = current.next;
        }
        return current.word;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		head = null;
		
	}
	
	void print(){

        Node temp=head.next;
        
        while(temp!=null){

            System.out.print(temp.word.getValue() + " has occurred " + temp.word.getCount() + " times. Its location on the list is at " 
            + temp.word.getFirstLocation() + ".\n");

            temp=temp.next;

        }
        System.out.println("");
    }
	
	static class Node {
        Word word;
        Node next;

        public Node(Word word) {

            this.word = word;

            next = null;

        }

    }

}
