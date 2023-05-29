

public class LinkedList {
    Node head;

    class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }
    //insert at end
        public void insertAtEnd(int newData){
            Node newNode=new Node(newData);
            if(head==null){
                head=new Node(newData);
                return;
            }
            newNode.next=null;
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            return;
        }
        public void printNodes(){
            Node current=head;
            while(current!=null){
                System.out.println(current.data+" ");
                current=current.next;
            }
        }
     //insert at begening
        public void insertAtBeg(int newData){
            Node newNode=new Node(newData);
            newNode.next=head;
            head=newNode;
        }
    //after insert at any poition
        public void insertAfter(Node preNode,int newData){
            if(preNode==null){
                System.out.println("Previous node can't contain null values");
                return;
            }
            Node newNode=new Node(newData);
            newNode.next=preNode.next;
            preNode.next=newNode;
        }
    //deletion of node
    void deletNode(int position){
        if(head==null){
            return;
        }
        Node temp=head;
        if(position==0){
            head=temp.next;
            return;
        }
        for(int i=0; temp !=null && i<position-1;i++){
            temp=temp.next;
        }
        if(temp ==null&&temp.next==null){
            return;
        }
        temp.next=temp.next.next;
    }
    //reverse of LL iteratively
    public void reverseLL(){
        Node curr=head;
        Node pre=null;
        Node nextPtr=null;
        while(curr!=null){
            nextPtr=curr.next;
            curr.next=pre;
            pre=curr;
            curr=nextPtr;
        }
        head=pre;
        return;
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        System.out.print("Before insert data of 5: ");
        ll.printNodes();
        System.out.println("After insert data of 5 at end: ");
        ll.insertAtEnd(5);
        System.out.println("After insert 11 at begining: ");
        ll.insertAtBeg(11);
        System.out.println("Insert after");
        ll.insertAfter(ll.head.next.next,21);
        // ll.deletNode(0);
        // System.out.println("Delation of nodes is: ");
        ll.reverseLL();
        System.out.println("Reversal of LL: ");
        ll.printNodes();  
    }  
}
