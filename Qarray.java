package Queue;

public class Qarray {
	int data[];
	int front;
	int rear;
	int size;
	
	public Qarray() {
		data=new int[10];
		rear=front=-1;
		size=0;
	}
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size()==0;
	}
	
	int front() throws QueueEmptyException {
		if(size()==0) {
			throw new QueueEmptyException();
		}	
		return data[front];	
	}
	
	void enqueue(int element)  {
		if(size()==data.length) {
			doublecapacity();
		}
		rear=(1+rear)%data.length;
		size++;
		data[rear]=element;
	}
	
	int dequeue() throws QueueEmptyException {
		if(size()==0) {
			throw new QueueEmptyException();
		}	
		 int temp=data[front];
		 front=(1+front)%data.length;
		 size--;
		 if(size()==0) {
			 front=rear=-1;
		}
		 return temp;
	}
	
	void doublecapacity() {
		int temp[]=data;
		data=new int[2*data.length];
		int index=0;
		for(int i=front;i<temp.length;i++) {
			data[index]=temp[i];
			index++;
		}
		for(int i=0;i<=front-1;i++) {
			data[index]=temp[i];
		}
		front=0;
		rear=temp.length-1;
	}

}

