
public interface WordPriorityQueueInterface
{

	public void enqueue(Word newEntry);
	public Word dequeue();
	public Word getAtIndex(int index);
	public boolean isEmpty();
	public void clear();
	
}
