public class Hero {
    private String name;
    private int x;
    private int y;

    Hero(String name, int x, int y) throws Exception{
        this.name = name;
        if(x<0 || y<0){
            throw new NegativCoordinates();
        }
        this.x = x;
        this.y = y;
    }


}
