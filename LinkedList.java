package singlylinkedlist;
/**
 * @author dmayank
 */
class LinkedList {

    static Node head=null;

    class Node{
        Node next;
        int data;
        
        Node(int d){
            data=d;
            next=null;
        }
    }
    
    //Finding length of linked list.
    int length() {
        int i=0;
        Node start=head;
        while(start!=null){
            i++;
            start=start.next;
        }
        return i;
    }
    
    int midelement() {
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return slow.data;
    }
    
    //Reordering a linked list
    void reorder(Node head) {
        
    }
    //K group reverse
    Node reverseKgrouporder(Node head,int k) {
        Node start=head;
        Node nextnode=null;
        Node prev=null;
        
        int n=0;
        //Loop to reverse k group
        while(start!=null && n<k){
            nextnode=start.next;
            start.next=prev;
            prev=start;
            start=nextnode;
            n++;
        }
        if(nextnode!=null){
            head.next=reverseKgrouporder(nextnode,k);
        }
        return prev;
    }

    //To find element
    boolean findelement(int d) {
        Node start=head;
        if(start==null){
            return false;
        }
        while(start!=null){
            if(start.data==d){
                return true;
            }
            start=start.next;
        }
        return false;
        
    }
    //Recursive Reverse
    Node recReverse(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        
        Node chotahead=recReverse(head.next);
        head.next.next=head;
        head.next=null;
        
        return chotahead;
        
    }
    
    //Recursive reverse 2
    /*Node recReverse2(Node head){
        if(head==null || head.next==null){
            return head;
        }
        
        Node chotahead=recReverse2(head.next);
        Node temp=chotahead;
        while(temp.next!=null){
            temp=temp.next;
        }
        
        temp.next=head;
        head.next=null;
        
        return chotahead;
        
    }*/
    
    //reverse
    void reverse(){
        Node start=head;
        Node prev=null;
        Node nextnode=null;
        
        while(start!=null){
            nextnode=start.next;
            start.next=prev;
            prev=start;
            start=nextnode;
        }
        head=prev;
    }
    
    //Kth from end when u r not given length..means u can't use n-Kth from start wala approach
    int kfromend(int k) {
        Node start=head;
        Node fast=start;
        Node slow=start;
        int i=0;
        if(start!=null){
            
            while(i<k){             //phle fast pointer ko k jump krwa lo..
                    
                    if(fast==null){
                        System.out.println("-1");
                    }
                    fast=fast.next;
                    i++;
                }
            
           while(fast!=null){               //fr jb tk fast null ni hota h tb tk fast aur slow ko 1-1 jump krwao
               slow=slow.next;
               fast=fast.next;
           }
        }
        return slow.data;
    }
    
    //Bubble Sort
    void bubblesort() {
        
            int n=length();
            
            for(int i=0;i<n-1;i++){
                
                Node start=head;
            
                Node prev=null;
            
            while(start!=null && start.next!=null){
                
                if(start.data > start.next.data){
                    //Swapping if element is head
                    if(prev==null){
                        Node nextnode=start.next;
                        start.next=nextnode.next;
                        nextnode.next=start;
                        head=nextnode;
                        prev=nextnode;
                        //start=start.next;
                    }
                    //Swapping if element is in the middle
                    else{
                        Node nextnode=start.next;
                        start.next=nextnode.next;
                        nextnode.next=start;
                        prev.next=nextnode;
                        prev=nextnode;
                    }
                }
                else{
                    prev=start;
                    start=start.next;   
                }
            }
    }
    }
    //Insert at start
    public void insertStart(int data){
        
        Node temp=new Node(data);
        temp.next=head;
        head=temp;
    }
    
    //Delete from front
    public void deleteFront(){
        Node temp=head.next;
        head=temp;
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.insertStart(5);
        ll.insertStart(6);
        ll.insertStart(1);
        ll.insertStart(2);
        ll.insertStart(9);
        ll.insertStart(11);
       
        //Print liked list
        ll.print(head);
        
        int l=ll.length();
         
        System.out.println();
        
        System.out.println("3 group reverse");
        
        ll.head=ll.reverseKgrouporder(head,3);
        
        ll.print(ll.head);
        
        System.out.println();
        
        System.out.println(ll.kfromend(1));
        
        System.out.println(ll.kfromend(5));
        
        //ll.reverse();
        
        //ll.print();
        //System.out.println();
        
        //Length of linked list
        System.out.println("Length before deletion : "+l);
        
        ll.bubblesort();
        
        ll.print(head); 
        System.out.println();
        
        if(ll.findelement(9)==true){
            System.out.println("found...");
        }
        else{
            System.out.println("Not Found...");
        }
        
         System.out.println("mid element: "+ll.midelement());
        
        ll.deleteFront();
        
        ll.print(head);
        
        System.out.println("Length after deletion : "+ll.length());
        
        if(ll.findelement(9)==true){
            System.out.println("found...");
        }
        else{
            System.out.println("Not Found...");
        }
        System.out.println("mid element: "+ll.midelement());
        
        ll.bubblesort();
        
        ll.print(head);
        System.out.println();
        
        System.out.println("Iterative Recurse");
        ll.reverse();
        
        ll.print(head);
        System.out.println();
        
        System.out.println("Recursive Reverse");
        Node h2=ll.recReverse(head);
        
        ll.print(h2);
        
        System.out.println();
        
        ll.reorder(head);
    }
     public void print(Node head) {
        Node start=head;
        if(start==null){
            System.out.println("List is empty");
        }
        while(start!=null){
            System.out.print(start.data+" -> ");
            start=start.next;
        }
    }
}
