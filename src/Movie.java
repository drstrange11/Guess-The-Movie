public class Movie {
    private String name;
    private StringBuffer dummy;
    private int guesses;

    Movie (String name){
        this.name = name;
        guesses = 10;
        dummy = create_dummy(name.length());
    }
    private StringBuffer create_dummy(int length){
        StringBuffer sb = new StringBuffer(length);
        sb.append(" ".repeat(length));
        return sb;
    }
    public void reduce(){
        guesses--;
    }
    public int chance(){
        return guesses;
    }
    public String chosen(){
        return dummy.toString();
    }
    public void modify(int index,char c)
    {
        dummy.setCharAt(index,c);
    }


}
