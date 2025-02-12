package hospital_management_system;

public class Queue {
    Node front;
    Node rare;
    public void ENqueue(String data){
        if(front==null){
            Node newnode=new Node();
        newnode.data=data;
     front=newnode;
        rare=newnode;
        }
        else{
         Node cn=front;
        while (cn.next!=null){
            cn=cn.next;
        }
        Node newnode=new Node();
        newnode.data=data;
        cn.next=newnode;
        rare=newnode;
    }
    }
    public Node DEqueue(){
        Node cn=front;
        front=front.next;
        return cn;
        
    }
    
}
