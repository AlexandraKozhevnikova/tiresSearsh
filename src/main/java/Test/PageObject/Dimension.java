package Test.PageObject;

public enum Dimension {
    WIDTH("Ширина", 0),
    HEIGHT("Высота",1),
    DIAMETER("Диаметр",2);

    private String nameButton;
    private int index;

    Dimension(String nameButton, int index) {
        this.nameButton = nameButton;
        this.index = index;
    }

    public String getNameButton() {
        return nameButton;
    }
    public int getIndex(){
        return index;
    }

}
