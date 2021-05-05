// Ben Fristad
public class DNode
{
    private String data;
    private DNode next;
    private DNode prev;

    public DNode(String data, DNode next, DNode prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;

    }// end EVC

    public String getData()
    {
        return this.data;

    }// end getData

    public DNode getNext()
    {
        return this.next;

    }// end getNext

    public DNode getPrev()
    {
        return this.prev;

    }// end getPrev

    public void setData(String data)
    {
        this.data = data;

    }// end setData

    public void setNext(DNode next)
    {
        this.next = next;

    }// end setNext

    public void setPrev(DNode prev)
    {
        this.prev = prev;

    }// end setPrev

}// end class